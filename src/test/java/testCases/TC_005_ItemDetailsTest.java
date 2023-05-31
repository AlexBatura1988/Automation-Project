package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ItemDetailsPage;
import pageObjects.SearchPage;
import testBase.BaseTest;

public class TC_005_ItemDetailsTest extends BaseTest {

    @Test
    public void tc_001_productNameTest() {
        logger.info(" Starting TC_005_ItemDetailsTest");

        HomePage homePage = new HomePage(driver);
        homePage.enterProductName("mac");
        homePage.clickSearch();
        homePage.waiting(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectProduct("MacBook Air");
        searchPage.waiting(2000);
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        String expected = "MacBook Air";
        String actual = itemDetailsPage.getNameOfProduct();
        Assert.assertEquals(actual, expected);
        logger.info(" Finished TC_005_ItemDetailsTest");
    }

    @Test
    public void tc_002_addToCartTest() {
        logger.info(" Starting TC_005_ItemDetailsTest");

        HomePage homePage = new HomePage(driver);
        homePage.enterProductName("mac");
        homePage.clickSearch();
        homePage.waiting(1000);

        SearchPage searchPage = new SearchPage(driver);
        searchPage.selectProduct("MacBook Air");
        searchPage.waiting(1000);
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        itemDetailsPage.setTxtQuantity("2");
        itemDetailsPage.clickAddToCard();
        itemDetailsPage.waiting(3000);
        String actual = itemDetailsPage.getElText();
        String exp = "2 item(s) - $2,404.00";
        Assert.assertEquals(actual, exp);


        logger.info(" Finished TC_005_ItemDetailsTest");
    }
}
