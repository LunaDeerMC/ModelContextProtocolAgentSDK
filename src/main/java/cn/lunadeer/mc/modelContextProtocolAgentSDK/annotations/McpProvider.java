package cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations;

import java.lang.annotation.*;

/**
 * Marks a class as an MCP capability provider.
 * <p>
 * Classes annotated with this annotation will be scanned and registered
 * by the MCP Agent to provide capabilities to external clients.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpProvider {

    /**
     * Unique identifier for the provider.
     * <p>
     * Format: lowercase letters, numbers, and hyphens only.
     * Example: "mcp-agent-core", "ext.shopkeeper"
     * </p>
     *
     * @return the provider ID
     */
    String id();

    /**
     * Display name of the provider.
     *
     * @return the provider display name
     */
    String name();

    /**
     * Version of the provider following semantic versioning.
     *
     * @return the provider version, defaults to "1.0.0"
     */
    String version() default "1.0.0";

    /**
     * Description of the provider and its capabilities.
     *
     * @return the provider description
     */
    String description() default "";
}
