package TestMethods;

import PageObjectModel.AdminPage;

public class TestAdminPageAddUser extends BaseClass{
    AdminPage adminPage;
    WebDriver driver;

    public TestAdminPageAddUser ()
    {
        driver= DriverManager.getDriver();
        adminPage = new AdminPage ();
    }

}
