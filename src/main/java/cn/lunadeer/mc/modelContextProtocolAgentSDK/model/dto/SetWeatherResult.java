package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for setting weather.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class SetWeatherResult {

    private Boolean success;
    private WeatherType previousType;
    private WeatherType newType;

    /**
     * Creates a new set weather result.
     */
    public SetWeatherResult() {
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
     * Gets the previous weather type before the change.
     *
     * @return the previous weather type
     */
    public WeatherType getPreviousType() {
        return previousType;
    }

    /**
     * Sets the previous weather type before the change.
     *
     * @param previousType the previous weather type
     */
    public void setPreviousType(WeatherType previousType) {
        this.previousType = previousType;
    }

    /**
     * Gets the new weather type after the change.
     *
     * @return the new weather type
     */
    public WeatherType getNewType() {
        return newType;
    }

    /**
     * Sets the new weather type after the change.
     *
     * @param newType the new weather type
     */
    public void setNewType(WeatherType newType) {
        this.newType = newType;
    }
}
