package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseTest {

    @Test
    void test_account_Registration() {
        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickAccount();
            homePage.clickRegister();

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            regPage.setFirstName("alex");
            regPage.setLastName("batura");
            regPage.setEmail("test1234@gmail.com");
            regPage.setPassword("1234");
            regPage.setCheckPolicyBtn();
            regPage.clickContinue();
            regPage.sleep(2000);
            String actualConfirmMsg = regPage.getConfirmationMsg();
            String expectedMsg = "Your Account Has Been Created!";
            Assert.assertEquals(actualConfirmMsg, expectedMsg);
        } catch (Exception e) {
            Assert.fail();
        }


    }


}
