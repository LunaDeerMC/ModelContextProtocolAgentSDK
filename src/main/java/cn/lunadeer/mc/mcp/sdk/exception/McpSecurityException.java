package cn.lunadeer.mc.mcp.sdk.exception;

/**
 * Exception thrown for security-related errors.
 * <p>
 * This exception is used when security checks fail, such as:
 * <ul>
 *   <li>Permission denied</li>
 *   <li>Rate limit exceeded</li>
 *   <li>Approval required but not provided</li>
 *   <li>Authentication failure</li>
 * </ul>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class McpSecurityException extends McpException {

    /**
     * Creates a new security exception.
     *
     * @param message the error message
     */
    public McpSecurityException(String message) {
        super(message);
    }

    /**
     * Creates a new security exception with a cause.
     *
     * @param message the error message
     * @param cause   the underlying cause
     */
    public McpSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new security exception with an error code.
     *
     * @param errorCode the error code
     * @param message   the error message
     */
    public McpSecurityException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Creates a new security exception with an error code and cause.
     *
     * @param errorCode the error code
     * @param message   the error message
     * @param cause     the underlying cause
     */
    public McpSecurityException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
