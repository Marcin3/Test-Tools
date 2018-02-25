package gui.junitparams;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import junitparams.JUnitParamsRunner;
import po.MyTeslaPO;
import utils.browser.ChromeBrowser;

@RunWith(JUnitParamsRunner.class)
public class WithParamsTest {
    public static WebDriver driver;

    private static final String BASE_URL = "http://www.mytesla.com.pl/";

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
    @junitparams.Parameters({
            "Tesla",
            "Supercharger",
            "Krakow" })
    public void search(String textToSearch) {
        // given
        MyTeslaPO myTeslaPO = new MyTeslaPO();

        // when
        myTeslaPO.searchPhrase(textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " + textToSearch, myTeslaPO.getPageTitle());
    }

}
