package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GeneralUtils;

public class MitarbeiterPool {
    private final WebDriver webDriver;

    public MitarbeiterPool(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By area = By.id("Aktueller-district-autocomplete-id");
    private final By pool = By.id("Aktueller-pool-autocomplete-id");
    private final By hauptArea = By.id("Haupt-district-autocomplete-id");
    private final By hauptPool = By.id("Haupt-pool-autocomplete-id");

    //     generalUtils.fillDropDown("//input[@id='Aktueller-district-autocomplete-id']", "Berlin", "//ul[@id='Aktueller-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]");
//        generalUtils.fillDropDown("//input[@id='Aktueller-pool-autocomplete-id']", "FS5556_05", "//ul[@id='Aktueller-pool-autocomplete-id-listbox']//li[contains(text(), 'FS5556_05')]");
//        generalUtils.fillDropDown("//input[@id='Haupt-district-autocomplete-id']", "Berlin", "//ul[@id='Haupt-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]");
//        generalUtils.fillDropDownShort("Haupt-pool-autocomplete-id", "FS5556_05");
//
    public void fillMitarbeiterPool(String newAreaValue, String newActualPoolValue, String newHaupAreaValue, String newHauptPoolValue) {
        setArea(newAreaValue);
        setPool(newActualPoolValue);
        setHauptArea(newHaupAreaValue);
        setHauptPool(newHauptPoolValue);
    }

    public void setArea(String newAreaValue) {
        changeField(webDriver.findElement(this.area), newAreaValue);
    }

    public void setPool(String newActualPoolValue) {
        changeField(webDriver.findElement(this.pool), newActualPoolValue);
    }

    public void setHauptArea(String newHaupAreaValue) {
        changeField(webDriver.findElement(this.hauptArea), newHaupAreaValue);
    }

    public void setHauptPool(String newHauptPoolValue) {
        changeField(webDriver.findElement(this.hauptPool), newHauptPoolValue);


    }

    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}
