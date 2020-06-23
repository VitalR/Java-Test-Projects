import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.BaseResourseClass;
import java.io.IOException;



public class VerifyTitle extends BaseResourseClass {

    public static Logger logger = LogManager.getLogger(BaseResourseClass.class.getName());
    LandingPage landingPage;

    @BeforeTest
    public void inicialized() throws IOException {
        driver = inicializeDriver();
        logger.info("Driver is initialized");
        driver.get(properties.getProperty("url"));
        logger.info("Navigate to home page");
    }

    @Test
    public void validateAppTitle() throws IOException {
        landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
        logger.info("Title is successfully validated");
    }

    @Test
    public void validateHeader() throws IOException {
        //landingPage = new LandingPage(driver);
        Assert.assertEquals(landingPage.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
        logger.info("Header is successfully validated");
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}
