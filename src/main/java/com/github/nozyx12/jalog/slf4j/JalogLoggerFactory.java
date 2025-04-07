package com.github.nozyx12.jalog.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * A SLF4J {@link ILoggerFactory} implementation backed by the Jalog logging system.
 * <p>
 * This factory is responsible for creating and caching instances of {@link JalogSLF4JLogger},
 * which adapt SLF4J logging calls to the Jalog backend.
 * </p>
 * <p>
 * It ensures that each logger name maps to a single {@link Logger} instance.
 * </p>
 */
public class JalogLoggerFactory implements ILoggerFactory {
    private final ConcurrentMap<String, Logger> loggerMap = new ConcurrentHashMap<>();

    /**
     * Returns a logger instance by name. If a logger with the given name does not yet exist,
     * a new {@link JalogSLF4JLogger} is created and cached.
     *
     * @param name the name of the logger
     * @return a {@link Logger} instance corresponding to the given name
     */
    @Override
    public Logger getLogger(String name) {
        return loggerMap.computeIfAbsent(name, JalogSLF4JLogger::new);
    }
}
