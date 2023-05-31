package testBase;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class BaseTest {

    public static WebDriver driver;
    public Logger logger;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setup(ITestContext testContext, String br) {
        rb = ResourceBundle.getBundle("config");
        logger = LogManager.getLogger(this.getClass());

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
        //driver.get("http://localhost/opencart/upload/index.php");
        testContext.setAttribute("WebDriver", driver);
        driver.get(rb.getString("appURL"));
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

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }


    @AfterClass
   public void tearDown() {
          driver.quit();
    }
}
