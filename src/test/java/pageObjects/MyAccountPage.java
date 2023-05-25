package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(css = "#content>h2:nth-child(1)")
    WebElement msgHeading;
    @FindBy(css = "a:nth-child(13)")
    WebElement logoutBtn;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountPageExist() {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }

    }

    public void clickLogout() {
        click(logoutBtn);
    }
}
