package alpha;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

    final static Logger logger = LogManager.getLogger(Demo.class);


    public static void main(String[] args) {

      /*  logger.debug("I am debugging");

        if(5 < 3)
            logger.info("The object is present");
        logger.error("The object is not present");

        logger.fatal("This is fatal"); */

        PropertyConfigurator.configure("/Users/agileengine/JavaSeleniumTestProjects/Log4jTutorial/src/test/java/resources/log4j2.xml");

        logger.error("Logger is configured");

        System.out.println("Hello!");
    }
}
