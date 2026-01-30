package cn.lunadeer.mc.mcp.sdk.model.dto.block;

import cn.lunadeer.mc.mcp.sdk.annotations.Param;
import cn.lunadeer.mc.mcp.sdk.annotations.Result;
import cn.lunadeer.mc.mcp.sdk.exception.McpBusinessException;
import cn.lunadeer.mc.mcp.sdk.model.ErrorCode;
import org.bukkit.Bukkit;
import org.bukkit.Location;

/**
 * Data transfer object representing a location in Minecraft.
 * <p>
 * This Record can be used for both input parameters (teleport locations) and
 * output results (player positions). Both @Param and @Result annotations are
 * applied to support both use cases.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public record BlockLocationParam(
        @Param(description = "World name", required = true)
        @Result(description = "World name", required = true)
        String world,

        @Param(description = "X coordinate", required = true)
        @Result(description = "X coordinate", required = true)
        int x,

        @Param(description = "Y coordinate", required = true)
        @Result(description = "Y coordinate", required = true)
        int y,

        @Param(description = "Z coordinate", required = true)
        @Result(description = "Z coordinate", required = true)
        int z,

        @Param(description = "Block Direction")
        DirectionType direction
) {
    /**
     * Creates a new location parameter with specified coordinates.
     *
     * @param world the world name
     * @param x     the x coordinate
     * @param y     the y coordinate
     * @param z     the z coordinate
     * @return location parameter
     */
    public static BlockLocationParam create(String world, int x, int y, int z) {
        return new BlockLocationParam(world, x, y, z, null);
    }

    /**
     * Creates a new location parameter with specified coordinates and rotation.
     *
     * @param world the world name
     * @param x     the x coordinate
     * @param y     the y coordinate
     * @param z     the z coordinate
     * @return location parameter
     */
    public static BlockLocationParam create(String world, int x, int y, int z, DirectionType direction) {
        return new BlockLocationParam(world, x, y, z, direction);
    }

    /**
     * Converts a LocationParam to Bukkit Location.
     *
     * @param locationParam the location param
     * @return the Bukkit location
     */
    public static Location toBukkitLocation(BlockLocationParam locationParam) {
        if (locationParam == null) {
            return null;
        }
        org.bukkit.World world = Bukkit.getWorld(locationParam.world());
        if (world == null) {
            throw new McpBusinessException(
                    ErrorCode.OPERATION_FAILED.getErrorCode(),
                    "World not found: " + locationParam.world()
            );
        }
        return new Location(world, locationParam.x(), locationParam.y(), locationParam.z());
    }
}
