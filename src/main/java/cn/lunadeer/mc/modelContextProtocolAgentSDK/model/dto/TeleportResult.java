package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for player teleport operations.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class TeleportResult {

    private Boolean success;
    private LocationParam previousLocation;
    private LocationParam newLocation;

    /**
     * Creates a new teleport result.
     */
    public TeleportResult() {
    }

    /**
     * Gets whether the operation was successful.
     *
     * @return true if successful
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Sets whether the operation was successful.
     *
     * @param success true if successful
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * Gets the previous location before teleport.
     *
     * @return the previous location
     */
    public LocationParam getPreviousLocation() {
        return previousLocation;
    }

    /**
     * Sets the previous location before teleport.
     *
     * @param previousLocation the previous location
     */
    public void setPreviousLocation(LocationParam previousLocation) {
        this.previousLocation = previousLocation;
    }

    /**
     * Gets the new location after teleport.
     *
     * @return the new location
     */
    public LocationParam getNewLocation() {
        return newLocation;
    }

    /**
     * Sets the new location after teleport.
     *
     * @param newLocation the new location
     */
    public void setNewLocation(LocationParam newLocation) {
        this.newLocation = newLocation;
    }
}
