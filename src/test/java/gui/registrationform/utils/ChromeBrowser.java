package gui.registrationform.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by marcin on 30/10/16.
 */
public class ChromeBrowser {
    public WebDriver driver;

    public WebDriver getDriverWithURL(String url) {
        System.setProperty("webdriver.chrome.driver", "..//Test-Tools/src/browser/chromedriver");
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
