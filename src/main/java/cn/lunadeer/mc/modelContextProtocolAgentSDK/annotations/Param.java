package cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations;

import java.lang.annotation.*;

/**
 * Marks a method parameter for MCP capability methods.
 * <p>
 * This annotation provides metadata about parameters for automatic
 * validation, schema generation, and documentation.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Param {
    
    /**
     * Name of the parameter.
     * This name will be used in the JSON request payload.
     * 
     * @return the parameter name
     */
    String name();
    
    /**
     * Whether this parameter is required.
     * If true and the parameter is missing, validation will fail.
     * 
     * @return true if required, defaults to false
     */
    boolean required() default false;
    
    /**
     * Description of the parameter.
     * 
     * @return the parameter description
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
     * Minimum value for numeric parameters.
     * Only applicable to numeric types.
     * 
     * @return the minimum value, defaults to Double.MIN_VALUE
     */
    double min() default Double.MIN_VALUE;
    
    /**
     * Maximum value for numeric parameters.
     * Only applicable to numeric types.
     * 
     * @return the maximum value, defaults to Double.MAX_VALUE
     */
    double max() default Double.MAX_VALUE;
    
    /**
     * Regular expression pattern for string parameters.
     * Only applicable to string types.
     * 
     * @return the regex pattern
     */
    String pattern() default "";
}
