package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.player;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.LocationParam;

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
public record PlayerInfo(
        @Result(description = "Player name", required = true)
        String name,

        @Result(description = "Player UUID", required = true)
        String uuid,

        @Result(description = "Player display name", required = true)
        String displayName,

        @Result(description = "Player location", required = true)
        LocationParam location,

        @Result(description = "Player health", min = 0.0, max = 20.0)
        Double health,

        @Result(description = "Player maximum health", min = 0.0)
        Double maxHealth,

        @Result(description = "Player food level", min = 0, max = 20)
        Integer foodLevel,

        @Result(description = "Player experience level", min = 0)
        Integer level,

        @Result(description = "Player experience progress (0.0 to 1.0)", min = 0.0, max = 1.0)
        Float exp,

        @Result(description = "Player game mode")
        String gameMode,

        @Result(description = "Whether the player is an operator")
        Boolean isOp,

        @Result(description = "Whether the player is flying")
        Boolean isFlying,

        @Result(description = "Player network ping latency in milliseconds", min = 0)
        Integer ping,

        @Result(description = "Timestamp when the player first joined")
        Instant firstPlayed,

        @Result(description = "Timestamp when the player last joined")
        Instant lastPlayed
) {
}
