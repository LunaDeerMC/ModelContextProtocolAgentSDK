package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for world time queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class WorldTimeResult {

    private String worldName;
    private Long time;
    private Long fullTime;
    private Integer day;
    private TimePhase phase;

    /**
     * Creates a new world time result.
     */
    public WorldTimeResult() {
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
     * Gets the current time (0-24000).
     *
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * Sets the current time.
     *
     * @param time the time
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * Gets the full time (total ticks since world creation).
     *
     * @return the full time
     */
    public Long getFullTime() {
        return fullTime;
    }

    /**
     * Sets the full time.
     *
     * @param fullTime the full time
     */
    public void setFullTime(Long fullTime) {
        this.fullTime = fullTime;
    }

    /**
     * Gets the current day number.
     *
     * @return the day number
     */
    public Integer getDay() {
        return day;
    }

    /**
     * Sets the current day number.
     *
     * @param day the day number
     */
    public void setDay(Integer day) {
        this.day = day;
    }

    /**
     * Gets the time phase (day/night).
     *
     * @return the time phase
     */
    public TimePhase getPhase() {
        return phase;
    }

    /**
     * Sets the time phase.
     *
     * @param phase the time phase
     */
    public void setPhase(TimePhase phase) {
        this.phase = phase;
    }

    /**
     * Enum representing time phases.
     */
    public enum TimePhase {
        /**
         * Day time (ticks 0-12000).
         */
        DAY,

        /**
         * Night time (ticks 12000-24000).
         */
        NIGHT
    }
}
