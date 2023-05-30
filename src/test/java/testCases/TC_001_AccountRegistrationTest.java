package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001_AccountRegistrationTest extends BaseTest {


    @Test(priority = 2)
    void tc02_test_account_Registration() {
        logger.debug("application logs.....");
        logger.info("******** Starting TC_001_AccountRegistrationTest **********");



            logger.info("******** Clicked on My account link **********");
            logger.info("******** Clicked on register link **********");
            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            driver.navigate().refresh();
            regPage.waiting(500);
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

        logger.info("******** Finished TC_001_AccountRegistrationTest **********");

    }

    //empty first name
    @Test
    void tc01_testAccountRegFailed() {
        logger.debug("application logs.....");
        logger.info("******** Starting TC_001_AccountRegistrationTest **********");

        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        logger.info("******** Clicked on My account link **********");
        homePage.clickRegister();
        logger.info("******** Clicked on register link **********");
        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        logger.info("******** Providing customer data **********");
        regPage.setLastName(randomString().toUpperCase());
        regPage.setEmail(randomString() + "@gmail.com");
        regPage.setPassword(randomAlphaNumeric());
        regPage.setCheckPolicyBtn();
        regPage.clickContinue();
        logger.info("******** Clicked on continue **********");
        String actualConfirmMsg = regPage.getErrorMsgFirstName();
        logger.info("******** Validating expected message **********");
        String expectedMsg = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualConfirmMsg, expectedMsg, "Test failed");
        regPage.waiting(500);
        logger.info("******** Finished TC_001_AccountRegistrationTest **********");

    }


}
