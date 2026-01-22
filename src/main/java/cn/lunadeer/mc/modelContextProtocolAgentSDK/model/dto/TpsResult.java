package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Result object for TPS (Ticks Per Second) queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class TpsResult {

    private Double tps1m;
    private Double tps5m;
    private Double tps15m;
    private Double mspt;

    /**
     * Creates a new TPS result.
     */
    public TpsResult() {
    }

    /**
     * Gets the TPS for the last 1 minute.
     *
     * @return the 1-minute TPS
     */
    public Double getTps1m() {
        return tps1m;
    }

    /**
     * Sets the TPS for the last 1 minute.
     *
     * @param tps1m the 1-minute TPS
     */
    public void setTps1m(Double tps1m) {
        this.tps1m = tps1m;
    }

    /**
     * Gets the TPS for the last 5 minutes.
     *
     * @return the 5-minute TPS
     */
    public Double getTps5m() {
        return tps5m;
    }

    /**
     * Sets the TPS for the last 5 minutes.
     *
     * @param tps5m the 5-minute TPS
     */
    public void setTps5m(Double tps5m) {
        this.tps5m = tps5m;
    }

    /**
     * Gets the TPS for the last 15 minutes.
     *
     * @return the 15-minute TPS
     */
    public Double getTps15m() {
        return tps15m;
    }

    /**
     * Sets the TPS for the last 15 minutes.
     *
     * @param tps15m the 15-minute TPS
     */
    public void setTps15m(Double tps15m) {
        this.tps15m = tps15m;
    }

    /**
     * Gets the average milliseconds per tick.
     *
     * @return the MSPT value
     */
    public Double getMspt() {
        return mspt;
    }

    /**
     * Sets the average milliseconds per tick.
     *
     * @param mspt the MSPT value
     */
    public void setMspt(Double mspt) {
        this.mspt = mspt;
    }
}
