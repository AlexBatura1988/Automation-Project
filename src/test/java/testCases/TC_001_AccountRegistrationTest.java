package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001_AccountRegistrationTest extends BaseTest {

    @Test
    void test_account_Registration() {
        logger.debug("application logs.....");
        logger.info("******** Starting TC_001_AccountRegistrationTest **********");

        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickAccount();
            logger.info("******** Clicked on My account link **********");
            homePage.clickRegister();
            logger.info("******** Clicked on register link **********");
            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("******** Providing customer data **********");
            regPage.setFirstName(randomString().toUpperCase());
            regPage.setLastName(randomString().toUpperCase());
            regPage.setEmail(randomString() + "@gmail.com");
            regPage.setPassword(randomAlphaNumeric());
            regPage.setCheckPolicyBtn();
            regPage.clickContinue();
            logger.info("******** Clicked on continue **********");
            String actualConfirmMsg = regPage.getConfirmationMsg();
            logger.info("******** Validating expected message **********");
            String expectedMsg = "Your Account Has Been Created!";
            Assert.assertEquals(actualConfirmMsg, expectedMsg, "Test failed");
        } catch (Exception e) {
            logger.error("test failed");
            Assert.fail();
        }
        logger.info("******** Finished TC_001_AccountRegistrationTest **********");

    }


}
