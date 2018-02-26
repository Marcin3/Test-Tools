package utils;

import org.openqa.selenium.WebElement;

public class Utils {

    public static void sendValueToField(WebElement webElement, Object value) {
        webElement.clear();
        webElement.sendKeys(String.valueOf(value));
    }
}
