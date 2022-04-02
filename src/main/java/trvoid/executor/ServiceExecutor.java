package trvoid.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceExecutor {
    private static Logger LOGGER = LoggerFactory.getLogger(ServiceExecutor.class);

    private boolean keepRunning = true;

    public void start() throws Exception {
        LOGGER.info("Service is starting...");
        LOGGER.info("Service started.");

        int count = 0;
        while (keepRunning) {
            Thread.sleep(1000);
            LOGGER.info("count " + ++count);
        }
    }

    public void stop() throws Exception {
        LOGGER.info("Service is stopping...");
        keepRunning = false;
        LOGGER.info("Service stopped.");
    }
}
