package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPassword {
    WebDriver driver = null;

    public ForgetPassword(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy (xpath = "//h6[text()='Reset Password']")
    WebElement resetPwd;

    @FindBy (name= "username")
    WebElement textBoxUsername;

    @FindBy (xpath = "//*[@class= \"oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel\"]")
    WebElement buttonCancel;

    @FindBy (xpath = "//button[@class=\"oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset\"]")
    WebElement buttonResetPassword;

    @FindBy (xpath = "(//p[@class=\"oxd-text oxd-text--p\" or @class= \"oxd-text oxd-text--p orangehrm-sub-title\"])")
    WebElement msgResetSuccess;

    public void enterUserName (String userName)
    {
        textBoxUsername.sendKeys(userName);
    }

    public void clickCancelButton ()
    {
        buttonCancel.click ();
    }

    public void clickResetPasswordButton ()
    {
        buttonResetPassword.click();
    }

    public String textMsgResetSuccess ()
    {
       return msgResetSuccess.getText();
    }
    public String MsgResetPwd ()
    {
        return resetPwd.getText();
    }
}
