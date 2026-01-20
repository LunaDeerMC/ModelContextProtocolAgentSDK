package cn.lunadeer.mc.modelContextProtocolAgentSDK.api;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.CapabilityManifest;
import org.bukkit.plugin.Plugin;

import java.util.List;

/**
 * Registry for MCP capability providers.
 * <p>
 * Third-party plugins use this interface to register their capability providers
 * with the MCP Agent. The registry scans annotated methods and makes them
 * available to external clients.
 * </p>
 * <p>
 * Example usage:
 * <pre>{@code
 * McpProviderRegistry registry = Bukkit.getServicesManager()
 *     .load(McpProviderRegistry.class);
 * if (registry != null) {
 *     registry.register(new MyProvider());
 * }
 * }</pre>
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public interface McpProviderRegistry {
    
    /**
     * Registers a provider instance.
     * <p>
     * The provider class must be annotated with {@code @McpProvider} and
     * contain methods annotated with {@code @McpContext}, {@code @McpAction},
     * or {@code @McpEvent}.
     * </p>
     * 
     * @param providerInstance the provider instance to register
     * @throws IllegalArgumentException if the provider is invalid
     */
    void register(Object providerInstance);
    
    /**
     * Registers a provider instance with an owning plugin.
     * <p>
     * This allows the registry to track which plugin owns which providers
     * for proper cleanup on plugin disable.
     * </p>
     * 
     * @param providerInstance the provider instance to register
     * @param ownerPlugin the plugin that owns this provider
     * @throws IllegalArgumentException if the provider is invalid
     */
    void register(Object providerInstance, Plugin ownerPlugin);
    
    /**
     * Unregisters a specific provider instance.
     * 
     * @param providerInstance the provider instance to unregister
     */
    void unregister(Object providerInstance);
    
    /**
     * Unregisters all providers owned by a plugin.
     * <p>
     * This is typically called when a plugin is disabled.
     * </p>
     * 
     * @param ownerPlugin the plugin whose providers should be unregistered
     */
    void unregisterAll(Plugin ownerPlugin);
    
    /**
     * Gets all registered capability manifests.
     * <p>
     * This returns metadata about all available capabilities across
     * all registered providers.
     * </p>
     * 
     * @return list of capability manifests
     */
    List<CapabilityManifest> getCapabilities();
    
    /**
     * Gets capabilities provided by a specific provider.
     * 
     * @param providerId the provider ID
     * @return list of capability manifests for the provider
     */
    List<CapabilityManifest> getCapabilities(String providerId);
    
    /**
     * Checks if a capability is registered.
     * 
     * @param capabilityId the capability ID
     * @return true if the capability exists
     */
    boolean hasCapability(String capabilityId);
}
