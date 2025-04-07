package com.github.nozyx12.jalog;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Logger is a simple logging utility that logs messages to both the console
 * and a specified log file. It supports multiple levels of logging such as
 * info, debug, warning, and error, and allows registering listeners for custom behavior.
 */
public class Logger {
    private final String name;
    private final File logFile;
    private final List<LogListener> listeners = new ArrayList<>();

    /**
     * Creates a logger without log file saving.
     * <p>
     * This constructor initializes a logger that only outputs to the console,
     * without storing logs in a file.
     *
     * @param name the name of the logger.
     */
    public Logger(String name) {
        this(name, null);
    }

    /**
     * Creates a logger with a specified log file.
     *
     * @param name the name of the logger.
     * @param logFile the file where logs will be written. (Can be null if you don't want to save your logs into a file)
     */
    public Logger(String name, File logFile) {
        this.name = name;
        this.logFile = logFile;

        SystemLogger.init();
    }

    /**
     * Logs an info message and notifies registered listeners.
     *
     * @param content the message to log.
     */
    public void info(String content) {
        for (LogListener listener : listeners) listener.onInfo(content);
        print("[INFO]: " + content);
    }

    /**
     * Logs a debug message and notifies registered listeners.
     *
     * @param content the message to log.
     */
    public void debug(String content) {
        for (LogListener listener : listeners) listener.onDebug(content);
        print("[DEBUG]: " + content);
    }

    /**
     * Logs a warning message and notifies registered listeners.
     *
     * @param content the message to log.
     */
    public void warning(String content) {
        for (LogListener listener : listeners) listener.onWarning(content);
        print("[WARNING]: " + content);
    }

    /**
     * Logs an error message with an optional throwable cause and notifies registered listeners.
     *
     * @param content the message to log.
     * @param cause the exception that caused the error.
     */
    public void error(String content, Throwable cause) {
        for (LogListener listener : listeners) listener.onError(content, cause);
        print("[ERROR]: " + content);
        stacktrace(cause);
    }

    /**
     * Logs the stack trace of a given throwable cause.
     *
     * @param cause the throwable whose stack trace will be logged.
     */
    public void stacktrace(Throwable cause) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        cause.printStackTrace(pw);

        int lastNewLineIndex = sw.toString().lastIndexOf("\n");
        String stackTrace = sw.toString().substring(0, lastNewLineIndex);

        error("\n" + stackTrace);
    }

    /**
     * Logs an error message and notifies registered listeners.
     *
     * @param content the message to log.
     */
    public void error(String content) {
        for (LogListener listener : listeners) listener.onError(content);
        print("[ERROR]: " + content);
    }

    /**
     * Prints the message to both the console and the log file, ensuring
     * that all necessary parent directories are created for the log file.
     * (Internal Logger Method)
     *
     * @param content the message to log.
     */
    private void print(String content) {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        String toPrint = "[" + formattedDateTime + "] [" + this.name + "] " + content;

        System.out.println(toPrint);

        if (logFile == null) return;

        if (!logFile.exists() || !logFile.isFile()) {
            try {
                logFile.getAbsoluteFile().getParentFile().mkdirs();
                logFile.createNewFile();
            } catch (Exception e) {
                System.out.println("Jalog Logger Error: Could not create log file for the logger named '" + name + "'");

                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);

                int lastNewLineIndex = sw.toString().lastIndexOf("\n");
                String stackTrace = sw.toString().substring(0, lastNewLineIndex);

                System.out.println("Error info: " + stackTrace);
            }
        }

        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(toPrint + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Jalog Logger Error: Could not write to log file for the logger named '" + name + "'");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            int lastNewLineIndex = sw.toString().lastIndexOf("\n");
            String stackTrace = sw.toString().substring(0, lastNewLineIndex);

            System.out.println("Error info: " + stackTrace);
        }
    }

    /**
     * Registers a new log listener to be notified when logs are generated.
     *
     * @param listener the log listener to register.
     */
    public void registerListener(LogListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Returns the name of the logger.
     * <p>
     * The name is typically used to identify the logger in a logging system.
     * It can be the name of the class or a custom string depending on the configuration.
     * </p>
     *
     * @return the name of the logger, typically used to identify the logger.
     */
    public String getName() {
        return this.name;
    }
}