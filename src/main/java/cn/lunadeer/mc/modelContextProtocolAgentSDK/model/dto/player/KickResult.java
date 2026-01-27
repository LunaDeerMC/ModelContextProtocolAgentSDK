package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.player;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;

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
