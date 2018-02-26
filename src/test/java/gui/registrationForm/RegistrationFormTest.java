package gui.registrationForm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import po.RegistrationFormPO;
import utils.browser.ChromeBrowser;


public class RegistrationFormTest {
    public static WebDriver driver;

    private static final String BASE_URL = "http://www.websiteuat.example.org/";

    @DataProvider(name = "differentAge")
    public Object[][] nameIrrelevant() {
        return new Object[][] {
                { "John", "Smith", "john.smith1@example.org", 1, "+48123456", "new info" },
                { "John", "Smith", "john.smith99@example.org", 99, "+48123456", "new info" },
                { "John", "Smith", "john.smith0@example.org", 0, "+48123456", "new info" },
                { "John", "Smith", "john.smith100@example.org", 100, "+48123456", "new info" },
        };
    }

    @BeforeClass
    public static void init() {
        ChromeBrowser browser = new ChromeBrowser();
        driver = browser.getDriverWithURL(BASE_URL);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    // Please set proper BASE_URL and web elements  in RegistrationFormPO
    // Next remove "enabled = false"
    @Test(dataProvider = "differentAge", enabled = false)
    public void ageBoundaryValueTest(String name, String surname, String email, int age, String phone, String comment) {
        RegistrationFormPO registrationFormPO = new RegistrationFormPO();
        registrationFormPO.sendValueToNameField(name);
        registrationFormPO.sendValueToSurnameField(surname);
        registrationFormPO.sendValueToEmailField(email);
        registrationFormPO.sendValueToAgeField(age);
        registrationFormPO.sendValueToPhoneField(phone);
        registrationFormPO.sendValueToCommentField(comment);
        registrationFormPO.pressSubmitButton();
        registrationFormPO.checkInfo();
    }


}
