package TestMethods;

import Driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    Properties properties;
    public Logger logger;

    @BeforeSuite(groups = {"newFeature", "positiveTest", "regression"},alwaysRun = true)
    public void setUp() throws IOException
    {

       String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
        FileInputStream file = new FileInputStream(filepath);
        properties = new Properties();
        properties.load(file);
        logger = LogManager.getLogger(this.getClass());

       /** if (driver == null) {
            //System.setProperty("Webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Documents\\Selenium-Automation\\IdeaProjects\\WebDrivers\\chromedriver-win64\\chromedriver-win64");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
        }**/

        WebDriver driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
    }
    @AfterSuite (alwaysRun = true)
    public void setupClose() {
      DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
        System.out.println("This is AfterSuit method");
    }

    public static WebDriver getDriver () {
        return driver;
    }
}
