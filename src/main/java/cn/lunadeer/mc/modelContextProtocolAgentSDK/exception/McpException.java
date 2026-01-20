package cn.lunadeer.mc.modelContextProtocolAgentSDK.exception;

/**
 * Base exception for all MCP-related errors.
 * <p>
 * All custom exceptions in the MCP Agent SDK extend this class.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class McpException extends RuntimeException {
    
    private String errorCode;
    
    /**
     * Creates a new MCP exception.
     * 
     * @param message the error message
     */
    public McpException(String message) {
        super(message);
    }
    
    /**
     * Creates a new MCP exception with a cause.
     * 
     * @param message the error message
     * @param cause the underlying cause
     */
    public McpException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Creates a new MCP exception with an error code.
     * 
     * @param errorCode the error code
     * @param message the error message
     */
    public McpException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
    
    /**
     * Creates a new MCP exception with an error code and cause.
     * 
     * @param errorCode the error code
     * @param message the error message
     * @param cause the underlying cause
     */
    public McpException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    
    /**
     * Gets the error code.
     * 
     * @return the error code, or null if not set
     */
    public String getErrorCode() {
        return errorCode;
    }
}
