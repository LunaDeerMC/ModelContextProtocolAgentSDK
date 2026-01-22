package cn.lunadeer.mc.modelContextProtocolAgentSDK.api;

import java.util.Map;

/**
 * Filter for event subscriptions.
 * <p>
 * Allows subscribers to specify criteria for which events they want to receive.
 * </p>
 *
 * @author ZhangYuheng
 * @since 1.0.0
 */
public class SubscriptionFilter {

    private final Map<String, Object> criteria;

    /**
     * Creates a new subscription filter.
     *
     * @param criteria the filter criteria
     */
    public SubscriptionFilter(Map<String, Object> criteria) {
        this.criteria = criteria;
    }

    /**
     * Gets a filter criterion by key.
     *
     * @param key the criterion key
     * @return the criterion value, or null if not present
     */
    public Object get(String key) {
        return criteria.get(key);
    }

    /**
     * Gets a string criterion by key.
     *
     * @param key the criterion key
     * @return the string criterion value, or null if not present
     */
    public String getString(String key) {
        Object value = criteria.get(key);
        return value != null ? value.toString() : null;
    }

    /**
     * Gets a boolean criterion by key.
     *
     * @param key the criterion key
     * @param defaultValue default value if not present
     * @return the boolean criterion value
     */
    public Boolean getBoolean(String key, Boolean defaultValue) {
        Object value = criteria.get(key);
        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        return defaultValue;
    }

    /**
     * Gets a number criterion by key.
     *
     * @param key the criterion key
     * @return the number criterion value, or null if not present
     */
    public Number getNumber(String key) {
        Object value = criteria.get(key);
        if (value instanceof Number) {
            return (Number) value;
        }
        return null;
    }

    /**
     * Checks if a criterion exists.
     *
     * @param key the criterion key
     * @return true if the criterion exists
     */
    public boolean has(String key) {
        return criteria.containsKey(key);
    }

    /**
     * Gets all criteria as a map.
     *
     * @return the criteria map
     */
    public Map<String, Object> getAll() {
        return criteria;
    }

    /**
     * Creates a builder for SubscriptionFilter.
     *
     * @return a new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for SubscriptionFilter.
     */
    public static class Builder {

        private final java.util.Map<String, Object> criteria = new java.util.HashMap<>();

        /**
         * Adds a criterion.
         *
         * @param key the criterion key
         * @param value the criterion value
         * @return this builder
         */
        public Builder with(String key, Object value) {
            criteria.put(key, value);
            return this;
        }

        /**
         * Builds the SubscriptionFilter.
         *
         * @return the subscription filter
         */
        public SubscriptionFilter build() {
            return new SubscriptionFilter(criteria);
        }
    }
}
