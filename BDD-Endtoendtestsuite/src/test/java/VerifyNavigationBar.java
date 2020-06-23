

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.BaseResourseClass;

import java.io.IOException;


public class VerifyNavigationBar extends BaseResourseClass {

    public static Logger logger = LogManager.getLogger(BaseResourseClass.class.getName());

    @BeforeTest
    public void inicialized() throws IOException {
        driver = inicializeDriver();
        logger.info("Driver is initialized");
        driver.get(properties.getProperty("url"));
        logger.info("Navigate to home page");
    }

    @Test
    public void verifyNavigationBar() throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.getNavigationBar().isDisplayed());
        logger.info("Navigation Bar is successfully validated");
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }

}
