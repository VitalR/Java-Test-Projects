package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    private By signin = By.cssSelector("a[href='http://qaclickacademy.usefedora.com/sign_in']");
    private By title = By.cssSelector(".text-center>h2");
    private By navBar = By.cssSelector("div[role='navigation']");
    private By header = By.cssSelector("div[class*='video-banner'] h3");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogin()
    {
        return driver.findElement(signin);
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getNavigationBar()
    {
        return driver.findElement(navBar);
    }

    public WebElement getHeader()
    {
        return driver.findElement(header);
    }
}
