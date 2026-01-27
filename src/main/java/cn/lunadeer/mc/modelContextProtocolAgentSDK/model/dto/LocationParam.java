package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Param;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.annotations.Result;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.exception.McpBusinessException;
import cn.lunadeer.mc.modelContextProtocolAgentSDK.model.ErrorCode;
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
public record LocationParam(
        @Param(description = "World name", required = true)
        @Result(description = "World name", required = true)
        String world,

        @Param(description = "X coordinate", required = true)
        @Result(description = "X coordinate", required = true)
        double x,

        @Param(description = "Y coordinate", required = true)
        @Result(description = "Y coordinate", required = true)
        double y,

        @Param(description = "Z coordinate", required = true)
        @Result(description = "Z coordinate", required = true)
        double z,

        @Param(description = "Yaw rotation (horizontal angle)")
        @Result(description = "Yaw rotation (horizontal angle)")
        float yaw,

        @Param(description = "Pitch rotation (vertical angle)")
        @Result(description = "Pitch rotation (vertical angle)")
        float pitch
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
    public static LocationParam create(String world, double x, double y, double z) {
        return new LocationParam(world, x, y, z, 0.0f, 0.0f);
    }

    /**
     * Creates a new location parameter with specified coordinates and rotation.
     *
     * @param world the world name
     * @param x     the x coordinate
     * @param y     the y coordinate
     * @param z     the z coordinate
     * @param yaw   the yaw rotation
     * @param pitch the pitch rotation
     * @return location parameter
     */
    public static LocationParam create(String world, double x, double y, double z, float yaw, float pitch) {
        return new LocationParam(world, x, y, z, yaw, pitch);
    }

    /**
     * Converts a LocationParam to Bukkit Location.
     *
     * @param locationParam the location param
     * @return the Bukkit location
     */
    public static Location toBukkitLocation(LocationParam locationParam) {
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
        return new Location(
                world,
                locationParam.x(),
                locationParam.y(),
                locationParam.z(),
                locationParam.yaw(),
                locationParam.pitch()
        );
    }
}
