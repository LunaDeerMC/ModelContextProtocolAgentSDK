package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Data transfer object for pagination parameters.
 * <p>
 * Used to request paginated results from list-type capabilities.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class PaginationParam {
    
    private int page;
    private int pageSize;
    
    /**
     * Creates a new pagination parameter with default values.
     * Page 1, page size 20.
     */
    public PaginationParam() {
        this.page = 1;
        this.pageSize = 20;
    }
    
    /**
     * Creates a new pagination parameter.
     * 
     * @param page the page number (1-based)
     * @param pageSize the number of items per page
     */
    public PaginationParam(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }
    
    /**
     * Gets the page number (1-based).
     * 
     * @return the page number
     */
    public int getPage() {
        return page;
    }
    
    /**
     * Sets the page number (1-based).
     * 
     * @param page the page number
     */
    public void setPage(int page) {
        this.page = page;
    }
    
    /**
     * Gets the number of items per page.
     * 
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }
    
    /**
     * Sets the number of items per page.
     * 
     * @param pageSize the page size
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * Calculates the offset for database queries.
     * 
     * @return the offset (0-based)
     */
    public int getOffset() {
        return (page - 1) * pageSize;
    }
}
