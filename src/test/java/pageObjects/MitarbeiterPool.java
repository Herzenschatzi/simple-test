package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MitarbeiterPool {
    private final WebDriver webDriver;
    private final String areaFieldId = "Aktueller-district-autocomplete-id";
    private final String poolFieldId = "Aktueller-pool-autocomplete-id";
    private final String hauptAreaFieldId = "Haupt-district-autocomplete-id";
    private final String hauptPoolFieldId = "Haupt-pool-autocomplete-id";
    private final By submitButton = By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//button[@id='employee-request-button-id']");

    public MitarbeiterPool(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Fill Mitarbeiter pool")
    public void fillMitarbeiterPool(String newAreaValue, String newActualPoolValue, String newHaupAreaValue, String newHauptPoolValue) {
        setArea(newAreaValue);
        setPool(newActualPoolValue);
        setHauptArea(newHaupAreaValue);
        setHauptPool(newHauptPoolValue);
    }

    public void setArea(String newAreaValue) {
        changeField(this.areaFieldId, newAreaValue);
    }

    public void setPool(String newActualPoolValue) {
        changeField(this.poolFieldId, newActualPoolValue);
    }

    public void setHauptArea(String newHaupAreaValue) {
        changeField(this.hauptAreaFieldId, newHaupAreaValue);
    }

    public void setHauptPool(String newHauptPoolValue) {
        changeField(this.hauptPoolFieldId, newHauptPoolValue);
    }
    public void toSubmitButton (){
        webDriver.findElement(this.submitButton).click();
    }

    private void changeField(String id, String value) {
        WebElement actMPool = webDriver.findElement(By.id(id));
        actMPool.clear();
        actMPool.sendKeys(value);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='" + id + "-listbox']//li[contains(text(), '" + value + "')]"))).click();
    }
}
