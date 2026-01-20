package cn.lunadeer.mc.modelContextProtocolAgentSDK.model;

/**
 * Defines the type of MCP capability.
 * <p>
 * Each type has different characteristics and safety requirements.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public enum CapabilityType {
    
    /**
     * Context capability - read-only query.
     * <p>
     * Retrieves information without modifying server state.
     * Considered safe and can be cached.
     * </p>
     */
    CONTEXT,
    
    /**
     * Action capability - write operation.
     * <p>
     * Modifies server state and requires safety checks.
     * Subject to risk assessment and may require snapshots.
     * </p>
     */
    ACTION,
    
    /**
     * Event capability - event subscription.
     * <p>
     * Allows external clients to receive notifications
     * when specific Minecraft events occur.
     * </p>
     */
    EVENT
}
