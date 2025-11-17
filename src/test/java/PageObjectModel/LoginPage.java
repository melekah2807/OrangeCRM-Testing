package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver = null;
    public LoginPage (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    @FindBy (name = "username")
    WebElement useNameTextBox;

    @FindBy (name = "password")
    WebElement passWordTextBox;

    @FindBy (xpath = "//*[@class='oxd-form-actions orangehrm-login-action']")
    WebElement loginButton;

    @FindBy (xpath = "//h6[text() = 'Dashboard']")
    WebElement dashBoardText;

    @FindBy (xpath = "//span[text()='Required']")
    WebElement blankUserName_Pwd;

    @FindBy (xpath = "//p[text()=\"Invalid credentials\"]")
    WebElement invalidCredMsg;

    @FindBy (xpath = "//h5[text()='Login']")
    WebElement textLogin;

    @FindBy (xpath = "//p [text () = \"Forgot your password? \"]")
    WebElement linkForgotPassword;

    public void EnterUserName (String userName) {
        useNameTextBox.sendKeys(userName);
    }
    public void clickForgetPwd ()
    {
        linkForgotPassword.click();
    }
    public void EnterPassword (String passWord) {
        passWordTextBox.sendKeys(passWord);
    }
    public String getErrormsg_blankUserName_Pwd ()
    {
        return blankUserName_Pwd.getText();
    }
    public String getDashBoardText ()
    {
        return dashBoardText.getText();
    }

    public String getInvalidCredMsg ()
    {
        return invalidCredMsg.getText();
    }

    public String getTextLogin ()
    {
        return textLogin.getText();
    }

    public void ClickLoginButton (){
        loginButton.click();
    }
}
