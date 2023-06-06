package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002_LoginTest extends BaseTest {

    @Test
    public void tc_002_testLogin() {
        logger.info("****Starting TC_002_LoginTest****");
        LoginPage lp = new LoginPage(driver);
        lp.setTxtEmail(rb.getString("email"));
        lp.setTxtPassword(rb.getString("password"));
        lp.clickLogin();
        lp.waiting(3000);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        boolean targetPage = myAccountPage.isMyAccountPageExist();
        Assert.assertEquals(targetPage, true);
        logger.info("****Finished TC_002_LoginTest****");
    }

    @Test
    public void tc_001_testLoginFailed() {
        logger.info("****Starting TC_002_LoginTest****");
        HomePage hp = new HomePage(driver);
        hp.clickAccount();
        hp.clickLogin();
        LoginPage lp = new LoginPage(driver);
        lp.setTxtEmail(rb.getString("email_1"));
        lp.setTxtPassword(rb.getString("password_1"));
        lp.clickLogin();
        String expectedMsg = "Warning: No match for E-Mail Address and/or Password.";
        String actualMsg = lp.getErrorMsg();
        Assert.assertEquals(actualMsg, expectedMsg);
        logger.info("****Finished TC_002_LoginTest****");
    }
}
