package trvoid.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMessageHandler implements MessageHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(DefaultMessageHandler.class);

    @Override
    public void handle(String message) {
        LOGGER.info("handle: " + message);
    }
}
