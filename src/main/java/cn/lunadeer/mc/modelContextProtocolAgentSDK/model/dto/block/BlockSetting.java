package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.block;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Param;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.LocationParam;

/**
 * Data transfer object representing a block setting for batch operations.
 */
public record BlockSetting(
        @Param(description = "Location of the block", required = true)
        LocationParam location,

        @Param(description = "Material name", required = true)
        String material,

        @Param(description = "Block data string")
        String blockData
) {
}
