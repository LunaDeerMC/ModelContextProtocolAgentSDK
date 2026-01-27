package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;

/**
 * Result object for TPS (Ticks Per Second) queries.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record TpsResult(
        @Result(description = "TPS for the last 1 minute", required = true)
        Double tps1m,

        @Result(description = "TPS for the last 5 minutes", required = true)
        Double tps5m,

        @Result(description = "TPS for the last 15 minutes", required = true)
        Double tps15m,

        @Result(description = "Average milliseconds per tick", required = true)
        Double mspt
) {
}
