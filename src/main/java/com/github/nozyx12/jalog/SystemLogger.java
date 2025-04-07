package com.github.nozyx12.jalog;

import java.io.PrintStream;

/**
 * A custom logger that intercepts and redirects standard system output and error streams
 * (`System.out` and `System.err`) to a logger implementation, unless the messages are already
 * formatted logs or contain specific error identifiers.
 *
 * <p>This class extends {@link Logger} and replaces the system print streams with customized
 * {@link PrintStream} instances that forward loggable content through the {@code Jalog} logging system.
 *
 * <p>To activate the redirection, call {@link #init()} once at application startup.
 */
public class SystemLogger extends Logger {
    private static boolean initialized = false;

    /**
     * Initializes the {@code SystemLogger} by replacing the standard output and error streams
     * with custom ones that forward messages through the Jalog logger.
     *
     * <p>Messages that match the Jalog log format or that begin with "Jalog Logger Error:" are
     * considered already formatted and are printed normally without redirection.
     *
     * <p>This method is called automatically in every Jalog Logger constructor.
     * You do not need to call it manually.
     */
    public static void init() {
        if (initialized) return;
        initialized = true;

        SystemLogger systemLogger = new SystemLogger();

        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        PrintStream jalogCustomOut = new PrintStream(System.out) {
            @Override
            public void println(String s) {
                if (s == null) return;

                if (s.matches("^\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}] \\[.*] \\[.*]:.*") || s.startsWith("Jalog Logger Error: ")) {
                    originalOut.println(s);
                    return;
                }

                systemLogger.info(s);
            }

            @Override
            public void println(Object x) {
                if (x == null) return;

                String s;
                try {
                    s = x.toString();
                } catch (Exception e) {
                    s = "Error calling toString() on object: " + e.getMessage();
                }

                if (s.matches("^\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}] \\[.*] \\[.*]:.*") || s.startsWith("Jalog Logger Error: ")) {
                    originalOut.println(x);
                    return;
                }

                println(s);
            }
        };

        PrintStream jalogCustomErr = new PrintStream(System.err) {
            @Override
            public void println(String s) {
                if (s == null) return;

                if (s.matches("^\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}] \\[.*] \\[.*]:.*") || s.startsWith("Jalog Logger Error: ")) {
                    originalErr.println(s);
                    return;
                }

                systemLogger.error(s);
            }

            @Override
            public void println(Object x) {
                if (x == null) return;

                String s;
                try {
                    s = x.toString();
                } catch (Exception e) {
                    s = "Error calling toString() on object: " + e.getMessage();
                }

                if (s.matches("^\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}] \\[.*] \\[.*]:.*") || s.startsWith("Jalog Logger Error: ")) {
                    originalErr.println(x);
                    return;
                }

                println(s);
            }
        };

        System.setOut(jalogCustomOut);
        System.setErr(jalogCustomErr);
    }

    /**
     * Private constructor that initializes the logger with the name "SystemOutput".
     * This ensures it is only instantiated internally within {@link #init()}.
     */
    private SystemLogger() {
        super("SystemOutput");
    }
}
