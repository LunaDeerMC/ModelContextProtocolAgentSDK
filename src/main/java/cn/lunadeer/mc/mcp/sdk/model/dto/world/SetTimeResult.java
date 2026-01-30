package cn.lunadeer.mc.mcp.sdk.model.dto.world;

import cn.lunadeer.mc.mcp.sdk.annotations.Result;

/**
 * Result object for setting world time.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record SetTimeResult(
        @Result(description = "Whether the operation was successful", required = true)
        Boolean success,

        @Result(description = "Previous time before the change", required = true)
        Long previousTime,

        @Result(description = "New time after the change", required = true)
        Long newTime
) {
}
