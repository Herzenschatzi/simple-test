package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By oneButton = By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]" +
            "//span[contains(text(),'Workforce Resource local')]");
    private final By resButton = By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]//*[contains(text(),'Ressourcen')]");

    public void oneButton() {
        webDriver.findElement(this.oneButton).click();
    }
    public void resButton() {
        webDriver.findElement(this.resButton).click();
    }


}
