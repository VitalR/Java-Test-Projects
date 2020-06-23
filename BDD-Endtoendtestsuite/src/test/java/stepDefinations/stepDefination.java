package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.BaseResourseClass;

public class stepDefination extends BaseResourseClass {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
        driver = inicializeDriver();
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigateToSit(String arg0) throws Throwable {
        driver.get(arg0);
    }

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();
    }

    @When("^User enter (.+) and (.+) and logs in$")
    public void user_enter_test_gmail_com_and_and_logs_in(String username, String password) throws Throwable {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginB().click();
    }

    @Then("^Verify that User is successfully logged in$")
    public void verify_that_User_is_successfully_logged_in() throws Throwable {
        PortalHomePage portalHomePage = new PortalHomePage(driver);
        Assert.assertTrue(portalHomePage.getSearchBox().isDisplayed());
    }

}