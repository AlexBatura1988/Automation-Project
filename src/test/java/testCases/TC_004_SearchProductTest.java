package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTest;
import utilities.AllureAttachment;

public class TC_004_SearchProductTest extends BaseTest {
    @Test(priority = 1)
    public void testProductSearch() {
        logger.info(" Starting TC_004_SearchProductTest ");
        HomePage homePage = new HomePage(driver);
        homePage.enterProductName("mac");
        homePage.clickSearch();
        homePage.waiting(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.isProductExist("MacBook");
        homePage.waiting(1000);

        Assert.assertEquals(searchPage.isProductExist("MacBook"), true);

        logger.info(" Finished TC_004_SearchProductTest ");
        AllureAttachment.attachURL("http://localhost/opencart/upload");
    }

    @Test(priority = 2)
    public void selectProduct() {
        logger.info(" Starting TC_004_SelectProductTest ");

        HomePage homePage = new HomePage(driver);
        homePage.enterProductName("mac");
        homePage.clickSearch();
        homePage.waiting(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectProduct("MacBook Air");
        homePage.waiting(2000);
        String expected = "MacBook Air";
        WebElement el = driver.findElement(By.cssSelector(".col-sm>h1"));
        String actual = el.getText();
        Assert.assertEquals(actual, expected);
        logger.info(" Finished TC_004_SelectProductTest ");
    }

}
