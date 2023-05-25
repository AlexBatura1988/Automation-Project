package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void test_loginDDT(String email, String password, String exp) {
        logger.info("****Starting TC_003_LoginDDT*****");
        try {

            HomePage homePage = new HomePage(driver);
            homePage.clickAccount();
            homePage.clickLogin();

            LoginPage lp = new LoginPage(driver);

            lp.setTxtEmail(email);
            lp.setTxtPassword(password);
            lp.clickLogin();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExist();

            if (exp.equals("Valid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp.equals("Invalid")) {
                if (targetPage == true) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("****Finished TC_003_LoginDDT*****");
    }
}
