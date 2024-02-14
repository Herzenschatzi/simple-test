package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GeneralUtils;

public class StammdatenPage {
    private final WebDriver webDriver;
    GeneralUtils generalUtils;

    public StammdatenPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        generalUtils = new GeneralUtils(webDriver);
    }

    private final By benutzerkennung = By.id("origin-id-input-id");
    private final By nachname = By.id("family_name-input-id");
    private final By vorname = By.id("given_name-input-id");
    private final By personnel = By.id("personnel_number-input-id");
    private final By personnelHR = By.id("personnel_number_hr-input-id");
    private final By mobileNum = By.id("mobile-input-id");
    private final By eMail = By.id("email-address-input-id");


    public void fillStammdaten(String newBenutzerkennungValue, String newNachnameValue, String newVornameValue,
                               String newPersonnelNum,String newPersonnelNumHR, String newMobileNum, String newEMail) {
        setBenutzerkennung(newBenutzerkennungValue);
        setNachname(newNachnameValue);
        setVorname(newVornameValue);
        setPersonnelNum(newPersonnelNum);
        setPersonnelNumHR(newPersonnelNumHR);
        setMobilNum(newMobileNum);
        setEMail(newEMail);
    }

    public void setBenutzerkennung(String newBenutzerkennungValue) {
        changeField(webDriver.findElement(this.benutzerkennung), newBenutzerkennungValue);
    }

    public void setNachname(String newNachnameValue) {
        changeField(webDriver.findElement(this.nachname), newNachnameValue);
    }

    public void setVorname(String newVornameValue) {
        changeField(webDriver.findElement(this.vorname), newVornameValue);

    }

    public void setPersonnelNum(String newPersonnelNum) {
        changeField(webDriver.findElement(this.personnel), newPersonnelNum);

    }

    public void setPersonnelNumHR(String newPersonnelNumHR) {
        changeField(webDriver.findElement(this.personnelHR), newPersonnelNumHR);

    }

    public void setMobilNum(String newMobileNum) {
        changeField(webDriver.findElement(this.mobileNum), newMobileNum);

    }

    public void setEMail(String newEMail) {
        changeField(webDriver.findElement(this.eMail), newEMail);
    }


    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}
