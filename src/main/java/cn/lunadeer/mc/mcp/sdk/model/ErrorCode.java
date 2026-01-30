package cn.lunadeer.mc.mcp.sdk.model;

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
public enum ErrorCode {

    // General errors (1xxx)
    INTERNAL_ERROR("1000", "An internal error occurred."),
    INVALID_REQUEST("1001", "The request is invalid or malformed."),
    CAPABILITY_NOT_FOUND("1002", "The requested capability was not found."),
    PROVIDER_NOT_FOUND("1003", "The specified provider does not exist."),

    // Validation errors (2xxx)
    VALIDATION_FAILED("2000", "Validation failed."),
    PARAMETER_REQUIRED("2001", "Parameter required."),
    PARAMETER_INVALID("2002", "Parameter invalid."),
    SCHEMA_VALIDATION_FAILED("2003", "Schema validation failed."),

    // Security errors (3xxx)
    PERMISSION_DENIED("3000", "Permission denied."),
    RATE_LIMIT_EXCEEDED("3001", "Rate limit exceeded."),
    APPROVAL_REQUIRED("3002", "Approval required."),
    AUTHENTICATION_FAILED("3003", "Authentication failed."),

    // Business errors (4xxx)
    PLAYER_NOT_FOUND("4000", "Player not found."),
    PLAYER_OFFLINE("4001", "Player offline."),
    WORLD_NOT_FOUND("4002", "World not found."),
    ENTITY_NOT_FOUND("4003", "Entity not found."),
    INSUFFICIENT_BALANCE("4004", "Insufficient balance."),
    OPERATION_FAILED("4005", "Operation failed."),

    // System errors (5xxx)
    COMMUNICATION_ERROR("5000", "Communication error."),
    CONNECTION_LOST("5001", "Connection lost."),
    TIMEOUT("5002", "Timeout."),
    ROLLBACK_FAILED("5003", "Rollback failed."),
    SNAPSHOT_FAILED("5004", "Snapshot failed.");

    private final String errorCode;
    private final String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private ErrorCode(String code, String message) {
        this.errorCode = code;
        this.errorMessage = message;
    }
}
