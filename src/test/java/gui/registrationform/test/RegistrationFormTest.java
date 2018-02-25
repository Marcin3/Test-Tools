package gui.registrationform.test;

import gui.registrationform.pages.RegistrationForm;
import utils.browser.ChromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by marcin on 30/10/16.
 */
public class RegistrationFormTest extends RegistrationForm {
    public static WebDriver driver;
    private static final String baseUrl = "http://www.websiteuat.example.org/";

    @DataProvider(name = "differentAge" )
    public Object[][] nameIrrelevant() {
        return new Object[][]{
                {"John", "Smith", "john.smith1@example.org", 1, "+48123456", "new info"},
                {"John", "Smith", "john.smith99@example.org", 99, "+48123456", "new info"},
                {"John", "Smith", "john.smith0@example.org", 0, "+48123456", "new info"},
                {"John", "Smith", "john.smith100@example.org", 100, "+48123456", "new info"},
        };
    }

    @BeforeClass
    public static void init() {
        ChromeBrowser browser = new ChromeBrowser();
        driver = browser.getDriverWithURL(baseUrl);
    }

    @AfterClass
    public static void tearDown() { driver.close();}

    @Test(dataProvider = "differentAge" )
    public void AgeBoundaryValueTest(String name, String surname, String email, int age, String phone, String comment) {
        sendValueToNameField(driver, name);
        sendValueToSurnameField(driver, surname);
        sendValueToEmailField(driver, email);
        sendValueToAgeField(driver, age);
        sendValueToPhoneField(driver, phone);
        sendValueToCommentField(driver, comment);
        pressSubmitButton(driver);
        assertEquals(driver.findElement(By.id("info")).getText(), "User added successfully");
    }


}
