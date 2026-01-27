package cn.lunadeer.mc.modelContextProtocolAgentSDK.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Utility class for JSON serialization and deserialization.
 * <p>
 * Provides convenient methods for working with JSON data in MCP capabilities.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class JsonUtil {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final Gson GSON_COMPACT = new GsonBuilder()
            .create();

    /**
     * Converts an object to JSON string with pretty printing.
     *
     * @param object the object to serialize
     * @return JSON string
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    /**
     * Converts an object to compact JSON string.
     *
     * @param object the object to serialize
     * @return compact JSON string
     */
    public static String toJsonCompact(Object object) {
        return GSON_COMPACT.toJson(object);
    }

    /**
     * Parses JSON string to an object of specified type.
     *
     * @param json     the JSON string
     * @param classOfT the class of the target type
     * @param <T>      the target type
     * @return the deserialized object
     * @throws JsonSyntaxException if JSON is malformed
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    /**
     * Parses JSON string to an object of specified type.
     *
     * @param json    the JSON string
     * @param typeOfT the type of the target
     * @param <T>     the target type
     * @return the deserialized object
     * @throws JsonSyntaxException if JSON is malformed
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

    /**
     * Parses JSON string to a map.
     *
     * @param json the JSON string
     * @return map representation of JSON
     * @throws JsonSyntaxException if JSON is malformed
     */
    public static Map<String, Object> toMap(String json) {
        Type type = new TypeToken<Map<String, Object>>() {
        }.getType();
        return GSON.fromJson(json, type);
    }

    /**
     * Converts an object to a JsonElement.
     *
     * @param object the object to convert
     * @return JsonElement representation
     */
    public static JsonElement toJsonElement(Object object) {
        return GSON.toJsonTree(object);
    }

    /**
     * Converts a JsonElement to an object of specified type.
     *
     * @param element  the JsonElement
     * @param classOfT the class of the target type
     * @param <T>      the target type
     * @return the deserialized object
     */
    public static <T> T fromJsonElement(JsonElement element, Class<T> classOfT) {
        return GSON.fromJson(element, classOfT);
    }

    /**
     * Checks if a string is valid JSON.
     *
     * @param json the string to check
     * @return true if valid JSON
     */
    public static boolean isValidJson(String json) {
        try {
            JsonParser.parseString(json);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }
}
