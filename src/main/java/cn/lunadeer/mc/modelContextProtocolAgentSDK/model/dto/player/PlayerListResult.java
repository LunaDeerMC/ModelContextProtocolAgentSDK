package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.player;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;

import java.util.List;

/**
 * Result object for player list queries with pagination.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record PlayerListResult(
        @Result(description = "List of players", required = true)
        List<PlayerInfo> players,

        @Result(description = "Total number of players", required = true)
        Integer total,

        @Result(description = "Current page number", required = true)
        Integer page,

        @Result(description = "Number of items per page", required = true)
        Integer pageSize,

        @Result(description = "Total number of pages", required = true)
        Integer totalPages
) {
}
