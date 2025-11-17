package TestMethods;

import Driver.DriverManager;
import PageObjectModel.DashBoard;
import PageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.DataProviders;
import java.io.IOException;

public class TestLoginPage extends BaseClass {
    public LoginPage loginPage;
    public DashBoard dashBoard;
    WebDriver driver;
    public TestLoginPage() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
        dashBoard = new DashBoard(driver);
    }

    @Test (groups = {"newFeature", "positiveTest", "regression"})
    public void successFulLogin() {
        loginPage.EnterUserName(properties.getProperty("username"));
        loginPage.EnterPassword(properties.getProperty("password"));
        loginPage.ClickLoginButton();
        Assert.assertEquals(loginPage.getDashBoardText(), "Dashboard");
        logger.debug("Login is Successful");
        dashBoard.clickProfileButton();
        dashBoard.clickLogoutButton();
        Assert.assertEquals(loginPage.getTextLogin(), "Login");
        logger.debug("LogOut is Successful");
    }

    @Test(groups = {"newFeature", "negativeTest", "regression"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void testInvalidInput(String userName, String passWord) {
        loginPage.EnterUserName(userName);
        loginPage.EnterPassword(passWord);
        loginPage.ClickLoginButton();
        Assert.assertEquals(loginPage.getInvalidCredMsg(),"Invalid credentials");
        logger.debug("Login is not successful with Invalid Credentials");
    }
}
