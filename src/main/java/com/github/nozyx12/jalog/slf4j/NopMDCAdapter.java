package com.github.nozyx12.jalog.slf4j;

import java.util.Collections;
import java.util.Deque;
import java.util.Map;

/**
 * A no-operation (NOP) implementation of the {@link org.slf4j.spi.MDCAdapter} interface.
 * <p>
 * This adapter is used when integrating Jalog with SLF4J but where the Mapped Diagnostic Context (MDC)
 * is not supported. All methods in this class are implemented as no-operations or return default values.
 * </p>
 */
public class NopMDCAdapter implements org.slf4j.spi.MDCAdapter {
    /**
     * Puts a key-value pair into the MDC context. This is a no-op implementation.
     *
     * @param s   the key
     * @param s1  the value
     */
    @Override
    public void put(String s, String s1) {}

    /**
     * Gets the value for the given key from the MDC context. This is a no-op implementation and always returns an empty string.
     *
     * @param s  the key
     * @return an empty string
     */
    @Override
    public String get(String s) {
        return "";
    }

    /**
     * Removes the value for the given key from the MDC context. This is a no-op implementation.
     *
     * @param s  the key
     */
    @Override
    public void remove(String s) {}

    /**
     * Clears all values in the MDC context. This is a no-op implementation.
     */
    @Override
    public void clear() {}

    /**
     * Returns a copy of the MDC context map. This is a no-op implementation and always returns an empty map.
     *
     * @return an empty map
     */
    @Override
    public Map<String, String> getCopyOfContextMap() {
        return Collections.emptyMap();
    }

    /**
     * Sets the MDC context map. This is a no-op implementation.
     *
     * @param map  the map to set
     */
    @Override
    public void setContextMap(Map<String, String> map) {}

    /**
     * Pushes a key-value pair into the MDC context stack. This is a no-op implementation.
     *
     * @param s   the key
     * @param s1  the value
     */
    @Override
    public void pushByKey(String s, String s1) {}

    /**
     * Pops the value for the given key from the MDC context stack. This is a no-op implementation and always returns an empty string.
     *
     * @param s  the key
     * @return an empty string
     */
    @Override
    public String popByKey(String s) {
        return "";
    }

    /**
     * Returns a copy of the MDC context stack for the given key. This is a no-op implementation and always returns null.
     *
     * @param s  the key
     * @return null
     */
    @Override
    public Deque<String> getCopyOfDequeByKey(String s) {
        return null;
    }

    /**
     * Clears the MDC context stack for the given key. This is a no-op implementation.
     *
     * @param s  the key
     */
    @Override
    public void clearDequeByKey(String s) {}
}
