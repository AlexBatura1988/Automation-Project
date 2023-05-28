package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//http://localhost/opencart/upload/
public class HomePage extends BasePage {
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountBtn;
    @FindBy(linkText = "Register")
    WebElement registerBtn;
    @FindBy(linkText = "Login")
    WebElement loginBtn;
    @FindBy(css = "#search>input")
    WebElement searchTxt;
    @FindBy(css = "#search>button")
    WebElement searchBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickAccount() {
        sleep(1000);
        click(myAccountBtn);
    }

    public void clickRegister() {
        sleep(1000);
        click(registerBtn);
    }

    public void clickLogin() {
        sleep(1000);
        click(loginBtn);
    }

    public void enterProductName(String name) {
        fillText(searchTxt, name);
    }

    public void clickSearch() {
        click(searchBtn);
    }


}
