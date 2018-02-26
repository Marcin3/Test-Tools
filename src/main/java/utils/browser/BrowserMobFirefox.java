package utils.browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

/**
 * Created by E5410 on 2016-10-23.
 */
public class BrowserMobFirefox {
    public static BrowserMobProxyServer proxy;

    protected WebDriver driver;

    private static final int BROWSER_MOB_PROXY_PORT = 9191;

    private static final String PATH_TO_BROWSER = "src/main/resources/browser/geckodriver.exe";

    public WebDriver getDefaultDriver() {
        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(startTheProxy());

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        System.setProperty("webdriver.gecko.driver", PATH_TO_BROWSER);
        driver = new FirefoxDriver(capabilities);
        return driver;
    }

    public BrowserMobProxyServer startTheProxy() {
        proxy = new BrowserMobProxyServer();
        proxy.start(BROWSER_MOB_PROXY_PORT);
        proxy.setHarCaptureTypes(CaptureType.getHeaderCaptureTypes());
        return proxy;
    }



}
