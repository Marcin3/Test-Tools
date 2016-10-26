package gui.screenshottaker.pages;

import gui.screenshottaker.utils.ChromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


/**
 * Created by root on 26.10.16.
 */
public class MyteslaModels {
    public void models(WebDriver driver, String modelS, String modelX, String model3) {
        assertEquals(driver.findElement(By.id("menu-item-136")).getText(), modelS);
        assertEquals(driver.findElement(By.id("menu-item-137")).getText(), modelX); //Model X
        assertEquals(driver.findElement(By.id("menu-item-2112")).getText(), model3); //Model 3
    }
}
