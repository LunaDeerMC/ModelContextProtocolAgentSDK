package cn.lunadeer.mc.modelContextProtocolAgentSDK.api;

import java.util.function.Predicate;

/**
 * Event emitter for sending events to external clients.
 * <p>
 * Internal modules and third-party plugins can use this interface to emit
 * events that will be pushed to subscribed clients through the gateway.
 * </p>
 * <p>
 * Example usage:
 * <pre>{@code
 * McpEventEmitter emitter = Bukkit.getServicesManager()
 *     .load(McpEventEmitter.class);
 * if (emitter != null) {
 *     emitter.emit("custom.shop.transaction", transactionData);
 * }
 * }</pre>
 * </p>
 * 
 * @author ZhangYuheng
 * @since 1.0.0
 */
public interface McpEventEmitter {
    
    /**
     * Emits an event to all subscribers.
     * 
     * @param eventId the event identifier
     * @param eventData the event payload data
     */
    void emit(String eventId, Object eventData);
    
    /**
     * Emits an event to filtered subscribers.
     * <p>
     * The filter predicate receives subscription metadata and can decide
     * whether to send the event to that particular subscriber.
     * </p>
     * 
     * @param eventId the event identifier
     * @param eventData the event payload data
     * @param filter predicate to filter subscribers
     */
    void emit(String eventId, Object eventData, Predicate<Subscription> filter);
    
    /**
     * Represents a subscription to an event.
     */
    interface Subscription {
        
        /**
         * Gets the subscription ID.
         * 
         * @return the subscription ID
         */
        String getId();
        
        /**
         * Gets the event ID this subscription is for.
         * 
         * @return the event ID
         */
        String getEventId();
        
        /**
         * Gets the subscriber ID (typically a gateway client ID).
         * 
         * @return the subscriber ID
         */
        String getSubscriberId();
        
        /**
         * Gets custom filter parameters from the subscription.
         * 
         * @param key the parameter key
         * @return the parameter value, or null if not present
         */
        Object getFilterParameter(String key);
    }
}
