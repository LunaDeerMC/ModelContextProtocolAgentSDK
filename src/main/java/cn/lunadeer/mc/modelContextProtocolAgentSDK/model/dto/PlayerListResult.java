package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

import java.util.List;

/**
 * Result object for player list queries with pagination.
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class PlayerListResult {

    private List<PlayerInfo> players;
    private Integer total;
    private Integer page;
    private Integer pageSize;
    private Integer totalPages;

    /**
     * Creates a new player list result.
     */
    public PlayerListResult() {
    }

    /**
     * Gets the list of players.
     *
     * @return the players list
     */
    public List<PlayerInfo> getPlayers() {
        return players;
    }

    /**
     * Sets the list of players.
     *
     * @param players the players list
     */
    public void setPlayers(List<PlayerInfo> players) {
        this.players = players;
    }

    /**
     * Gets the total number of players.
     *
     * @return the total count
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the total number of players.
     *
     * @param total the total count
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Gets the current page number.
     *
     * @return the page number
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the current page number.
     *
     * @param page the page number
     */
    public void setPage(Integer page) {
        this.page = page;
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
        this.pageSize = pageSize;
    }

    /**
     * Gets the total number of pages.
     *
     * @return the total pages
     */
    public Integer getTotalPages() {
        return totalPages;
    }

    /**
     * Sets the total number of pages.
     *
     * @param totalPages the total pages
     */
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
