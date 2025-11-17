package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
    WebDriver driver = null;
    public DashBoard (WebDriver driver)
    {
        PageFactory.initElements (driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//p[@class = \"oxd-userdropdown-name\"]")
    WebElement btnProfileDrpDown;

    @FindBy (xpath = "//a[text()=\"Logout\"]")
    WebElement btnLogout;

    public void clickProfileButton () {
        btnProfileDrpDown.click();
    }

    public void clickLogoutButton ()
    {
        btnLogout.click();
    }
}
