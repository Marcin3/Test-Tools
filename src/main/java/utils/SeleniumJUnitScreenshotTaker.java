package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class SeleniumJUnitScreenshotTaker implements MethodRule {

    private static final Logger log = Logger.getLogger(String.valueOf(SeleniumJUnitScreenshotTaker.class));

    private static final String PATHNAME = "test-results/scrshots/";

    private WebDriver driver;

    public SeleniumJUnitScreenshotTaker(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) {
        try {
            new File(PATHNAME).mkdirs();
            FileOutputStream out = new FileOutputStream(PATHNAME + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            log.info("Problem during making screenshot: " + e);
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
