package trvoid.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppScheduler {
    private static Logger LOGGER = LoggerFactory.getLogger(AppScheduler.class);

    private int count = 0;

    public void sayHello() {
        LOGGER.info("Hello ~ " + ++count);
    }
}
