package cn.lunadeer.mc.mcp.sdk.api;

/**
 * Main entry point for the MCP Agent API.
 * <p>
 * This interface provides access to core MCP Agent functionality
 * and can be retrieved from Bukkit's service manager.
 * </p>
 * <p>
 * Example usage:
 * <pre>{@code
 * McpAgent mcpAgent = Bukkit.getServicesManager()
 *     .load(McpAgent.class);
 * if (mcpAgent != null) {
 *     McpProviderRegistry registry = mcpAgent.getProviderRegistry();
 *     registry.register(new MyProvider());
 * }
 * }</pre>
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public interface McpServer {

    /**
     * Gets the provider registry.
     *
     * @return the provider registry instance
     */
    McpProviderRegistry getProviderRegistry();

    /**
     * Gets the event emitter.
     *
     * @return the event emitter instance
     */
    McpEventEmitter getEventEmitter();

    /**
     * Gets the agent version.
     *
     * @return the version string
     */
    String getVersion();

    /**
     * Checks if the agent is connected to the gateway.
     *
     * @return true if connected
     */
    boolean isConnected();

    /**
     * Gets the agent's unique identifier.
     *
     * @return the agent ID
     */
    String getAgentId();
}
