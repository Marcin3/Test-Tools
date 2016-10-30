package gui.registrationform.test;

import gui.registrationform.pages.RegistrationForm;
import gui.registrationform.utils.ChromeBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by marcin on 30/10/16.
 */
public class RegistrationFormTest extends RegistrationForm {
    public static WebDriver driver;
    private static final String baseUrl = "http://www.websiteuat.example.org/";

    @BeforeClass
    public static void init() {
        ChromeBrowser browser = new ChromeBrowser();
        driver = browser.getDriverWithURL(baseUrl);
    }

    @AfterClass
    public static void tearDown() { driver.close();}


}
