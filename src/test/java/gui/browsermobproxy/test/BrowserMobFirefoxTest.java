package gui.browsermobproxy.test;

import gui.browsermobproxy.utils.BrowserMobFirefox;
import net.lightbody.bmp.core.har.Har;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by E5410 on 2016-10-23.
 */
public class BrowserMobFirefoxTest extends BrowserMobFirefox{
    @BeforeClass
    public void init() {
        getDefaultDriver();
    }

    @Test
    public void myTeslaTest() throws IOException {
        proxy.newHar("mytesla.com.pl");

        // open yahoo.com
        driver.get("http://www.mytesla.com.pl/");

        // get the HAR data
        Har har = proxy.getHar();
        System.out.println("mytesla.har============" + har.getLog().getEntries().size());

        har.writeTo(new File("mytesla.har"));
    }
    @AfterClass
    public void tearDown() {
        stopBMP();
    }

}