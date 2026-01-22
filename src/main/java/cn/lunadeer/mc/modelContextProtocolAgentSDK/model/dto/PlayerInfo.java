package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

import java.time.Instant;

/**
 * Data transfer object representing basic player information.
 * <p>
 * Contains essential player data for display and identification purposes.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class PlayerInfo {

    private String name;
    private String uuid;
    private String displayName;
    private LocationParam location;
    private Double health;
    private Double maxHealth;
    private Integer foodLevel;
    private Integer level;
    private Float exp;
    private String gameMode;
    private Boolean isOp;
    private Boolean isFlying;
    private Integer ping;
    private Instant firstPlayed;
    private Instant lastPlayed;

    /**
     * Creates a new player info instance.
     */
    public PlayerInfo() {
    }

    /**
     * Gets the player's name.
     *
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     *
     * @param name the player name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the player's UUID.
     *
     * @return the player UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the player's UUID.
     *
     * @param uuid the player UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Gets the player's display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the player's display name.
     *
     * @param displayName the display name
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets the player's current location.
     *
     * @return the location
     */
    public LocationParam getLocation() {
        return location;
    }

    /**
     * Sets the player's current location.
     *
     * @param location the location
     */
    public void setLocation(LocationParam location) {
        this.location = location;
    }

    /**
     * Gets the player's current health.
     *
     * @return the health value
     */
    public Double getHealth() {
        return health;
    }

    /**
     * Sets the player's current health.
     *
     * @param health the health value
     */
    public void setHealth(Double health) {
        this.health = health;
    }

    /**
     * Gets the player's maximum health.
     *
     * @return the max health value
     */
    public Double getMaxHealth() {
        return maxHealth;
    }

    /**
     * Sets the player's maximum health.
     *
     * @param maxHealth the max health value
     */
    public void setMaxHealth(Double maxHealth) {
        this.maxHealth = maxHealth;
    }

    /**
     * Gets the player's food level.
     *
     * @return the food level
     */
    public Integer getFoodLevel() {
        return foodLevel;
    }

    /**
     * Sets the player's food level.
     *
     * @param foodLevel the food level
     */
    public void setFoodLevel(Integer foodLevel) {
        this.foodLevel = foodLevel;
    }

    /**
     * Gets the player's experience level.
     *
     * @return the experience level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Sets the player's experience level.
     *
     * @param level the experience level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Gets the player's experience progress (0.0 to 1.0).
     *
     * @return the experience progress
     */
    public Float getExp() {
        return exp;
    }

    /**
     * Sets the player's experience progress.
     *
     * @param exp the experience progress
     */
    public void setExp(Float exp) {
        this.exp = exp;
    }

    /**
     * Gets the player's game mode.
     *
     * @return the game mode name
     */
    public String getGameMode() {
        return gameMode;
    }

    /**
     * Sets the player's game mode.
     *
     * @param gameMode the game mode name
     */
    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * Checks if the player is an operator.
     *
     * @return true if operator
     */
    public Boolean getIsOp() {
        return isOp;
    }

    /**
     * Sets whether the player is an operator.
     *
     * @param isOp true if operator
     */
    public void setIsOp(Boolean isOp) {
        this.isOp = isOp;
    }

    /**
     * Checks if the player is flying.
     *
     * @return true if flying
     */
    public Boolean getIsFlying() {
        return isFlying;
    }

    /**
     * Sets whether the player is flying.
     *
     * @param isFlying true if flying
     */
    public void setIsFlying(Boolean isFlying) {
        this.isFlying = isFlying;
    }

    /**
     * Gets the player's network ping latency.
     *
     * @return the ping in milliseconds
     */
    public Integer getPing() {
        return ping;
    }

    /**
     * Sets the player's network ping latency.
     *
     * @param ping the ping in milliseconds
     */
    public void setPing(Integer ping) {
        this.ping = ping;
    }

    /**
     * Gets the timestamp when the player first joined.
     *
     * @return the first played timestamp
     */
    public Instant getFirstPlayed() {
        return firstPlayed;
    }

    /**
     * Sets the timestamp when the player first joined.
     *
     * @param firstPlayed the first played timestamp
     */
    public void setFirstPlayed(Instant firstPlayed) {
        this.firstPlayed = firstPlayed;
    }

    /**
     * Gets the timestamp when the player last joined.
     *
     * @return the last played timestamp
     */
    public Instant getLastPlayed() {
        return lastPlayed;
    }

    /**
     * Sets the timestamp when the player last joined.
     *
     * @param lastPlayed the last played timestamp
     */
    public void setLastPlayed(Instant lastPlayed) {
        this.lastPlayed = lastPlayed;
    }
}
