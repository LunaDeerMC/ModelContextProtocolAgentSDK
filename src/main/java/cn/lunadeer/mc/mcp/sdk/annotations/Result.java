package cn.lunadeer.mc.mcp.sdk.annotations;

import java.lang.annotation.*;

/**
 * Marks a record component or field for MCP capability return value schema generation.
 * <p>
 * This annotation provides metadata about return value structure for automatic
 * schema generation and documentation. It should be used on record components
 * or fields of classes used as return types.
 * </p>
 * <p>
 * <strong>Usage on Record classes:</strong>
 * <pre>{@code
 * public record PlayerInfo(
 *     @Result(name = "playerName", description = "Player name", required = true)
 *     String name,
 *
 *     @Result(description = "Player level", min = 0, max = 999)
 *     int level,
 *
 *     @Result(description = "Player location")
 *     LocationInfo location
 * ) {}
 * }</pre>
 * </p>
 * <p>
 * <strong>Note:</strong> You can use either @Param or @Result on Record components.
 *
 * @author ZhangYuheng
 * @Param is for input types, @Result is for output types. Both support the same
 * validation constraints and can be used interchangeably.
 * </p>
 * @since 1.0.0
 */
@Target({ElementType.RECORD_COMPONENT, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Result {

    /**
     * Name of the field/property.
     * For Record components: the component name (auto-detected if empty).
     *
     * @return the name, defaults to empty (auto-detected for Record components)
     */
    String name() default "";

    /**
     * Description of the field/property.
     *
     * @return the field description
     */
    String description() default "";

    /**
     * Whether this field is required.
     * Only applicable to object properties.
     *
     * @return true if required, defaults to false
     */
    boolean required() default false;

    /**
     * Minimum value for numeric fields.
     * Only applicable to numeric types.
     *
     * @return the minimum value, defaults to Double.MIN_VALUE
     */
    double min() default Double.MIN_VALUE;

    /**
     * Maximum value for numeric fields.
     * Only applicable to numeric types.
     *
     * @return the maximum value, defaults to Double.MAX_VALUE
     */
    double max() default Double.MAX_VALUE;

    /**
     * Regular expression pattern for string fields.
     * Only applicable to string types.
     *
     * @return the regex pattern
     */
    String pattern() default "";

    /**
     * Minimum length for string or array fields.
     *
     * @return the minimum length, defaults to 0
     */
    int minLength() default 0;

    /**
     * Maximum length for string or array fields.
     *
     * @return the maximum length, defaults to Integer.MAX_VALUE
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * Enum values for enum type fields.
     * When specified, the field is restricted to these enum constant names.
     * Only applicable to enum types.
     *
     * @return the allowed enum values as strings
     */
    String[] enumValues() default {};
}
