package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.world;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;

/**
 * Result object for setting weather.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record SetWeatherResult(
        @Result(description = "Whether the operation was successful", required = true)
        Boolean success,

        @Result(description = "Previous weather type before the change", required = true)
        WeatherType previousType,

        @Result(description = "New weather type after the change", required = true)
        WeatherType newType
) {
}
