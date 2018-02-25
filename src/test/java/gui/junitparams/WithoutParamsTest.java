package gui.junitparams;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import po.MyTeslaPO;
import utils.browser.ChromeBrowser;

public class WithoutParamsTest {
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
    public void searchTesla() {
        // given
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        String textToSearch = "Tesla";

        // when
        myTeslaPO.searchPhrase(textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " + textToSearch, myTeslaPO.getPageTitle());
    }

    @Test
    public void searchSupercharger() {
        // given
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        String textToSearch = "Supercharger";

        // when
        myTeslaPO.searchPhrase(textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " + textToSearch, myTeslaPO.getPageTitle());
    }

    @Test
    public void searchKrakow() {
        // given
        MyTeslaPO myTeslaPO = new MyTeslaPO();
        String textToSearch = "Krakow";

        // when
        myTeslaPO.searchPhrase(textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " + textToSearch, myTeslaPO.getPageTitle());
    }

}
