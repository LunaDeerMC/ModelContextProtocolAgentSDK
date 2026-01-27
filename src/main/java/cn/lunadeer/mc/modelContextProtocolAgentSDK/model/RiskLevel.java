package cn.lunadeer.mc.modelContextProtocolAgentSDK.model;

/**
 * Defines the risk level of an action capability.
 * <p>
 * Higher risk levels trigger additional safety measures such as:
 * <ul>
 *   <li>Snapshot creation before execution</li>
 *   <li>Approval requirements</li>
 *   <li>Enhanced audit logging</li>
 *   <li>Rate limiting</li>
 * </ul>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public enum RiskLevel {

    /**
     * Low risk - minimal impact on server state.
     * <p>
     * Examples: sending messages, getting player info
     * </p>
     */
    LOW,

    /**
     * Medium risk - moderate impact on server state.
     * <p>
     * Examples: teleporting players, setting time
     * </p>
     */
    MEDIUM,

    /**
     * High risk - significant impact on server state.
     * <p>
     * Examples: banning players, removing entities, modifying game rules
     * Requires snapshot before execution.
     * </p>
     */
    HIGH,

    /**
     * Critical risk - severe impact on server state.
     * <p>
     * Examples: restoring backups, stopping server, bulk operations
     * Requires explicit approval and snapshot.
     * </p>
     */
    CRITICAL
}
