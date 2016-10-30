package gui.registrationform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by marcin on 30/10/16.
 */
public class RegistrationForm {

    public void sendValueToNameField(WebDriver driver, String name) {
        WebElement field = driver.findElement(By.id("name"));
        field.clear();
        field.sendKeys(name);
    }

    public void pressSubmitButton(WebDriver driver) {
        driver.findElement(By.id("submit")).click();
    }
}
