package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class AllureAttachment {

    @Attachment(value = "Element Screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] attachElementScreenshot(WebElement element) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
    public static String attachURL(String url) {
        return url;
    }
}
