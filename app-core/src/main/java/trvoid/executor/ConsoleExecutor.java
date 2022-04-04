package trvoid.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleExecutor {
    private static Logger LOGGER = LoggerFactory.getLogger(ConsoleExecutor.class);

    private BeanFactory beanFactory;

    protected ConsoleExecutor() {
        initBeanFactory();
    }

    protected void initBeanFactory() {
        beanFactory = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml",
                "classpath:applicationContext-default.xml"
        );
    }

    protected void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    protected void start() {
        final ServiceExecutor serviceExecutor = beanFactory.getBean("serviceExecutor", ServiceExecutor.class);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    LOGGER.info("Application is stopping...");
                    serviceExecutor.stop();
                    LOGGER.info("Application stopped.");
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        });

        try {
            LOGGER.info("Application is starting...");
            serviceExecutor.start();
            LOGGER.info("Application started.");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        LOGGER.info("App 1.0");

        ConsoleExecutor executor = new ConsoleExecutor();
        executor.start();
    }
}
