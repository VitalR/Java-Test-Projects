
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.BaseResourseClass;

import java.io.IOException;

public class HomePage extends BaseResourseClass {

    public static Logger logger = LogManager.getLogger(BaseResourseClass.class.getName());

    @BeforeTest
    public void inicialized() throws IOException {
        driver = inicializeDriver();
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password, String text) throws IOException {

        driver.get(properties.getProperty("url"));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginB().click();
        //System.out.println(text);
        logger.info(text);

    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }

    @DataProvider
    public Object[][] getData() {

        //Row stands how many diff data types should run
        //Columns stands how many values per each test

        Object[][] data = new Object[2][3];
        //0th row
        data[0][0] = "Nonrestricteduser@qa.com";
        data[0][1] = "12345";
        data[0][2] = "Non restricted User";
        //1st row
        data[1][0] = "restricteduser@qa.com";
        data[1][1] = "82345";
        data[1][2] = "Restricted User";

        return data;
    }
}
