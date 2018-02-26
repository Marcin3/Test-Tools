package gui.browsermobproxy;

import static utils.browser.BrowserMobFirefox.proxy;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.lightbody.bmp.core.har.Har;
import po.MyTeslaPO;
import utils.browser.BrowserMobFirefox;

/**
 * Created by E5410 on 2016-10-23.
 */
public class BrowserMobFirefoxTest {
    private static final Logger log = Logger.getLogger(String.valueOf(BrowserMobFirefoxTest.class));

    private static final String BASE_URL = "http://www.mytesla.com.pl/";

    private static final String NAME_OF_HAR_FILE = "mytesla.har";

    public static WebDriver driver;

    @BeforeClass
    public void init() {
        BrowserMobFirefox browserMobFirefox = new BrowserMobFirefox();
        driver = browserMobFirefox.getDefaultDriver();
    }

    @Test
    public void myTeslaTest() throws IOException {
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        proxy.newHar("mytesla.com.pl");

        // open yahoo.com
        driver.get(BASE_URL);
        myTeslaPO.clickModel_3();

        // get the HAR data
        Har har = proxy.getHar();
        log.info(NAME_OF_HAR_FILE + "has size: " + har.getLog().getEntries().size());

        har.writeTo(new File(NAME_OF_HAR_FILE));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        proxy.stop();
    }

}