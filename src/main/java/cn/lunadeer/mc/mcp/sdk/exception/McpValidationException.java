package cn.lunadeer.mc.mcp.sdk.exception;

/**
 * Exception thrown for parameter validation errors.
 * <p>
 * This exception is used when request parameters fail validation, such as:
 * <ul>
 *   <li>Required parameter missing</li>
 *   <li>Invalid parameter format</li>
 *   <li>Value out of range</li>
 *   <li>Schema validation failure</li>
 * </ul>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class McpValidationException extends McpException {

    /**
     * Creates a new validation exception.
     *
     * @param message the error message
     */
    public McpValidationException(String message) {
        super(message);
    }

    /**
     * Creates a new validation exception with a cause.
     *
     * @param message the error message
     * @param cause   the underlying cause
     */
    public McpValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new validation exception with an error code.
     *
     * @param errorCode the error code
     * @param message   the error message
     */
    public McpValidationException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Creates a new validation exception with an error code and cause.
     *
     * @param errorCode the error code
     * @param message   the error message
     * @param cause     the underlying cause
     */
    public McpValidationException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
