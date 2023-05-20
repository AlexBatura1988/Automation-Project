package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillText(WebElement el, String text) {
        el.clear();
        sleep(2000);
        el.sendKeys(text);
    }

    public void click(WebElement el) {
        el.click();
        sleep(2000);
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void clear(WebElement el) {
        el.clear();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
