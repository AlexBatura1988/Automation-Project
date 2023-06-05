package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(css = "#input-shipping-new")
    WebElement newAddressBtn;
    @FindBy(css = "#input-shipping-firstname")
    WebElement firstName;
    @FindBy(css = "#input-shipping-lastname")
    WebElement lastName;
    @FindBy(css = "#input-shipping-company")
    WebElement company;
    @FindBy(css = "#input-shipping-address-1")
    WebElement address1;
    @FindBy(css = "#input-shipping-address-2")
    WebElement address2;
    @FindBy(css = "#input-shipping-city")
    WebElement city;
    @FindBy(css = "#input-shipping-postcode")
    WebElement postCode;
    @FindBy(css = "#input-shipping-country")
    WebElement countryBtn;
    @FindBy(css = "#input-shipping-zone")
    WebElement region;
    @FindBy(css = "#button-shipping-address")
    WebElement continueBtn;
    @FindBy(css = "#button-shipping-methods.btn")
    WebElement shipBtn;
    @FindBy(css = "#input-shipping-method-flat-flat")
    WebElement shipOptionBtn;
    @FindBy(css = "#form-shipping-method>div.text-end>button")
    WebElement shipContinueBtn;
    @FindBy(css = "#button-payment-methods")
    WebElement chosePaymentBtn;
    @FindBy(css = "#input-payment-method-cod-cod")
    WebElement paymentOptBtn;
    @FindBy(css = "#button-payment-method.btn")
    WebElement paymentContinueBtn;
    @FindBy(css = "#button-confirm.btn")
    WebElement confirmOrderBtn;




    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewAddress() {
        click(newAddressBtn);
    }
    public void setFirstName(String fname) {
        fillText(firstName, fname);
    }

    public void setLastName(String lname) {
        fillText(lastName, lname);
    }

    public void setCompany(String comp) {
        fillText(company, comp);
    }

    public void setAddress1(String adr1) {
        fillText(address1, adr1);
    }

    public void setAddress2(String adr2) {
        fillText(address2, adr2);
    }

    public void setCity(String cty) {
        fillText(city, cty);
    }

    public void setPostCode(String code) {
        fillText(postCode, code);
    }


    public void setCountry(String country) {
        new Select(countryBtn).selectByVisibleText(country);
    }

    public void clickContinueAddress() {
        click(continueBtn);
    }

    public void clickShipBtn() {
        click(shipBtn);
    }

    public void clickOpShipBtn() {
        click(shipOptionBtn);
    }

    public void clickShipConBtn() {
        click(shipContinueBtn);
    }

    public void choosePaymentBtn() {
        click(chosePaymentBtn);
    }

    public void clickPaymentOptBtn() {
        click(paymentOptBtn);
    }

    public void clickContinueBtn() {
        click(paymentContinueBtn);
    }

    public void clickConfirmOrder() {
        click(confirmOrderBtn);
    }

    public void moveToConAddress() {
        moveToElement(continueBtn);
    }

    public void moveToConOrder() {
        moveToElement(confirmOrderBtn);
    }

    public void moveToShipBtn() {
        driver.switchTo().activeElement().sendKeys(Keys.HOME);
    }





}
