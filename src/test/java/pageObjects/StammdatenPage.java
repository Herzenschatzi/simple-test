package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GeneralUtils;

public class StammdatenPage {
    private final WebDriver webDriver;
    GeneralUtils generalUtils = null;

    public StammdatenPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        generalUtils = new GeneralUtils(webDriver);
    }

    private final By benutzerkennung = By.id("origin-id-input-id");
    private final By nachname = By.id("family_name-input-id");
    private final By vorname = By.id("given_name-input-id");

    public void fillStammdaten(String newBenutzerkennungValue, String newNachnameValue, String newVornameValue) {
        setBenutzerkennung(newBenutzerkennungValue);
        setNachname(newNachnameValue);
        setVorname(newVornameValue);
        generalUtils.fillInputByXpath("given_name-input-id", "Anna");
        generalUtils.fillInputByXpath("personnel_number-input-id", "123_001");
        generalUtils.fillInputByXpath("personnel_number_hr-input-id", "456_001");
        generalUtils.fillInputByXpath("mobile-input-id", "016000000");
        generalUtils.fillInputByXpath("email-address-input-id", "test@test.com");

    }

    public void setBenutzerkennung(String newBenutzerkennungValue) {
        changeField(webDriver.findElement(this.benutzerkennung), newBenutzerkennungValue);
    }

    public void setNachname(String newNachnameValue) {
        changeField(webDriver.findElement(this.nachname), newNachnameValue);
    }
    public void setVorname(String newVornameValue) {
        changeField(webDriver.findElement(this.nachname), newVornameValue);
    }




    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}
