package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public Logger logger;

    @BeforeClass
    public void setup() {
        logger = LogManager.getLogger(this.getClass());
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
