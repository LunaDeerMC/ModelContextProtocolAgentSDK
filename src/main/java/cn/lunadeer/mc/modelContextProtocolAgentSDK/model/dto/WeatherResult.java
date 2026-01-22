package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for weather queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class WeatherResult {

    private String worldName;
    private WeatherType type;
    private Integer duration;

    /**
     * Creates a new weather result.
     */
    public WeatherResult() {
    }

    /**
     * Gets the world name.
     *
     * @return the world name
     */
    public String getWorldName() {
        return worldName;
    }

    /**
     * Sets the world name.
     *
     * @param worldName the world name
     */
    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    /**
     * Gets the weather type.
     *
     * @return the weather type
     */
    public WeatherType getType() {
        return type;
    }

    /**
     * Sets the weather type.
     *
     * @param type the weather type
     */
    public void setType(WeatherType type) {
        this.type = type;
    }

    /**
     * Gets the duration in ticks.
     *
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Sets the duration in ticks.
     *
     * @param duration the duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
