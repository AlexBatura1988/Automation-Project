package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.AllureAttachment;

public class TC_002_LoginTest extends BaseTest {

    @Test(priority = 2)
    public void test_login() {
        try {
            logger.info("****Starting TC_002_LoginTest****");
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setTxtEmail(rb.getString("email"));
            lp.setTxtPassword(rb.getString("password"));
            lp.clickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExist();
            Assert.assertEquals(targetPage, true);
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("****Finished TC_002_LoginTest****");

    }

    @Test(priority = 1)
    public void test_login_failed() {
        try {
            logger.info("****Starting TC_002_LoginTest****");
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setTxtEmail(rb.getString("email_1"));
            lp.setTxtPassword(rb.getString("password_1"));
            lp.clickLogin();
            String expectedMsg = "Warning: No match for E-Mail Address and/or Password";
            String actualMsg = lp.getErrorMsg();
            Assert.assertEquals(actualMsg, expectedMsg);

            logger.info("****Finished TC_002_LoginTest****");
            AllureAttachment.addTextAttachment("Alex Batura Rules");
        }catch (Exception e){
            Assert.fail();
        }
        logger.info("****Finished TC_002_LoginTest****");
    }
}
