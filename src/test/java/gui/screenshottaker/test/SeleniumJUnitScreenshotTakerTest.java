package gui.screenshottaker.test;

import gui.screenshottaker.pages.MyteslaModels;
import gui.screenshottaker.utils.ChromeBrowser;
import gui.screenshottaker.utils.SeleniumJUnitScreenshotTaker;
import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by root on 26.10.16.
 */
@RunWith(JUnitParamsRunner.class)
public class SeleniumJUnitScreenshotTakerTest extends MyteslaModels {
    public static WebDriver driver;
    private static final String baseUrl = "http://www.mytesla.com.pl/";

    @Rule
    public SeleniumJUnitScreenshotTaker seleniumJUnitScreenshotTaker = new SeleniumJUnitScreenshotTaker(driver);

    @BeforeClass
    public static void init() {
        ChromeBrowser browser = new ChromeBrowser();
        driver = browser.getDriverWithURL(baseUrl);

    }

    @AfterClass
    public static void tearDown() { driver.close();}

    @Test
    public void testPass() {
        models(driver, "MODEL S", "MODEL X", "MODEL 3");
    }

    @Test
    public void testFail() {
        models(driver, "MODEL S", "MODEL X", "SpaceX");
    }

}
