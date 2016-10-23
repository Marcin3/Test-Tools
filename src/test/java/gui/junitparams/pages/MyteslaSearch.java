package gui.junitparams.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by E5410 on 2016-10-23.
 */
public class MyteslaSearch {

    public void searchMethod(WebDriver driver, String textToSearch) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.search-submit")));
        driver.findElement(By.cssSelector("input.search-field")).clear();
        driver.findElement(By.cssSelector("input.search-field")).sendKeys(textToSearch);
        driver.findElement(By.cssSelector("input.search-submit")).click();
    }

}
