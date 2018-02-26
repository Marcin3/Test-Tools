package gui.screenshotTaker;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import po.MyTeslaPO;
import utils.SeleniumJUnitScreenshotTaker;
import utils.browser.ChromeBrowser;

public class SeleniumJUnitScreenshotTakerTest {
    public static WebDriver driver;

    private static final String BASE_URL = "http://www.mytesla.com.pl/";

    @Rule
    public SeleniumJUnitScreenshotTaker seleniumJUnitScreenshotTaker = new SeleniumJUnitScreenshotTaker(driver);

    @BeforeClass
    public static void init() {
        ChromeBrowser browser = new ChromeBrowser();
        driver = browser.getDriverWithURL(BASE_URL);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void testShouldPass() {
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        myTeslaPO.checkModelsInTopMenu("MODEL S", "MODEL X", "MODEL 3");
    }

    @Test
    public void testShouldFail() {
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        myTeslaPO.checkModelsInTopMenu("MODEL S", "MODEL X", "SpaceX");
    }

}
