package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
    WebDriver driver = null;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()=\"Admin\"]")
    WebElement adminBtn;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]")
    WebElement addUserBtn;

    @FindBy(xpath = "//div[@role='listbox']//div[1]")
    WebElement userRoleDrpDwnBtn;

    @FindBy(xpath = "//div[@role='listbox']//div[2]")
    WebElement userRoleDrpDwnAdminBtn;

    @FindBy(xpath = "//div[@role='listbox']//div[3]")
    WebElement userRuserRoleDrpDwnESSBtn;

    @FindBy(xpath = "(//div[@class='oxd-select-text--after'])[2]")
    WebElement statusDrpDwnBtn;

    @FindBy(xpath = "//div[@class=\"oxd-select-option\"][1]")
    WebElement statusSelectDrpDwnBtn;

    @FindBy(xpath = "//span[text()='Enabled']")
    WebElement statusDrpDwnEnabledOption;

    @FindBy(xpath = "//span[text()='Disabled']")
    WebElement statusDrpDwnDisabledOption;

    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div//input[@type='password']")
    WebElement userNameTextBox;

    @FindBy(xpath = "oxd-text oxd-text--p user-password-hint")
    WebElement pwdHintText;

    @FindBy (xpath = "//div[@class='oxd-form-row user-password-row']//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div//input[@class='oxd-input oxd-input--active']")
    WebElement passWordTextBox;

    @FindBy (xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassWordTextBox;

    @FindBy (xpath ="//button[text()=' Cancel ']")
    WebElement cancelBtn;

    @FindBy (xpath ="//button[text()=' Save ']")
    WebElement saveBtn;

    @FindBy (xpath= "//h5[text()='System Users']")
    WebElement textSystemUser;

    

    public void clickAdmin ()
    {
        adminBtn.click();
    }
    public void clickAddUserBtn ()    {addUserBtn.click(); }
    public  void clickuserRoleDrpDwnBtn(){userRoleDrpDwnBtn.click();}
    public  void clickuserRoleDrpDwnAdminBtn(){userRoleDrpDwnAdminBtn.click();}
    public  void clickstatusDrpDwnBtn(){statusDrpDwnBtn.click();}

    public void enterUserName (String userName){userNameTextBox.sendKeys(userName);}
    public void enterPwd (String Password) {passWordTextBox.sendKeys(Password);}
    public String getPwdHintText () {return pwdHintText.getText();}
    public void enterConfirmPwd (String ConfirmPwd) {confirmPassWordTextBox.sendKeys(ConfirmPwd);}
    public void clickCancelBtn () {cancelBtn.click();}    public void clickSaveBtn () {saveBtn.click();}
}
