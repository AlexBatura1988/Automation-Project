package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = "#content>h1")
    WebElement nameOfPage;
    @FindBy(css = ".d-inline-block.w-100>div.float-end>a")
    WebElement checkoutBtn;
    @FindBy(css = "td.text-start.text-wrap>a")
    WebElement productName;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getNameOfPage() {
        return getText(nameOfPage);
    }

    public void moveToCheckoutBtn() {
        moveToElement(checkoutBtn);
    }

    public void clickCheckoutBtn() {
        click(checkoutBtn);
    }

    public String getProductName() {
        return getText(productName);
    }
}
