package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.AllureAttachment;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(css = "#product-list>div")
    List<WebElement> searchProducts;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductExist(String name) {
        boolean flag = false;
        for (WebElement product : searchProducts) {
            String productNameText = product.findElement(By.cssSelector(".description>h4>a")).getText();
            if (productNameText.equals(name)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void selectProduct(String name) {
        for (WebElement product : searchProducts) {
            String productNameText = product.findElement(By.cssSelector(".description>h4>a")).getText();
            if (productNameText.equals(name)) {
                AllureAttachment.attachElementScreenshot(product);
                click(product);
                break;
            }
        }

    }

}
