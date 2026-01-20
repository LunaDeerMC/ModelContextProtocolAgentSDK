package cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.RiskLevel;

import java.lang.annotation.*;

/**
 * Marks a method as an Action capability (write operation).
 * <p>
 * Action capabilities modify the Minecraft server state and require
 * additional safety measures such as risk assessment, snapshots, and
 * permission checks.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpAction {
    
    /**
     * Unique identifier for the capability.
     * <p>
     * Format: {namespace}.{capability}
     * Example: "world.time.set", "player.teleport"
     * </p>
     * 
     * @return the capability ID
     */
    String id();
    
    /**
     * Display name of the capability.
     * 
     * @return the capability display name
     */
    String name();
    
    /**
     * Description of what the capability does.
     * 
     * @return the capability description
     */
    String description() default "";
    
    /**
     * Version of the capability following semantic versioning.
     * 
     * @return the capability version, defaults to "1.0.0"
     */
    String version() default "1.0.0";
    
    /**
     * Risk level of this action.
     * Higher risk levels require additional safety checks.
     * 
     * @return the risk level, defaults to MEDIUM
     */
    RiskLevel risk() default RiskLevel.MEDIUM;
    
    /**
     * Whether this action supports rollback.
     * If true, the action can be reverted using a snapshot.
     * 
     * @return true if rollback is supported, defaults to false
     */
    boolean rollbackSupported() default false;
    
    /**
     * Whether a snapshot is required before executing this action.
     * If true, the system will create a snapshot before execution.
     * 
     * @return true if snapshot is required, defaults to false
     */
    boolean snapshotRequired() default false;
    
    /**
     * Required permissions to invoke this capability.
     * 
     * @return array of permission strings
     */
    String[] permissions() default {};
    
    /**
     * Tags for categorizing and filtering capabilities.
     * 
     * @return array of tag strings
     */
    String[] tags() default {};
    
    /**
     * Whether confirmation is required before executing this action.
     * 
     * @return true if confirmation is required, defaults to false
     */
    boolean confirmRequired() default false;
}
