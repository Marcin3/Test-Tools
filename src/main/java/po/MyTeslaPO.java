package po;

import static org.junit.Assert.assertEquals;
import static utils.browser.ChromeBrowser.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyTeslaPO {

    @FindBy(css = "h1.page-title")
    private WebElement pageTitle;

    @FindBy(id = "menu-item-136")
    private WebElement model_S;

    @FindBy(id = "menu-item-137")
    private WebElement model_X;

    @FindBy(id = "menu-item-2112")
    private WebElement model_3;

    @FindBy(css = "input.search-field")
    private WebElement searchField;

    @FindBy(css = "input.search-submit")
    private WebElement searchButton;

    public MyTeslaPO() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void checkModelsInTopMenu(String firstModel, String secondModel, String thirdModel) {
        assertEquals(model_S.getText(), firstModel);
        assertEquals(model_X.getText(), secondModel);
        assertEquals(model_3.getText(), thirdModel);
    }

    public void searchPhrase(String textToSearch) {
        writePhraseToSearch(textToSearch);
        clickSearchButton();
    }

    private void writePhraseToSearch(String textToSearch) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.clear();
        searchField.sendKeys(textToSearch);
    }

    private void clickSearchButton() {
        searchButton.click();
    }
}
