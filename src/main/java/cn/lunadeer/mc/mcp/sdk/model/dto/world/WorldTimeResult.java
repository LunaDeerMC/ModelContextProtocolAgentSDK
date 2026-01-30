package cn.lunadeer.mc.mcp.sdk.model.dto.world;

import cn.lunadeer.mc.mcp.sdk.annotations.Result;

/**
 * Result object for world time queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record WorldTimeResult(
        @Result(description = "World name", required = true)
        String worldName,

        @Result(description = "Current time (0-24000 ticks)", required = true)
        Long time,

        @Result(description = "Total ticks since world creation", required = true)
        Long fullTime,

        @Result(description = "Current day number")
        Integer day,

        @Result(description = "Time phase (day or night)")
        TimePhase phase
) {
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
