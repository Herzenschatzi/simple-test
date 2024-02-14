package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {

    private WebDriver webDriver;

    public PageUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillInputByXpath(String xpath, String valueToSend) {
        WebElement element = webDriver.findElement(
                By.xpath(xpath));
        element.sendKeys(valueToSend);
    }

    public void fillDropDown(String xpath, String dropDownValue, String valueCheck) {
        WebElement actPoolList = webDriver.findElement(
                By.xpath(xpath));
        actPoolList.sendKeys(dropDownValue);
        webDriver.findElement(By.xpath(valueCheck)).click();
    }

    public void fillDropDownShort(String id, String value) {
        WebElement actMPool = webDriver.findElement(
                By.xpath("//input[@id='" + id + "']"));
        actMPool.sendKeys(value);
        webDriver.findElement(By.xpath("//ul[@id='" + id + "-listbox']//li[contains(text(), '" + value + "')]")).click();
    }

}
