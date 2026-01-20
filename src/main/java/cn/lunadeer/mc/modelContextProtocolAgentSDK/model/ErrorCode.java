package cn.lunadeer.mc.modelContextProtocolAgentSDK.model;

/**
 * Standard error codes for MCP operations.
 * <p>
 * These error codes provide a standardized way to communicate errors
 * between the agent and clients.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class ErrorCode {
    
    // General errors (1xxx)
    public static final String INTERNAL_ERROR = "1000";
    public static final String INVALID_REQUEST = "1001";
    public static final String CAPABILITY_NOT_FOUND = "1002";
    public static final String PROVIDER_NOT_FOUND = "1003";
    
    // Validation errors (2xxx)
    public static final String VALIDATION_FAILED = "2000";
    public static final String PARAMETER_REQUIRED = "2001";
    public static final String PARAMETER_INVALID = "2002";
    public static final String SCHEMA_VALIDATION_FAILED = "2003";
    
    // Security errors (3xxx)
    public static final String PERMISSION_DENIED = "3000";
    public static final String RATE_LIMIT_EXCEEDED = "3001";
    public static final String APPROVAL_REQUIRED = "3002";
    public static final String AUTHENTICATION_FAILED = "3003";
    
    // Business errors (4xxx)
    public static final String PLAYER_NOT_FOUND = "4000";
    public static final String PLAYER_OFFLINE = "4001";
    public static final String WORLD_NOT_FOUND = "4002";
    public static final String ENTITY_NOT_FOUND = "4003";
    public static final String INSUFFICIENT_BALANCE = "4004";
    public static final String OPERATION_FAILED = "4005";
    
    // System errors (5xxx)
    public static final String COMMUNICATION_ERROR = "5000";
    public static final String CONNECTION_LOST = "5001";
    public static final String TIMEOUT = "5002";
    public static final String ROLLBACK_FAILED = "5003";
    public static final String SNAPSHOT_FAILED = "5004";
    
    private ErrorCode() {
        // Utility class, prevent instantiation
    }
}
