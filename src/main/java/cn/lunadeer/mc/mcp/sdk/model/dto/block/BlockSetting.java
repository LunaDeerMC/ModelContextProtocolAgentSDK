package cn.lunadeer.mc.mcp.sdk.model.dto.block;

import cn.lunadeer.mc.mcp.sdk.annotations.Param;

/**
 * Data transfer object representing a block setting for batch operations.
 */
public record BlockSetting(
        @Param(description = "Location of the block", required = true)
        BlockLocationParam blockLocation,

        @Param(description = "Material name", required = true)
        String material,

        @Param(description = "Block data string")
        String blockData
) {
}
