package cn.lunadeer.mc.modelContextProtocolAgentSDK.exception;

/**
 * Exception thrown for business logic errors.
 * <p>
 * This exception is used when a capability cannot complete due to
 * business rules or invalid state, such as:
 * <ul>
 *   <li>Player not found</li>
 *   <li>World not found</li>
 *   <li>Insufficient balance</li>
 *   <li>Operation not allowed</li>
 * </ul>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class McpBusinessException extends McpException {

    /**
     * Creates a new business exception.
     *
     * @param message the error message
     */
    public McpBusinessException(String message) {
        super(message);
    }

    /**
     * Creates a new business exception with a cause.
     *
     * @param message the error message
     * @param cause   the underlying cause
     */
    public McpBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new business exception with an error code.
     *
     * @param errorCode the error code
     * @param message   the error message
     */
    public McpBusinessException(String errorCode, String message) {
        super(errorCode, message);
    }

    /**
     * Creates a new business exception with an error code and cause.
     *
     * @param errorCode the error code
     * @param message   the error message
     * @param cause     the underlying cause
     */
    public McpBusinessException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }
}
