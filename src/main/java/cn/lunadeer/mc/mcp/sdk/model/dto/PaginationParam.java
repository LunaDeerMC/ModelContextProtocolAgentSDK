package cn.lunadeer.mc.mcp.sdk.model.dto;

import cn.lunadeer.mc.mcp.sdk.annotations.Param;

/**
 * Data transfer object representing pagination parameters for list queries.
 * <p>
 * Used as a parameter type for capabilities that return paginated results.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record PaginationParam(
        @Param(description = "Page number (1-based)", defaultValue = "1", min = 1)
        Integer page,

        @Param(description = "Number of items per page", defaultValue = "20", min = 1, max = 100)
        Integer pageSize,

        @Param(description = "Field to sort by")
        String sortBy,

        @Param(description = "Sort order (asc or desc)", defaultValue = "asc")
        String sortOrder
) {
    /**
     * Gets the offset for database queries (0-based).
     *
     * @return the offset
     */
    public int getOffset() {
        int actualPage = page != null ? page : 1;
        int actualPageSize = pageSize != null ? pageSize : 20;
        return (actualPage - 1) * actualPageSize;
    }

    /**
     * Creates a new pagination parameter with default values.
     *
     * @return pagination parameter with defaults (page=1, pageSize=20, sortOrder="asc")
     */
    public static PaginationParam createDefault() {
        return new PaginationParam(1, 20, null, "asc");
    }

    /**
     * Creates a new pagination parameter with specified values.
     *
     * @param page     the page number (1-based)
     * @param pageSize the number of items per page
     * @return pagination parameter
     */
    public static PaginationParam create(Integer page, Integer pageSize) {
        return new PaginationParam(
                page != null ? page : 1,
                pageSize != null ? pageSize : 20,
                null,
                "asc"
        );
    }

    /**
     * Creates a new pagination parameter with full specification.
     *
     * @param page      the page number (1-based)
     * @param pageSize  the number of items per page
     * @param sortBy    the field to sort by
     * @param sortOrder the sort order ("asc" or "desc")
     * @return pagination parameter
     */
    public static PaginationParam create(Integer page, Integer pageSize, String sortBy, String sortOrder) {
        return new PaginationParam(
                page != null ? page : 1,
                pageSize != null ? pageSize : 20,
                sortBy,
                sortOrder != null ? sortOrder : "asc"
        );
    }
}
