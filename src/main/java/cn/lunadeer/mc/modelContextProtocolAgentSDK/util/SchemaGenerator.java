package cn.lunadeer.mc.modelContextProtocolAgentSDK.util;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Param;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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
    public static Map<String, Object> generateParameterSchema(Method method) {
        Map<String, Object> schema = new LinkedHashMap<>();
        schema.put("type", "object");
        
        Map<String, Object> properties = new LinkedHashMap<>();
        List<String> required = new ArrayList<>();
        
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            Param paramAnnotation = parameter.getAnnotation(Param.class);
            if (paramAnnotation != null) {
                String paramName = paramAnnotation.name();
                Map<String, Object> paramSchema = generateParameterPropertySchema(
                        parameter.getType(), paramAnnotation);
                properties.put(paramName, paramSchema);
                
                if (paramAnnotation.required()) {
                    required.add(paramName);
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
     * @param paramType the parameter type
     * @param paramAnnotation the @Param annotation
     * @return JSON Schema as a map
     */
    private static Map<String, Object> generateParameterPropertySchema(
            Class<?> paramType, Param paramAnnotation) {
        Map<String, Object> schema = new LinkedHashMap<>();
        
        // Determine JSON type
        String jsonType = getJsonType(paramType);
        schema.put("type", jsonType);
        
        // Add description
        if (!paramAnnotation.description().isEmpty()) {
            schema.put("description", paramAnnotation.description());
        }
        
        // Add validation constraints
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
    public static Map<String, Object> generateReturnSchema(Method method) {
        Map<String, Object> schema = new LinkedHashMap<>();
        Class<?> returnType = method.getReturnType();
        
        if (returnType == void.class || returnType == Void.class) {
            schema.put("type", "null");
        } else {
            String jsonType = getJsonType(returnType);
            schema.put("type", jsonType);
            
            if ("object".equals(jsonType)) {
                schema.put("description", "Returns " + returnType.getSimpleName());
            }
        }
        
        return schema;
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
