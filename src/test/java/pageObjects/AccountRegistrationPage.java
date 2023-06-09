package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#input-firstname")
    WebElement firstNameTxt;
    @FindBy(css = "#input-lastname")
    WebElement lastNameTxt;
    @FindBy(css = "#input-email")
    WebElement emailTxt;
    @FindBy(css = "#input-password")
    WebElement passwordTxt;
    @FindBy(css = ".text-end .form-check-input")
    WebElement checkPolicyBtn;
    @FindBy(css = ".btn.btn-primary")
    WebElement continueBtn;
    @FindBy(css = "#content>h1")
    WebElement msgConfirmation;
    @FindBy(css = "#error-firstname")
    WebElement errorMsgEmptyFirstName;

    public void setFirstName(String fname) {
        fillText(firstNameTxt, fname);
    }

    public void setLastName(String lname) {
        fillText(lastNameTxt, lname);
    }

    public void setEmail(String email) {
        fillText(emailTxt, email);
    }

    public void setPassword(String password) {
        fillText(passwordTxt, password);
    }

    public void setCheckPolicyBtn() {
        moveToElement(checkPolicyBtn);
        waiting(300);
        checkPolicyBtn.click();
    }

    public void clickContinue() {
        click(continueBtn);
    }

    public String getConfirmationMsg() {
        try {
            return getText(msgConfirmation);
        } catch (Exception e) {
            return (e.getMessage());
        }

    }

    public String getErrorMsgFirstName() {
        return getText(errorMsgEmptyFirstName);
    }

}
