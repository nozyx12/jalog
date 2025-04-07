package com.github.nozyx12.jalog.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/**
 * This class implements the {@link SLF4JServiceProvider} interface, providing integration between the SLF4J API
 * and the Jalog logging system.
 * <p>
 * It provides the necessary components to make Jalog compatible with SLF4J, including a custom {@link ILoggerFactory},
 * a default no-operation MDC adapter, and the API version requested.
 * </p>
 */
public class JalogSLF4JServiceProvider implements SLF4JServiceProvider {
    private final JalogLoggerFactory loggerFactory = new JalogLoggerFactory();

    /**
     * Returns the {@link ILoggerFactory} implementation for this provider.
     * This method will return an instance of {@link JalogLoggerFactory}.
     *
     * @return the logger factory
     */
    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    /**
     * Returns the {@link IMarkerFactory} implementation for this provider.
     * Since Jalog does not provide a marker factory, this method returns null.
     *
     * @return null as Jalog does not support marker factory
     */
    @Override
    public IMarkerFactory getMarkerFactory() {
        return null;
    }

    /**
     * Returns the {@link MDCAdapter} implementation for this provider.
     * This method returns a {@link NopMDCAdapter}, a no-operation implementation,
     * as Jalog does not currently support MDC (Mapped Diagnostic Context).
     *
     * @return a no-operation MDC adapter
     */
    @Override
    public MDCAdapter getMDCAdapter() {
        return new NopMDCAdapter();
    }

    /**
     * Returns the version of the SLF4J API requested by this provider.
     *
     * @return the requested API version, "2.0.17"
     */
    @Override
    public String getRequestedApiVersion() {
        return "2.0.17";
    }

    /**
     * Initializes the service provider. This method does nothing in this implementation.
     */
    @Override
    public void initialize() {}
}
