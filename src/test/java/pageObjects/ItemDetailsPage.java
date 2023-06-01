package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailsPage extends BasePage{
    @FindBy(css = ".col-sm>h1")
    WebElement nameProduct;
    @FindBy(css = "#input-quantity")
     WebElement txtQuantity;
    @FindBy(css = ".btn.btn-primary.btn-lg.btn-block")
    WebElement addToCardBtn;
    @FindBy(css = ".nav.float-end>ul>li:nth-child(4)")
    WebElement shoppingCartBtn;


    @FindBy(xpath = "//*[@id=\"header-cart\"]/div/button")
    WebElement el;

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }
    public String getElText() {
        return getText(el);
    }

    public void setTxtQuantity(String quantity) {
        fillText(txtQuantity, quantity);
    }


    public String getNameOfProduct() {
        return nameProduct.getText();
    }

    public void clickAddToCard() {
        click(addToCardBtn);
    }
    public void clickShoppingCart() {
        click(shoppingCartBtn);
    }


}
