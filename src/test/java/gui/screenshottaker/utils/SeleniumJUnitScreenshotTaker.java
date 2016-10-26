package gui.screenshottaker.utils;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by root on 26.10.16.
 */
public class SeleniumJUnitScreenshotTaker implements MethodRule {
    private WebDriver driverLocal;
    public SeleniumJUnitScreenshotTaker(WebDriver driver)  {
        driverLocal = driver;
    }

    public void takeScreenshot(String fileName) {
        try {
            new File("test-results/scrshots/").mkdirs(); // Make sure directory is there
            FileOutputStream out = new FileOutputStream("test-results/scrshots/" + fileName + ".png");
            out.write(((TakesScreenshot) driverLocal).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            // No need to crash the tests here
        }
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    takeScreenshot(frameworkMethod.getName());
                    throw t; // rethrow
                }
            }
        };
    }
}
