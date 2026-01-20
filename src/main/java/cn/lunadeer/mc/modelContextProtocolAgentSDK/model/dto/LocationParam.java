package cn.lunadeer.mc.modelContextProtocolAgentSDK.model.dto;

/**
 * Data transfer object representing a location in Minecraft.
 * <p>
 * Used as a parameter type for capabilities that need location information.
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class LocationParam {
    
    private String world;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    
    /**
     * Creates a new location parameter.
     */
    public LocationParam() {
    }
    
    /**
     * Creates a new location parameter with specified coordinates.
     * 
     * @param world the world name
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     */
    public LocationParam(String world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Creates a new location parameter with specified coordinates and rotation.
     * 
     * @param world the world name
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param yaw the yaw rotation
     * @param pitch the pitch rotation
     */
    public LocationParam(String world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    /**
     * Gets the world name.
     * 
     * @return the world name
     */
    public String getWorld() {
        return world;
    }
    
    /**
     * Sets the world name.
     * 
     * @param world the world name
     */
    public void setWorld(String world) {
        this.world = world;
    }
    
    /**
     * Gets the x coordinate.
     * 
     * @return the x coordinate
     */
    public double getX() {
        return x;
    }
    
    /**
     * Sets the x coordinate.
     * 
     * @param x the x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Gets the y coordinate.
     * 
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }
    
    /**
     * Sets the y coordinate.
     * 
     * @param y the y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Gets the z coordinate.
     * 
     * @return the z coordinate
     */
    public double getZ() {
        return z;
    }
    
    /**
     * Sets the z coordinate.
     * 
     * @param z the z coordinate
     */
    public void setZ(double z) {
        this.z = z;
    }
    
    /**
     * Gets the yaw rotation.
     * 
     * @return the yaw rotation
     */
    public float getYaw() {
        return yaw;
    }
    
    /**
     * Sets the yaw rotation.
     * 
     * @param yaw the yaw rotation
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }
    
    /**
     * Gets the pitch rotation.
     * 
     * @return the pitch rotation
     */
    public float getPitch() {
        return pitch;
    }
    
    /**
     * Sets the pitch rotation.
     * 
     * @param pitch the pitch rotation
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }
}
