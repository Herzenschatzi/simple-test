package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DispositionPage {
    private final WebDriver webDriver;

    private final By plz = By.id("postcode-input-id");
    private final By ort = By.id("city-input-id");
    private final By strasse = By.id("street-name-input-id");
    private final By hausNummmer = By.id("street-nr-first-input-id");
    private final By plannungsGruppe = By.id("action-planning-group-input-id");
    private final By poolButton = By.xpath("//div[@id='navigation_header-pool-id']//button");

    public DispositionPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillDisposition(String newPlzValue, String newOrtValue, String newStrasseValue,
                                String newHausNummerValue, String newplannungsGruppeValue) {
        setPlz(newPlzValue);
        setOrt(newOrtValue);
        setStrasse(newStrasseValue);
        setHausNummmer(newHausNummerValue);
        setplannungsGruppe(newplannungsGruppeValue);
    }

    public void setPlz(String newPlzValue) {
        changeField(webDriver.findElement(this.plz), newPlzValue);
    }

    public void setOrt(String newOrtValue) {
        changeField(webDriver.findElement(this.ort), newOrtValue);
    }

    public void setStrasse(String newStrasseValue) {
        changeField(webDriver.findElement(this.strasse), newStrasseValue);
    }

    public void setHausNummmer(String newHausNummerValue) {
        changeField(webDriver.findElement(this.hausNummmer), newHausNummerValue);
    }

    public void setplannungsGruppe(String newplannungsGruppeValue) {
        changeField(webDriver.findElement(this.plannungsGruppe), newplannungsGruppeValue);
    }

    public void goNextPage() {
        webDriver.findElement(this.poolButton).click();
    }

    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }

}
