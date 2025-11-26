package TestMethods;

import Driver.DriverManager;
import PageObjectModel.ForgetPassword;
import PageObjectModel.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestForgetPassword extends BaseClass {
      WebDriver driver;
      ForgetPassword forgetPassword;
      LoginPage loginPage;
      Logger logger;
      public TestForgetPassword ()
      {
         driver = DriverManager.getDriver();
         forgetPassword = new ForgetPassword(driver);
         loginPage = new LoginPage(driver);
          logger = LogManager.getLogger(this.getClass());
      }

      @Test (priority= 0, groups = {"newFeature", "smoke", "regression"})
              public void pageResetPwd ()
      {
          loginPage.clickForgetPwd();
          Assert.assertEquals(forgetPassword.MsgResetPwd(),"Reset Password");
          logger.debug("Reset Password page appeared successfully");
      }

      @Test (priority= 1,groups = {"newFeature", "smoke", "regression"}, dependsOnMethods = "pageResetPwd" )
    public void testCancelbtn ()
      {
        forgetPassword.clickCancelButton();
        Assert.assertEquals(loginPage.getTextLogin(),"Login");
        logger.debug("Login page displayed. Cancel button worked as expected.");
    }

    @Test (priority= 2,groups = {"newFeature", "smoke", "regression"}, dependsOnMethods = "pageResetPwd")
    public void successResetPwd ()
    {
        loginPage.clickForgetPwd();
        Assert.assertEquals(forgetPassword.MsgResetPwd(),"Reset Password");
        logger.debug("Reset Password page appeared successfully");
        forgetPassword.enterUserName(properties.getProperty("username"));
        forgetPassword.clickResetPasswordButton();
        System.out.println (forgetPassword.textMsgResetSuccess());
    }
}