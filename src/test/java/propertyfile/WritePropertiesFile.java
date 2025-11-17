package propertyfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {
        public static void main (String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("url", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        properties.setProperty("browser", "chrome");
        properties.setProperty("chromedriverpath", "C:\\Users\\HP\\OneDrive\\Documents\\Selenium-Automation\\IdeaProjects\\WebDrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        properties.setProperty("edgedriverpath", "C:\\Users\\HP\\OneDrive\\Documents\\Selenium-Automation\\IdeaProjects\\WebDrivers\\edgedriver_win64\\msedgedriver.exe");
        properties.setProperty("firefoxdriverpath", "C:\\Users\\HP\\OneDrive\\Documents\\Selenium-Automation\\IdeaProjects\\WebDrivers\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
        String filepath = System.getProperty("user.dir") + "\\data\\config.properties";
        FileOutputStream file = new FileOutputStream(filepath);
        properties.store(file, "this is configuration property file");

    }
    }

