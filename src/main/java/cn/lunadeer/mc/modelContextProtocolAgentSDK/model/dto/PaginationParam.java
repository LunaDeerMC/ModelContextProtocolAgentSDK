package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Data transfer object representing pagination parameters for list queries.
 * <p>
 * Used as a parameter type for capabilities that return paginated results.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class PaginationParam {

    private Integer page;
    private Integer pageSize;
    private String sortBy;
    private String sortOrder;

    /**
     * Creates a new pagination parameter with default values.
     */
    public PaginationParam() {
        this.page = 1;
        this.pageSize = 20;
        this.sortBy = null;
        this.sortOrder = "asc";
    }

    /**
     * Creates a new pagination parameter with specified values.
     *
     * @param page the page number (1-based)
     * @param pageSize the number of items per page
     */
    public PaginationParam(Integer page, Integer pageSize) {
        this.page = page != null ? page : 1;
        this.pageSize = pageSize != null ? pageSize : 20;
        this.sortBy = null;
        this.sortOrder = "asc";
    }

    /**
     * Creates a new pagination parameter with full specification.
     *
     * @param page the page number (1-based)
     * @param pageSize the number of items per page
     * @param sortBy the field to sort by
     * @param sortOrder the sort order ("asc" or "desc")
     */
    public PaginationParam(Integer page, Integer pageSize, String sortBy, String sortOrder) {
        this.page = page != null ? page : 1;
        this.pageSize = pageSize != null ? pageSize : 20;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder != null ? sortOrder : "asc";
    }

    /**
     * Gets the page number (1-based).
     *
     * @return the page number
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the page number (1-based).
     *
     * @param page the page number
     */
    public void setPage(Integer page) {
        this.page = page != null ? page : 1;
    }

    /**
     * Gets the number of items per page.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the number of items per page.
     *
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize != null ? pageSize : 20;
    }

    /**
     * Gets the field to sort by.
     *
     * @return the sort field
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * Sets the field to sort by.
     *
     * @param sortBy the sort field
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * Gets the sort order ("asc" or "desc").
     *
     * @return the sort order
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the sort order ("asc" or "desc").
     *
     * @param sortOrder the sort order
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder != null ? sortOrder : "asc";
    }

    /**
     * Gets the offset for database queries (0-based).
     *
     * @return the offset
     */
    public int getOffset() {
        return (getPage() - 1) * getPageSize();
    }
}
