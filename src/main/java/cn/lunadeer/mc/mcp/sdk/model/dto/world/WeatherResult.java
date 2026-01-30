package cn.lunadeer.mc.mcp.sdk.model.dto.world;

import cn.lunadeer.mc.mcp.sdk.annotations.Result;

/**
 * Result object for weather queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record WeatherResult(
        @Result(description = "World name", required = true)
        String worldName,

        @Result(description = "Weather type", required = true)
        WeatherType type,

        @Result(description = "Duration in ticks", required = true)
        Integer duration
) {
}
