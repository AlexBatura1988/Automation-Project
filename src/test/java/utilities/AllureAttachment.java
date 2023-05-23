package utilities;

import io.qameta.allure.Attachment;

public class AllureAttachment {
    @Attachment(value = "{0}", type = "text/plan")
    public static String addTextAttachment(String msg) {
        return msg;
    }
}
