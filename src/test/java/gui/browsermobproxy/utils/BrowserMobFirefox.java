package gui.browsermobproxy.utils;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by E5410 on 2016-10-23.
 */
public class BrowserMobFirefox {
    protected BrowserMobProxyServer proxy;
    protected WebDriver driver;

    private static final int BROWSER_MOB_PROXY_PORT = 9191;

    public void getDefaultDriver() {
        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(BROWSER_MOB_PROXY_PORT);
        proxy.setHarCaptureTypes(CaptureType.getHeaderCaptureTypes());

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        driver = new FirefoxDriver(capabilities);
    }
    public void stopBMP() {
        proxy.stop();
        driver.close();
    }
}
