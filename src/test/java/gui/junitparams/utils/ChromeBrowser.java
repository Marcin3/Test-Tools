package gui.junitparams.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by E5410 on 2016-10-23.
 */

public class ChromeBrowser {
        protected static WebDriver driver;

    protected static WebDriver getURL (String url) {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

}
