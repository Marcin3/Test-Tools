package po;

import static org.junit.Assert.assertEquals;
import static utils.browser.ChromeBrowser.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyTeslaPO {

    @FindBy(id = "menu-item-136")
    protected WebElement model_S;

    @FindBy(id = "menu-item-137")
    protected WebElement model_X;

    @FindBy(id = "menu-item-2112")
    protected WebElement model_3;

    public MyTeslaPO() {
        PageFactory.initElements(driver, this);
    }


    public void checkModelsInTopMenu(String firstModel, String secondModel, String thirdModel) {
        assertEquals(model_S.getText(), firstModel);
        assertEquals(model_X.getText(), secondModel);
        assertEquals(model_3.getText(), thirdModel);
    }
}
