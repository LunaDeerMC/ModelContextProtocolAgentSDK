package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for player kick operations.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class KickResult {

    private Boolean success;
    private String playerName;
    private String reason;

    /**
     * Creates a new kick result.
     */
    public KickResult() {
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
     * Gets the name of the kicked player.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the name of the kicked player.
     *
     * @param playerName the player name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Gets the kick reason.
     *
     * @return the kick reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the kick reason.
     *
     * @param reason the kick reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}
