package cn.lunadeer.mc.mcp.sdk.model.dto.player;

import cn.lunadeer.mc.mcp.sdk.annotations.Result;

/**
 * Result object for player kick operations.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record KickResult(
        @Result(description = "Whether the operation was successful", required = true)
        Boolean success,

        @Result(description = "Name of the kicked player", required = true)
        String playerName,

        @Result(description = "Kick reason", required = true)
        String reason
) {
}
