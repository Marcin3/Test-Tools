package gui.registrationform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by marcin on 30/10/16.
 */
public class RegistrationForm {

    public void sendValueToAgeField(WebDriver driver, int age) {
        WebElement field = driver.findElement(By.id("age"));
        field.clear();
        field.sendKeys(String.valueOf(age));
    }

    public void sendValueToCommentField(WebDriver driver, String comment) {
        WebElement field = driver.findElement(By.id("comment"));
        field.clear();
        field.sendKeys(comment);
    }

    public void sendValueToEmailField(WebDriver driver, String email) {
        WebElement field = driver.findElement(By.id("email"));
        field.clear();
        field.sendKeys(email);
    }

    public void sendValueToNameField(WebDriver driver, String name) {
        WebElement field = driver.findElement(By.id("name"));
        field.clear();
        field.sendKeys(name);
    }

    public void sendValueToPhoneField(WebDriver driver, String phone) {
        WebElement field = driver.findElement(By.id("phone"));
        field.clear();
        field.sendKeys(phone);
    }

    public void sendValueToSurnameField(WebDriver driver, String surname) {
        WebElement field = driver.findElement(By.id("surname"));
        field.clear();
        field.sendKeys(surname);
    }

    public void pressSubmitButton(WebDriver driver) {
        driver.findElement(By.id("submit")).click();
    }
}
