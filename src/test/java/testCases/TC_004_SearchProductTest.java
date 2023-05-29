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
        try {
            HomePage homePage = new HomePage(driver);
            homePage.enterProductName("mac");
            homePage.clickSearch();
            homePage.sleep(1000);

            SearchPage searchPage = new SearchPage(driver);
            searchPage.isProductExist("MacBook");
            homePage.sleep(1000);

            Assert.assertEquals(searchPage.isProductExist("MacBook"), true);


        } catch (Exception e) {
            Assert.fail();
        }
        logger.info(" Finished TC_004_SearchProductTest ");
        AllureAttachment.attachURL("http://localhost/opencart/upload");
    }

    @Test(priority = 2)
    public void selectProduct() {
        logger.info(" Starting TC_004_SelectProductTest ");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.enterProductName("mac");
            homePage.clickSearch();
            homePage.sleep(1000);

            SearchPage searchPage = new SearchPage(driver);
            searchPage.selectProduct("MacBook Air");
            homePage.sleep(2000);
            String expected = "MacBook Air";
            WebElement el = driver.findElement(By.cssSelector(".col-sm>h1"));
            String actual =el.getText();
            Assert.assertEquals(actual, expected);

        } catch (Exception e) {
            Assert.fail();
        }
        logger.info(" Finished TC_004_SelectProductTest ");
    }

}
