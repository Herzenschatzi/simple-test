package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterUtils {
    private final WebDriver webDriver;

    public FilterUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openFilter(String xpath) {
        WebElement openFilter = webDriver.findElement(By.xpath(xpath));
        openFilter.click();
    }

    public void filterTechniker(String xpath, String value) {
        WebElement applyFilter = webDriver.findElement(By.xpath(xpath));
        //openFilter.click();
        applyFilter.sendKeys(value);
    }
}
