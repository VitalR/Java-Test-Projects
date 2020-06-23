import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import resources.BaseResourseClass;

import java.sql.*;


public class JdbcConnector {

    public static Logger logger = LogManager.getLogger(BaseResourseClass.class.getName());

    @Test
    public void jdbcConnector() throws SQLException {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/world";

        final String USER = "root";
        final String PASS = "Vital@2019";

        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from city where id=6;");

        while (resultSet.next()) {
            driver.findElement(By.id("username")).sendKeys(resultSet.getString("Name"));
            driver.findElement(By.id("password")).sendKeys(resultSet.getString("CountryCode"));
        }
    }
}
