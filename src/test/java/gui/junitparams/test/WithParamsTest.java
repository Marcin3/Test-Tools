package gui.junitparams.test;

import gui.junitparams.pages.MyteslaSearch;
import junitparams.JUnitParamsRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by E5410 on 2016-10-23.
 */
@RunWith(JUnitParamsRunner.class)
public class WithParamsTest extends MyteslaSearch {
    public static WebDriver driver;
    private static final String baseUrl = "http://www.mytesla.com.pl/";

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "..//Test-Tools/src/browser/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    @junitparams.Parameters({
            "Tesla",
            "Supercharger",
            "Krakow" })
    public void search(String mTextToSearch) {
        // given
        String textToSearch = mTextToSearch;

        // when
        searchMethod(driver, textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " + textToSearch, driver.findElement(By.cssSelector("h1.page-title")).getText());
    }

}
