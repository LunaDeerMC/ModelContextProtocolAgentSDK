package cn.lunadeer.mc.mcp.sdk.util;

import cn.lunadeer.mc.mcp.sdk.annotations.Param;
import cn.lunadeer.mc.mcp.sdk.annotations.Result;

import java.lang.reflect.*;
import java.util.*;

/**
 * Utility class for generating JSON Schema from Java method signatures.
 * <p>
 * This class helps automatically generate parameter and return schemas
 * for MCP capabilities based on their annotated methods.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class SchemaGenerator {

    /**
     * Generates a JSON Schema for method parameters.
     *
     * @param method the method to analyze
     * @return JSON Schema as a map
     */
    public static Map<String, Object> generateInputSchema(Method method) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "object");

        Map<String, Object> properties = new LinkedHashMap<>();
        List<String> required = new ArrayList<>();

        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            Param paramAnnotation = parameter.getAnnotation(Param.class);
            if (paramAnnotation != null) {
                String paramName = paramAnnotation.name();

                // Check if the parameter itself is a complex Record type
                // In this case, we should expand its fields directly
                Class<?> paramType = parameter.getType();
                if (isRecordType(paramType) && paramAnnotation.name().isEmpty()) {
                    // Record type without explicit name - expand fields
                    Map<String, Object> recordSchema = generateRecordSchema(paramType);
                    Object recordPropertiesObj = recordSchema.get("properties");
                    Object recordRequiredObj = recordSchema.get("required");

                    if (recordPropertiesObj instanceof Map) {
                        @SuppressWarnings("unchecked")
                        Map<String, Object> recordProperties = (Map<String, Object>) recordPropertiesObj;
                        properties.putAll(recordProperties);
                    }
                    if (recordRequiredObj instanceof List) {
                        @SuppressWarnings("unchecked")
                        List<String> recordRequired = (List<String>) recordRequiredObj;
                        required.addAll(recordRequired);
                    }
                } else {
                    // Normal parameter - use parameterized type to preserve generic information
                    Type paramTypeGeneric = parameter.getParameterizedType();
                    Map<String, Object> paramSchema = generateTypeSchema(paramTypeGeneric);
                    properties.put(paramName, paramSchema);

                    if (paramAnnotation.required()) {
                        required.add(paramName);
                    }
                }
            }
        }

        schema.put("properties", properties);
        if (!required.isEmpty()) {
            schema.put("required", required);
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for a single parameter.
     *
     * @param paramType       the parameter type
     * @param paramAnnotation the @Param annotation
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateInputPropertySchema(
            Class<?> paramType, Param paramAnnotation) {
        Map<String, Object> schema;

        // Check if the parameter type is an enum
        if (paramType.isEnum()) {
            schema = generateEnumSchema(paramType, paramAnnotation.enumValues());
        }
        // Check if the parameter type is an array
        else if (paramType.isArray()) {
            schema = generateTypeSchema(paramType);
        }
        // Check if the parameter type is a complex type (Record, POJO, etc.)
        else if (isRecordType(paramType) ||
                (!paramType.isPrimitive() &&
                        !paramType.equals(String.class) &&
                        !Number.class.isAssignableFrom(paramType) &&
                        !paramType.equals(Boolean.class) &&
                        !Collection.class.isAssignableFrom(paramType))) {
            // Complex object type - use full schema generation
            schema = generateTypeSchema(paramType);
        } else {
            // Simple type - use basic schema
            schema = new LinkedHashMap<>();
            String jsonType = getJsonType(paramType);
            schema.put("type", jsonType);

            // Add validation constraints for simple types
            if ("number".equals(jsonType) || "integer".equals(jsonType)) {
                if (paramAnnotation.min() != Double.MIN_VALUE) {
                    schema.put("minimum", paramAnnotation.min());
                }
                if (paramAnnotation.max() != Double.MAX_VALUE) {
                    schema.put("maximum", paramAnnotation.max());
                }
            }

            if ("string".equals(jsonType)) {
                if (!paramAnnotation.pattern().isEmpty()) {
                    schema.put("pattern", paramAnnotation.pattern());
                }
            }
        }

        // Add description
        if (!paramAnnotation.description().isEmpty()) {
            schema.put("description", paramAnnotation.description());
        }

        // Add default value
        if (!paramAnnotation.defaultValue().isEmpty()) {
            schema.put("default", parseDefaultValue(paramAnnotation.defaultValue()));
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for method return type.
     *
     * @param method the method to analyze
     * @return JSON Schema as a map
     */
    public static Map<String, Object> generateOutputSchema(Method method) {
        Class<?> returnType = method.getReturnType();
        return generateTypeSchema(returnType);
    }

    /**
     * Generates a JSON Schema for a given type (used for return types, nested objects, etc.).
     *
     * @param type the type to analyze
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateTypeSchema(Type type) {
        Map<String, Object> schema = new LinkedHashMap<>();

        // Handle parameterized types (e.g., List<String>, Map<K,V>)
        if (type instanceof ParameterizedType) {
            return generateParameterizedTypeSchema((ParameterizedType) type);
        }

        // Handle class types
        Class<?> clazz = (Class<?>) type;

        if (clazz == void.class || clazz == Void.class) {
            schema.put("type", "null");
        } else if (clazz == String.class) {
            schema.put("type", "string");
        } else if (clazz == int.class || clazz == Integer.class ||
                clazz == long.class || clazz == Long.class ||
                clazz == short.class || clazz == Short.class ||
                clazz == byte.class || clazz == Byte.class) {
            schema.put("type", "integer");
        } else if (clazz == float.class || clazz == Float.class ||
                clazz == double.class || clazz == Double.class) {
            schema.put("type", "number");
        } else if (clazz == boolean.class || clazz == Boolean.class) {
            schema.put("type", "boolean");
        } else if (clazz.isArray()) {
            // Array type
            schema.put("type", "array");
            Map<String, Object> itemsSchema = generateTypeSchema(clazz.getComponentType());
            schema.put("items", itemsSchema);
        } else if (clazz.isEnum()) {
            // Enum type - generate enum schema with all values
            return generateEnumSchema(clazz, new String[0]);
        } else if (isRecordType(clazz)) {
            // Record type - recursively parse fields
            return generateRecordSchema(clazz);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            // Collection without generic info - treat as array of any type
            schema.put("type", "array");
            schema.put("items", Collections.singletonMap("type", "object"));
        } else {
            // Unknown object type - try to parse as POJO
            return generatePojoSchema(clazz);
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for a parameterized type (e.g., List<PlayerInfo>).
     *
     * @param paramType the parameterized type
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateParameterizedTypeSchema(ParameterizedType paramType) {
        Map<String, Object> schema = new LinkedHashMap<>();
        Class<?> rawType = (Class<?>) paramType.getRawType();

        if (Collection.class.isAssignableFrom(rawType)) {
            schema.put("type", "array");

            // Get the generic type argument (e.g., PlayerInfo in List<PlayerInfo>)
            Type[] typeArgs = paramType.getActualTypeArguments();
            if (typeArgs.length > 0) {
                Map<String, Object> itemsSchema = generateTypeSchema(typeArgs[0]);
                schema.put("items", itemsSchema);
            } else {
                schema.put("items", Collections.singletonMap("type", "object"));
            }
        } else if (Map.class.isAssignableFrom(rawType)) {
            // Map<K, V> -> object with additionalProperties
            schema.put("type", "object");

            Type[] typeArgs = paramType.getActualTypeArguments();
            if (typeArgs.length >= 2) {
                // Value type determines the schema of properties
                Map<String, Object> valueSchema = generateTypeSchema(typeArgs[1]);
                schema.put("additionalProperties", valueSchema);
            }
        } else {
            // Other parameterized types - treat as object
            schema.put("type", "object");
            schema.put("description", "Instance of " + rawType.getSimpleName());
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for an enum type.
     *
     * @param enumClass  the enum class
     * @param enumValues the allowed enum values (if empty, all enum values are used)
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateEnumSchema(Class<?> enumClass, String[] enumValues) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "string");
        schema.put("description", "Enum: " + enumClass.getSimpleName());

        // Get all enum constants
        Object[] enumConstants = enumClass.getEnumConstants();
        List<String> allowedValues = new ArrayList<>();

        if (enumValues != null && enumValues.length > 0) {
            // Use specified enum values
            for (String value : enumValues) {
                // Validate that the value exists in the enum
                try {
                    Enum.valueOf((Class<Enum>) enumClass, value);
                    allowedValues.add(value);
                } catch (IllegalArgumentException e) {
                    // Skip invalid enum values
                }
            }
        } else {
            // Use all enum constants
            for (Object constant : enumConstants) {
                allowedValues.add(constant.toString());
            }
        }

        if (!allowedValues.isEmpty()) {
            schema.put("enum", allowedValues);
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for a Record class.
     *
     * @param recordClass the record class
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateRecordSchema(Class<?> recordClass) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "object");
        schema.put("description", "Instance of " + recordClass.getSimpleName());

        Map<String, Object> properties = new LinkedHashMap<>();
        List<String> required = new ArrayList<>();
        Set<String> requiredSet = new LinkedHashSet<>(); // Use Set to avoid duplicates

        try {
            // Get record components (fields)
            java.lang.reflect.RecordComponent[] components = recordClass.getRecordComponents();

            for (java.lang.reflect.RecordComponent component : components) {
                String fieldName = component.getName();
                Type fieldType = component.getGenericType();

                // Generate schema for the field type
                Map<String, Object> fieldSchema = generateTypeSchema(fieldType);

                // Check for @Result annotation on the component (for output types)
                Result resultAnnotation = component.getAnnotation(Result.class);
                if (resultAnnotation != null) {
                    applyOutputAnnotations(fieldSchema, resultAnnotation);
                    if (resultAnnotation.required()) {
                        requiredSet.add(fieldName);
                    }
                    // Use custom name if provided
                    if (!resultAnnotation.name().isEmpty()) {
                        fieldName = resultAnnotation.name();
                    }
                }

                // Check for @Param annotation on the component (for input types)
                Param paramAnnotation = component.getAnnotation(Param.class);
                if (paramAnnotation != null) {
                    applyInputAnnotations(fieldSchema, paramAnnotation);
                    if (paramAnnotation.required()) {
                        requiredSet.add(fieldName);
                    }
                    // Use custom name if provided
                    if (!paramAnnotation.name().isEmpty()) {
                        fieldName = paramAnnotation.name();
                    }
                }

                properties.put(fieldName, fieldSchema);
            }
        } catch (Exception e) {
            // Fallback: if we can't introspect the record, just return basic object schema
            // This shouldn't happen for valid records
        }

        schema.put("properties", properties);
        if (!requiredSet.isEmpty()) {
            required.addAll(requiredSet);
            schema.put("required", required);
        }

        return schema;
    }

    /**
     * Generates a JSON Schema for a POJO class (non-record).
     *
     * @param clazz the class to analyze
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generatePojoSchema(Class<?> clazz) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "object");
        schema.put("description", "Instance of " + clazz.getSimpleName());

        Map<String, Object> properties = new LinkedHashMap<>();
        List<String> required = new ArrayList<>();

        // Get all fields (including private ones)
        for (Field field : clazz.getDeclaredFields()) {
            // Skip synthetic and static fields
            if (field.isSynthetic() || Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            String fieldName = field.getName();
            Type fieldType = field.getGenericType();

            // Generate schema for the field type
            Map<String, Object> fieldSchema = generateTypeSchema(fieldType);

            // Check for @Result annotation on the field (for output types)
            Result resultAnnotation = field.getAnnotation(Result.class);
            if (resultAnnotation != null) {
                applyOutputAnnotations(fieldSchema, resultAnnotation);
                if (resultAnnotation.required()) {
                    required.add(fieldName);
                }
                // Use custom name if provided
                if (!resultAnnotation.name().isEmpty()) {
                    fieldName = resultAnnotation.name();
                }
            }

            // Check for @Param annotation on the field (for input types)
            Param paramAnnotation = field.getAnnotation(Param.class);
            if (paramAnnotation != null) {
                applyInputAnnotations(fieldSchema, paramAnnotation);
                if (paramAnnotation.required()) {
                    required.add(fieldName);
                }
                // Use custom name if provided
                if (!paramAnnotation.name().isEmpty()) {
                    fieldName = paramAnnotation.name();
                }
            }

            properties.put(fieldName, fieldSchema);
        }

        schema.put("properties", properties);
        if (!required.isEmpty()) {
            schema.put("required", required);
        }

        return schema;
    }

    /**
     * Applies @Result annotation constraints to a schema.
     *
     * @param schema           the schema to modify
     * @param resultAnnotation the annotation to apply
     */
    private static void applyOutputAnnotations(Map<String, Object> schema, Result resultAnnotation) {
        // Add description
        if (!resultAnnotation.description().isEmpty()) {
            schema.put("description", resultAnnotation.description());
        }

        String type = (String) schema.get("type");

        // Add numeric constraints
        if ("number".equals(type) || "integer".equals(type)) {
            if (resultAnnotation.min() != Double.MIN_VALUE) {
                schema.put("minimum", resultAnnotation.min());
            }
            if (resultAnnotation.max() != Double.MAX_VALUE) {
                schema.put("maximum", resultAnnotation.max());
            }
        }

        // Add string constraints
        if ("string".equals(type)) {
            if (!resultAnnotation.pattern().isEmpty()) {
                schema.put("pattern", resultAnnotation.pattern());
            }
            if (resultAnnotation.minLength() > 0) {
                schema.put("minLength", resultAnnotation.minLength());
            }
            if (resultAnnotation.maxLength() < Integer.MAX_VALUE) {
                schema.put("maxLength", resultAnnotation.maxLength());
            }
        }

        // Add array constraints
        if ("array".equals(type)) {
            if (resultAnnotation.minLength() > 0) {
                schema.put("minItems", resultAnnotation.minLength());
            }
            if (resultAnnotation.maxLength() < Integer.MAX_VALUE) {
                schema.put("maxItems", resultAnnotation.maxLength());
            }
        }

        // Add enum values constraint (for string type with enum)
        if ("string".equals(type) && resultAnnotation.enumValues().length > 0) {
            List<String> enumValues = new ArrayList<>(Arrays.asList(resultAnnotation.enumValues()));
            schema.put("enum", enumValues);
        }
    }

    /**
     * Applies @Param annotation constraints to a schema.
     *
     * @param schema          the schema to modify
     * @param paramAnnotation the annotation to apply
     */
    private static void applyInputAnnotations(Map<String, Object> schema, Param paramAnnotation) {
        // Add description
        if (!paramAnnotation.description().isEmpty()) {
            schema.put("description", paramAnnotation.description());
        }

        String type = (String) schema.get("type");

        // Add numeric constraints
        if ("number".equals(type) || "integer".equals(type)) {
            if (paramAnnotation.min() != Double.MIN_VALUE) {
                schema.put("minimum", paramAnnotation.min());
            }
            if (paramAnnotation.max() != Double.MAX_VALUE) {
                schema.put("maximum", paramAnnotation.max());
            }
        }

        // Add string constraints
        if ("string".equals(type)) {
            if (!paramAnnotation.pattern().isEmpty()) {
                schema.put("pattern", paramAnnotation.pattern());
            }
            if (paramAnnotation.minLength() > 0) {
                schema.put("minLength", paramAnnotation.minLength());
            }
            if (paramAnnotation.maxLength() < Integer.MAX_VALUE) {
                schema.put("maxLength", paramAnnotation.maxLength());
            }
        }

        // Add array constraints
        if ("array".equals(type)) {
            if (paramAnnotation.minLength() > 0) {
                schema.put("minItems", paramAnnotation.minLength());
            }
            if (paramAnnotation.maxLength() < Integer.MAX_VALUE) {
                schema.put("maxItems", paramAnnotation.maxLength());
            }
        }

        // Add enum values constraint (for string type with enum)
        if ("string".equals(type) && paramAnnotation.enumValues().length > 0) {
            List<String> enumValues = new ArrayList<>(Arrays.asList(paramAnnotation.enumValues()));
            schema.put("enum", enumValues);
        }

        // Add default value
        if (!paramAnnotation.defaultValue().isEmpty()) {
            schema.put("default", parseDefaultValue(paramAnnotation.defaultValue()));
        }
    }

    /**
     * Checks if a class is a Record (Java 16+).
     *
     * @param clazz the class to check
     * @return true if the class is a record
     */
    private static boolean isRecordType(Class<?> clazz) {
        return clazz.isRecord();
    }

    /**
     * Maps Java type to JSON Schema type.
     *
     * @param javaType the Java class
     * @return JSON Schema type string
     */
    private static String getJsonType(Class<?> javaType) {
        if (javaType == String.class) {
            return "string";
        } else if (javaType == int.class || javaType == Integer.class ||
                javaType == long.class || javaType == Long.class ||
                javaType == short.class || javaType == Short.class ||
                javaType == byte.class || javaType == Byte.class) {
            return "integer";
        } else if (javaType == float.class || javaType == Float.class ||
                javaType == double.class || javaType == Double.class) {
            return "number";
        } else if (javaType == boolean.class || javaType == Boolean.class) {
            return "boolean";
        } else if (javaType.isArray() || Collection.class.isAssignableFrom(javaType)) {
            return "array";
        } else {
            return "object";
        }
    }

    /**
     * Parses a default value string to appropriate type.
     *
     * @param defaultValue the default value string
     * @return parsed value
     */
    private static Object parseDefaultValue(String defaultValue) {
        if ("true".equalsIgnoreCase(defaultValue) || "false".equalsIgnoreCase(defaultValue)) {
            return Boolean.parseBoolean(defaultValue);
        }

        try {
            if (defaultValue.contains(".")) {
                return Double.parseDouble(defaultValue);
            } else {
                return Integer.parseInt(defaultValue);
            }
        } catch (NumberFormatException e) {
            // Return as string
            return defaultValue;
        }
    }
}
