package trvoid.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMessageHandler implements MessageHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomMessageHandler.class);

    @Override
    public void handle(String message) {
        LOGGER.info("handle: " + message);
    }
}
