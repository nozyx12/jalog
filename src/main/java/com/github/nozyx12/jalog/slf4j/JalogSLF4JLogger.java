package com.github.nozyx12.jalog.slf4j;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * An implementation of {@link Logger} for SLF4J that routes logging calls to the Jalog logging system.
 * <p>
 * This class provides the core logging methods that SLF4J users will invoke. It adapts SLF4J calls to the Jalog
 * backend, ensuring proper log levels and formatting.
 * </p>
 */
public class JalogSLF4JLogger implements Logger {
    private final com.github.nozyx12.jalog.Logger logger;

    /**
     * Constructs a new {@link JalogSLF4JLogger} with the specified logger name.
     *
     * @param loggerName the name of the logger
     */
    public JalogSLF4JLogger(String loggerName) {
        this.logger = new com.github.nozyx12.jalog.Logger(loggerName);
    }

    /**
     * Returns the name of the logger.
     *
     * @return the name of the logger
     */
    @Override
    public String getName() {
        return this.logger.getName();
    }


    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String s) {
        debug(s);
    }

    @Override
    public void trace(String s, Object o) {
        debug(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        debug(s, o, o1);
    }

    @Override
    public void trace(String s, Object... objects) {
        debug(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        debug(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return true;
    }

    @Override
    public void trace(Marker marker, String s) {
        debug(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        debug(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        debug(marker, s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        debug(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        debug(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public void debug(String s) {
        logger.debug(s);
    }

    @Override
    public void debug(String s, Object o) {
        logger.debug(slf4jFormat(s, o));
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        logger.debug(slf4jFormat(s, o, o1));
    }

    @Override
    public void debug(String s, Object... objects) {
        logger.debug(slf4jFormat(s, objects));
    }

    @Override
    public void debug(String s, Throwable throwable) {
        logger.debug(s);
        logger.stacktrace(throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return true;
    }

    @Override
    public void debug(Marker marker, String s) {
        debug("[" + marker.getName() + "] " + s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        debug("[" + marker.getName() + "] " + s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        debug("[" + marker.getName() + "] " + s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        debug("[" + marker.getName() + "] " + s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        debug("[" + marker.getName() + "] " + s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public void info(String s) {
        logger.info(s);
    }

    @Override
    public void info(String s, Object o) {
        logger.info(slf4jFormat(s, o));
    }

    @Override
    public void info(String s, Object o, Object o1) {
        logger.info(slf4jFormat(s, o, o1));
    }

    @Override
    public void info(String s, Object... objects) {
        logger.info(slf4jFormat(s, objects));
    }

    @Override
    public void info(String s, Throwable throwable) {
        logger.info(s);
        logger.stacktrace(throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return true;
    }

    @Override
    public void info(Marker marker, String s) {
        info("[" + marker.getName() + "] " + s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        info("[" + marker.getName() + "] " + s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        info("[" + marker.getName() + "] " + s, o, o1);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        info("[" + marker.getName() + "] " + s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        info("[" + marker.getName() + "] " + s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return true;
    }

    @Override
    public void warn(String s) {
        logger.warning(s);
    }

    @Override
    public void warn(String s, Object o) {
        logger.warning(slf4jFormat(s, o));
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        logger.warning(slf4jFormat(s, o, o1));
    }

    @Override
    public void warn(String s, Object... objects) {
        logger.warning(slf4jFormat(s, objects));
    }

    @Override
    public void warn(String s, Throwable throwable) {
        logger.warning(s);
        logger.stacktrace(throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return true;
    }

    @Override
    public void warn(Marker marker, String s) {
        warn("[" + marker.getName() + "] " + s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        warn("[" + marker.getName() + "] " + s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        warn("[" + marker.getName() + "] " + s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        warn("[" + marker.getName() + "] " + s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        warn("[" + marker.getName() + "] " + s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public void error(String s) {
        logger.error(s);
    }

    @Override
    public void error(String s, Object o) {
        logger.error(slf4jFormat(s, o));
    }

    @Override
    public void error(String s, Object o, Object o1) {
        logger.error(slf4jFormat(s, o, o1));
    }

    @Override
    public void error(String s, Object... objects) {
        logger.error(slf4jFormat(s, objects));
    }

    @Override
    public void error(String s, Throwable throwable) {
        logger.error(s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return true;
    }

    @Override
    public void error(Marker marker, String s) {
        error("[" + marker.getName() + "] " + s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        error("[" + marker.getName() + "] " + s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        error("[" + marker.getName() + "] " + s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        error("[" + marker.getName() + "] " + s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        error("[" + marker.getName() + "] " + s, throwable);
    }

    /**
     * Formats the log message to handle SLF4J placeholders ("{}").
     *
     * @param s the message to format
     * @param objects the objects to insert into the message
     * @return the formatted message
     */
    private String slf4jFormat(String s, Object... objects) {
        for (Object o : objects) {
            s = s.replaceFirst("\\{}", o == null ? "null" : o.toString());
        }
        return s;
    }
}
