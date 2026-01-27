package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto.block;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Param;

import java.util.List;

/**
 * Data transfer object representing a list of blocks with pagination.
 */
public record BlockListResult(
        @Param(description = "List of blocks", required = true)
        List<BlockInfo> blocks,

        @Param(description = "Total number of blocks", required = true)
        Integer total,

        @Param(description = "Current page number", required = true)
        Integer page,

        @Param(description = "Number of items per page", required = true)
        Integer pageSize,

        @Param(description = "Total number of pages", required = true)
        Integer totalPages
) {
}
