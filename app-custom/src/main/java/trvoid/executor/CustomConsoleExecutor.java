package trvoid.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomConsoleExecutor extends ConsoleExecutor {
    private static Logger LOGGER = LoggerFactory.getLogger(CustomConsoleExecutor.class);

    protected CustomConsoleExecutor() {
        super();
    }

    @Override
    protected void initBeanFactory() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml",
                "classpath:applicationContext-custom.xml"
        );

        setBeanFactory(beanFactory);
    }

    public static void main(String[] args) {
        LOGGER.info("App 1.0");

        CustomConsoleExecutor consoleExecutor = new CustomConsoleExecutor();
        consoleExecutor.start();
    }
}
