package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseResourseClass {

    public WebDriver driver; //-should be static in case not parallel run
    public Properties properties = new Properties();

    public WebDriver inicializeDriver() throws IOException {

        //System.getProperty("user.dir");
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser"); //run with data.properties

        //mvn test -DbrowserName=chrome
        //String browserName = System.getProperty("browser");

        if(browserName.contains("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
            ChromeOptions options = new ChromeOptions();
            if(browserName.contains("headless")) {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
        else if(browserName.equalsIgnoreCase("Firefox"))
        {
            //Firefox code
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/java/resources/geckodriver");
            driver = new FirefoxDriver();

        }
        else if(browserName.equalsIgnoreCase("Edge"))
        {
            //IE code
            System.setProperty("webdriver.edge.driver", "/Users/agileengine/Documents/workspace/selenium/msedgedriver");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
        public void getScreenshot(String result) throws IOException {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/screenshots/"+result+"screensho.png"));

        }
}
