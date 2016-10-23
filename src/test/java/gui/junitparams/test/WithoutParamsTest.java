package gui.junitparams.test;

import gui.junitparams.pages.MyteslaSearch;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by E5410 on 2016-10-23.
 */
public class WithoutParamsTest extends MyteslaSearch{
    public static WebDriver driver;
    private static final String baseUrl="http://www.mytesla.com.pl/";

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "..//Test-Tools/src/browser/chromedriver");
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void searchTesla(){
        // given
        String textToSearch = "Tesla";

        // when
        searchMethod(driver,textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " +textToSearch, driver.findElement(By.cssSelector("h1.page-title")).getText());
    }

    @Test
    public void searchSupercharger(){
        // given
        String textToSearch = "Supercharger";

        // when
        searchMethod(driver,textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " +textToSearch, driver.findElement(By.cssSelector("h1.page-title")).getText());
    }

    @Test
    public void searchKrakow(){
        // given
        String textToSearch = "Krakow";

        // when
        searchMethod(driver,textToSearch);

        // then
        assertEquals("Wyniki wyszukiwania: " +textToSearch, driver.findElement(By.cssSelector("h1.page-title")).getText());
    }

}
