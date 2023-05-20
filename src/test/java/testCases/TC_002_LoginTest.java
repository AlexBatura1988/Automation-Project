package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002_LoginTest extends BaseTest {

    @Test
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
}
