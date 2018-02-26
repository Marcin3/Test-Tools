package po;

import static org.junit.Assert.assertEquals;
import static utils.browser.ChromeBrowser.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class RegistrationFormPO {

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "comment")
    private WebElement commentField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "surname")
    private WebElement surnameField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "info")
    private WebElement infoMessage;

    public RegistrationFormPO() {
        PageFactory.initElements(driver, this);
    }

    public void sendValueToAgeField(int age) {
        Utils.sendValueToField(ageField, age);
    }

    public void sendValueToCommentField(String comment) {
        Utils.sendValueToField(commentField, comment);
    }

    public void sendValueToEmailField(String email) {
        Utils.sendValueToField(emailField, email);
    }

    public void sendValueToNameField(String name) {
        Utils.sendValueToField(nameField, name);
    }

    public void sendValueToPhoneField(String phone) {
        Utils.sendValueToField(phoneField, phone);
    }

    public void sendValueToSurnameField(String surname) {
        Utils.sendValueToField(surnameField, surname);
    }

    public void pressSubmitButton() {
        submitButton.click();
    }

    public void checkInfo() {
        assertEquals(infoMessage.getText(), "User added successfully");
    }
}
