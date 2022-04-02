package trvoid.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trvoid.handler.MessageHandler;

public class ServiceExecutor {
    private static Logger LOGGER = LoggerFactory.getLogger(ServiceExecutor.class);

    private MessageHandler messageHandler;

    private boolean keepRunning = true;

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void start() throws Exception {
        LOGGER.info("Service is starting...");
        LOGGER.info("Service started.");

        int count = 0;
        while (keepRunning) {
            Thread.sleep(1000);
            messageHandler.handle("count " + ++count);
        }
    }

    public void stop() throws Exception {
        LOGGER.info("Service is stopping...");
        keepRunning = false;
        LOGGER.info("Service stopped.");
    }
}
