package com.oscroll.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
    private volatile Connector connector;

    public void customize(Connector connector) {
        this.connector = connector;
    }

    public void onApplicationEvent(ContextClosedEvent event) {
        this.connector.pause();
        Executor executor = this.connector.getProtocolHandler().getExecutor();
        if (executor instanceof ThreadPoolExecutor) {
            try {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                threadPoolExecutor.shutdown();
                if (!threadPoolExecutor.awaitTermination(30, TimeUnit.SECONDS)) {
                    log.warn("Tomcat thread pool did not shut down gracefully within "
                            + "30 seconds. Proceeding with forceful shutdown");
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
