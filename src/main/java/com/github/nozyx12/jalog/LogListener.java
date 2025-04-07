package com.github.nozyx12.jalog;

/**
 * The LogListener interface defines methods to handle different levels of logging events.
 * Implementations of this interface can be registered to a {@link Logger} to receive notifications
 * for info, debug, warning, and error logs.
 */
public interface LogListener {
    /**
     * Called when an info-level log is generated.
     *
     * @param content the log message.
     */
    void onInfo(String content);

    /**
     * Called when a debug-level log is generated.
     *
     * @param content the log message.
     */
    void onDebug(String content);

    /**
     * Called when a warning-level log is generated.
     *
     * @param content the log message.
     */
    void onWarning(String content);

    /**
     * Called when an error-level log is generated with an associated throwable cause.
     *
     * @param content the log message.
     * @param cause the exception that caused the error.
     */
    void onError(String content, Throwable cause);

    /**
     * Called when an error-level log is generated without an associated throwable cause.
     *
     * @param content the log message.
     */
    void onError(String content);
}