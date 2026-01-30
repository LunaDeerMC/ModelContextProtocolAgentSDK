package cn.lunadeer.mc.mcp.sdk.annotations;

import java.lang.annotation.*;

/**
 * Marks a method parameter or record component for MCP capability methods.
 * <p>
 * This annotation provides metadata about parameters for automatic
 * validation, schema generation, and documentation.
 * </p>
 * <p>
 * <strong>Usage on method parameters:</strong>
 * <pre>{@code
 * @McpAction(id = "player.teleport", ...)
 * public void teleportPlayer(
 *     @Param(name = "playerName", description = "Player to teleport", required = true)
 *     String playerName,
 *
 *     @Param(name = "location", description = "Target location")
 *     LocationInfo location
 * ) { ... }
 * }</pre>
 * </p>
 * <p>
 * <strong>Usage on Record components (for input types):</strong>
 * <pre>{@code
 * public record LocationInfo(
 *     @Param(description = "X coordinate", required = true)
 *     double x,
 *
 *     @Param(description = "Y coordinate", required = true)
 *     double y,
 *
 *     @Param(description = "Z coordinate", required = true)
 *     double z
 * ) {}
 * }</pre>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target({ElementType.PARAMETER, ElementType.RECORD_COMPONENT, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {

    /**
     * Name of the parameter or field.
     * For method parameters: used in the JSON request payload.
     * For Record components: the component name (auto-detected if empty).
     *
     * @return the name, defaults to empty (auto-detected for Record components)
     */
    String name() default "";

    /**
     * Whether this parameter/field is required.
     * If true and the parameter is missing, validation will fail.
     *
     * @return true if required, defaults to false
     */
    boolean required() default false;

    /**
     * Description of the parameter/field.
     *
     * @return the description
     */
    String description() default "";

    /**
     * Default value for the parameter in JSON format.
     * Used when the parameter is not provided in the request.
     *
     * @return the default value as JSON string
     */
    String defaultValue() default "";

    /**
     * Minimum value for numeric parameters/fields.
     * Only applicable to numeric types.
     *
     * @return the minimum value, defaults to Double.MIN_VALUE
     */
    double min() default Double.MIN_VALUE;

    /**
     * Maximum value for numeric parameters/fields.
     * Only applicable to numeric types.
     *
     * @return the maximum value, defaults to Double.MAX_VALUE
     */
    double max() default Double.MAX_VALUE;

    /**
     * Regular expression pattern for string parameters/fields.
     * Only applicable to string types.
     *
     * @return the regex pattern
     */
    String pattern() default "";

    /**
     * Minimum length for string or array parameters/fields.
     *
     * @return the minimum length, defaults to 0
     */
    int minLength() default 0;

    /**
     * Maximum length for string or array parameters/fields.
     *
     * @return the maximum length, defaults to Integer.MAX_VALUE
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * Enum values for enum type parameters/fields.
     * When specified, the parameter is restricted to these enum constant names.
     * Only applicable to enum types.
     *
     * @return the allowed enum values as strings
     */
    String[] enumValues() default {};
}
