package cn.lunadeer.mc.modelContextProtocolAgentSDK.model;

import java.util.List;
import java.util.Map;

/**
 * Manifest describing a capability's metadata and schema.
 * <p>
 * This class contains all the information needed to understand
 * and invoke a capability, including its parameters, return type,
 * and safety requirements.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class CapabilityManifest {
    
    private String id;
    private String name;
    private String description;
    private String version;
    private CapabilityType type;
    private String providerId;
    private List<String> permissions;
    private List<String> tags;
    private RiskLevel riskLevel;
    private boolean rollbackSupported;
    private boolean snapshotRequired;
    private boolean confirmRequired;
    private boolean cacheable;
    private int cacheTtl;
    private Map<String, Object> parameterSchema;
    private Map<String, Object> returnSchema;
    
    /**
     * Gets the unique identifier of the capability.
     * 
     * @return the capability ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier of the capability.
     * 
     * @param id the capability ID
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Gets the display name of the capability.
     * 
     * @return the capability name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the display name of the capability.
     * 
     * @param name the capability name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the description of the capability.
     * 
     * @return the capability description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the description of the capability.
     * 
     * @param description the capability description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the version of the capability.
     * 
     * @return the capability version
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * Sets the version of the capability.
     * 
     * @param version the capability version
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * Gets the type of the capability.
     * 
     * @return the capability type
     */
    public CapabilityType getType() {
        return type;
    }
    
    /**
     * Sets the type of the capability.
     * 
     * @param type the capability type
     */
    public void setType(CapabilityType type) {
        this.type = type;
    }
    
    /**
     * Gets the provider ID that owns this capability.
     * 
     * @return the provider ID
     */
    public String getProviderId() {
        return providerId;
    }
    
    /**
     * Sets the provider ID that owns this capability.
     * 
     * @param providerId the provider ID
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    
    /**
     * Gets the list of required permissions.
     * 
     * @return list of permission strings
     */
    public List<String> getPermissions() {
        return permissions;
    }
    
    /**
     * Sets the list of required permissions.
     * 
     * @param permissions list of permission strings
     */
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
    
    /**
     * Gets the list of tags for categorization.
     * 
     * @return list of tag strings
     */
    public List<String> getTags() {
        return tags;
    }
    
    /**
     * Sets the list of tags for categorization.
     * 
     * @param tags list of tag strings
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    
    /**
     * Gets the risk level (for actions only).
     * 
     * @return the risk level
     */
    public RiskLevel getRiskLevel() {
        return riskLevel;
    }
    
    /**
     * Sets the risk level (for actions only).
     * 
     * @param riskLevel the risk level
     */
    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }
    
    /**
     * Checks if rollback is supported (for actions only).
     * 
     * @return true if rollback is supported
     */
    public boolean isRollbackSupported() {
        return rollbackSupported;
    }
    
    /**
     * Sets whether rollback is supported (for actions only).
     * 
     * @param rollbackSupported true if rollback is supported
     */
    public void setRollbackSupported(boolean rollbackSupported) {
        this.rollbackSupported = rollbackSupported;
    }
    
    /**
     * Checks if a snapshot is required before execution.
     * 
     * @return true if snapshot is required
     */
    public boolean isSnapshotRequired() {
        return snapshotRequired;
    }
    
    /**
     * Sets whether a snapshot is required before execution.
     * 
     * @param snapshotRequired true if snapshot is required
     */
    public void setSnapshotRequired(boolean snapshotRequired) {
        this.snapshotRequired = snapshotRequired;
    }
    
    /**
     * Checks if confirmation is required before execution.
     * 
     * @return true if confirmation is required
     */
    public boolean isConfirmRequired() {
        return confirmRequired;
    }
    
    /**
     * Sets whether confirmation is required before execution.
     * 
     * @param confirmRequired true if confirmation is required
     */
    public void setConfirmRequired(boolean confirmRequired) {
        this.confirmRequired = confirmRequired;
    }
    
    /**
     * Checks if results can be cached (for contexts only).
     * 
     * @return true if cacheable
     */
    public boolean isCacheable() {
        return cacheable;
    }
    
    /**
     * Sets whether results can be cached (for contexts only).
     * 
     * @param cacheable true if cacheable
     */
    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }
    
    /**
     * Gets the cache time-to-live in seconds.
     * 
     * @return cache TTL in seconds
     */
    public int getCacheTtl() {
        return cacheTtl;
    }
    
    /**
     * Sets the cache time-to-live in seconds.
     * 
     * @param cacheTtl cache TTL in seconds
     */
    public void setCacheTtl(int cacheTtl) {
        this.cacheTtl = cacheTtl;
    }
    
    /**
     * Gets the parameter schema (JSON Schema format).
     * 
     * @return parameter schema map
     */
    public Map<String, Object> getParameterSchema() {
        return parameterSchema;
    }
    
    /**
     * Sets the parameter schema (JSON Schema format).
     * 
     * @param parameterSchema parameter schema map
     */
    public void setParameterSchema(Map<String, Object> parameterSchema) {
        this.parameterSchema = parameterSchema;
    }
    
    /**
     * Gets the return type schema (JSON Schema format).
     * 
     * @return return schema map
     */
    public Map<String, Object> getReturnSchema() {
        return returnSchema;
    }
    
    /**
     * Sets the return type schema (JSON Schema format).
     * 
     * @param returnSchema return schema map
     */
    public void setReturnSchema(Map<String, Object> returnSchema) {
        this.returnSchema = returnSchema;
    }
}
