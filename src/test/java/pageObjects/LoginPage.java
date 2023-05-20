package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#input-email")
    WebElement txtEmail;
    @FindBy(css = "#input-password")
    WebElement txtPassword;
    @FindBy(css = "button.btn.btn-primary")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setTxtEmail(String email){
        fillText(txtEmail, email);
    }

    public void setTxtPassword(String password) {
        fillText(txtPassword, password);
    }

    public void clickLogin() {
        click(loginBtn);
    }

}
