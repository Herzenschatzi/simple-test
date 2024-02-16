package pageObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Utils {
    static public ByteArrayInputStream takeScreeenshot(WebDriver driver) throws IOException {
        TakesScreenshot scs = (TakesScreenshot)driver;
        return new ByteArrayInputStream(scs.getScreenshotAs(OutputType.BYTES));
    }
}
