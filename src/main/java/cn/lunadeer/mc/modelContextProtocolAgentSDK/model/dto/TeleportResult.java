package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;

/**
 * Result object for player teleport operations.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record TeleportResult(
        @Result(description = "Whether the operation was successful", required = true)
        Boolean success,

        @Result(description = "Previous location before teleport", required = true)
        LocationParam previousLocation,

        @Result(description = "New location after teleport", required = true)
        LocationParam newLocation
) {
}
