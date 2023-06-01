package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    WebElement company;
    WebElement address1;
    WebElement address2;
    WebElement city;
    WebElement postCode;
    WebElement country;
    WebElement region;
    WebElement password;
    WebElement shipBtn;
    WebElement shipContinueBtn;
    WebElement paymentBtn;
    WebElement payContinueBtn;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
}
