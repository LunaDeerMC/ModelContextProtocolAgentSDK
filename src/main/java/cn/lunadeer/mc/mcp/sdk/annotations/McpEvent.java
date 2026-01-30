package cn.lunadeer.mc.mcp.sdk.annotations;

import java.lang.annotation.*;

/**
 * Marks a method as an Event capability (event subscription).
 * <p>
 * Event capabilities allow external clients to subscribe to Minecraft server events.
 * The annotated method will be called when the corresponding Bukkit event occurs.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface McpEvent {

    /**
     * Unique identifier for the event capability.
     * <p>
     * Format: {namespace}.{event}
     * Example: "player.join", "world.block.break"
     * </p>
     *
     * @return the event capability ID
     */
    String id();

    /**
     * Display name of the event capability.
     *
     * @return the event capability display name
     */
    String name();

    /**
     * Description of what the event represents.
     *
     * @return the event capability description
     */
    String description() default "";

    /**
     * Version of the event capability following semantic versioning.
     *
     * @return the event capability version, defaults to "1.0.0"
     */
    String version() default "1.0.0";

    /**
     * Required permissions to subscribe to this event.
     *
     * @return array of permission strings
     */
    String[] permissions() default {};

    /**
     * Tags for categorizing and filtering event capabilities.
     *
     * @return array of tag strings
     */
    String[] tags() default {};

    /**
     * Bukkit event types that this capability binds to.
     * When any of these events fire, the annotated method will be invoked.
     *
     * @return array of Bukkit Event classes
     */
    Class<?>[] bukkitEvents() default {};
}
