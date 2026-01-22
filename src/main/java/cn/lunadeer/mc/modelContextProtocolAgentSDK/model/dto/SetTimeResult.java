package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for setting world time.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class SetTimeResult {

    private Boolean success;
    private Long previousTime;
    private Long newTime;

    /**
     * Creates a new set time result.
     */
    public SetTimeResult() {
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
     * Gets the previous time before the change.
     *
     * @return the previous time
     */
    public Long getPreviousTime() {
        return previousTime;
    }

    /**
     * Sets the previous time before the change.
     *
     * @param previousTime the previous time
     */
    public void setPreviousTime(Long previousTime) {
        this.previousTime = previousTime;
    }

    /**
     * Gets the new time after the change.
     *
     * @return the new time
     */
    public Long getNewTime() {
        return newTime;
    }

    /**
     * Sets the new time after the change.
     *
     * @param newTime the new time
     */
    public void setNewTime(Long newTime) {
        this.newTime = newTime;
    }
}
