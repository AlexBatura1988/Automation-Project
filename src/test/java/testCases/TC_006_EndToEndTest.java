package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testBase.BaseTest;

public class TC_006_EndToEndTest extends BaseTest {
    @Test
    public void endToEndTest() {

        SoftAssert myAssert = new SoftAssert();
        //Account Registration
        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        homePage.clickRegister();

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.setFirstName(randomString().toUpperCase());
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        regPage.setPassword(randomAlphaNumeric());
        regPage.setCheckPolicyBtn();
        regPage.clickContinue();
        String actualConfirmMsg = regPage.getConfirmationMsg();
        String expectedMsg = "Your Account Has Been Created!";
        myAssert.assertEquals(actualConfirmMsg, expectedMsg);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.waiting(1000);
        myAccountPage.clickMyAccountBtn();
        myAccountPage.clickLOBtn();
        String expected = "Account Logout";
        String actual = myAccountPage.getMsgLogout();
        myAssert.assertEquals(actual, expected);

        //login
        homePage.clickAccount();
        homePage.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setTxtEmail(rb.getString("email"));
        lp.setTxtPassword(rb.getString("password"));
        lp.clickLogin();
        lp.waiting(2000);
        myAssert.assertEquals(myAccountPage.isMyAccountPageExist(), true);

        //Search / add product
        homePage.enterProductName("iPhone");
        homePage.clickSearch();

        SearchPage sp = new SearchPage(driver);
        ItemDetailsPage itemDetailsPage = new ItemDetailsPage(driver);
        if (sp.isProductExist("iPhone")) {
            sp.selectProduct("iPhone");
            itemDetailsPage.setTxtQuantity("2");
            itemDetailsPage.clickAddToCard();
        }
        itemDetailsPage.waiting(4000);
        String actualCost = itemDetailsPage.getElText();
        String expectedCost = "2 item(s) - $246.40";
        myAssert.assertEquals(actualCost, expectedCost);
        itemDetailsPage.clickShoppingCart();

        //Shopping cart
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String expNameOfPage = "Shopping Cart (20.00kg)";
        String actNameOfPage = shoppingCartPage.getNameOfPage();
        myAssert.assertEquals(actNameOfPage, expNameOfPage);
        String expProductName = "iPhone";
        String actProductName = shoppingCartPage.getProductName();
        myAssert.assertEquals(actProductName, expProductName);
        shoppingCartPage.waiting(1000);
        shoppingCartPage.moveToCheckoutBtn();
        shoppingCartPage.clickCheckoutBtn();




        myAssert.assertAll();


    }

}
