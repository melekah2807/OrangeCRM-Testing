package TestMethods;

import Driver.DriverManager;
import PageObjectModel.AdminPage;
import org.openqa.selenium.WebDriver;

public class TestAdminPageAddUser extends BaseClass{
    AdminPage adminPage;
    WebDriver driver;

    public TestAdminPageAddUser ()
    {
        driver= DriverManager.getDriver();
        adminPage = new AdminPage (driver);
    }

}
