package utils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeBrowser {

    private static final String PATH_TO_BROWSER = "src/main/resources/browser/chromedriver.exe";

    public static WebDriver driver;

    public WebDriver getDriverWithURL(String url) {
        System.setProperty("webdriver.chrome.driver", PATH_TO_BROWSER);
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

}