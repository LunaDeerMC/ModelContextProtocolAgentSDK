package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.block;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Param;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.LocationParam;

import java.util.Map;

/**
 * Data transfer object representing block information.
 */
public record BlockInfo(
        @Param(description = "Location of the block", required = true)
        LocationParam location,

        @Param(description = "Material name", required = true)
        String material,

        @Param(description = "Block data string")
        String blockData,

        @Param(description = "Block state properties")
        Map<String, String> properties,

        @Param(description = "Light level (0-15)")
        Integer lightLevel
) {
}