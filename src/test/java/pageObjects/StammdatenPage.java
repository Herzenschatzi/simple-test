package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StammdatenPage {
    private final WebDriver webDriver;
    public StammdatenPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By benutzerkennung = By.id("origin-id-input-id");
    private final By nachname = By.id("family_name-input-id");

    public void setBenutzerkennung(String newBenutzerkennungValue){
        changeField(webDriver.findElement(this.benutzerkennung), newBenutzerkennungValue);
    }

    public void setNachname(String newNachnameValue){
        changeField(webDriver.findElement(this.nachname), newNachnameValue);
    }
    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}
