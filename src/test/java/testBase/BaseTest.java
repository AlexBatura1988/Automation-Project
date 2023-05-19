package testBase;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) {
        logger = LogManager.getLogger(this.getClass());
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//        WebDriverManager.chromedriver().setup();

        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/upload/index.php");
    }

    public String randomString() {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return generateString;
    }

    public String randomAlphaNumeric() {
        String st = RandomStringUtils.randomAlphabetic(3);
        String num = RandomStringUtils.randomNumeric(3);
        return (st + num);
    }


//    @AfterClass
//   public void tearDown() {
//          driver.quit();
//    }
}
