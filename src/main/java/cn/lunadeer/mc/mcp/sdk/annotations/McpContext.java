package cn.lunadeer.mc.mcp.sdk.annotations;

import java.lang.annotation.*;

/**
 * Marks a method as a Context capability (read-only query).
 * <p>
 * Context capabilities are used to retrieve information from the Minecraft server
 * without modifying any state. They are considered safe operations.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpContext {

    /**
     * Unique identifier for the capability.
     * <p>
     * Format: {namespace}.{capability}
     * Example: "world.time.get", "player.list"
     * </p>
     *
     * @return the capability ID
     */
    String id();

    /**
     * Display name of the capability.
     *
     * @return the capability display name
     */
    String name();

    /**
     * Description of what the capability does.
     *
     * @return the capability description
     */
    String description() default "";

    /**
     * Version of the capability following semantic versioning.
     *
     * @return the capability version, defaults to "1.0.0"
     */
    String version() default "1.0.0";

    /**
     * Required permissions to invoke this capability.
     *
     * @return array of permission strings
     */
    String[] permissions() default {};

    /**
     * Tags for categorizing and filtering capabilities.
     *
     * @return array of tag strings
     */
    String[] tags() default {};

    /**
     * Whether the result of this capability can be cached.
     *
     * @return true if cacheable, defaults to true
     */
    boolean cacheable() default true;

    /**
     * Cache time-to-live in seconds.
     * Only applicable when cacheable is true.
     *
     * @return cache TTL in seconds, defaults to 60
     */
    int cacheTtl() default 60;

    /**
     * Description of the return value.
     * <p>
     * Use this to document what the context returns. For complex return types
     * (Record classes), the schema will be automatically generated from the
     * Record's components and their @Result annotations.
     * </p>
     *
     * @return the return value description
     */
    String returnDescription() default "";
}
