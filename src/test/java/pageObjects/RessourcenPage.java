package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RessourcenPage {
    private final WebDriver webDriver;

    public RessourcenPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By deleteButton = By.id("delete-employees");
    private final By selectCheckbox = By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']" + "//input[@aria-label='Select row']");
    private final By confirmDeleteButton = By.id("btn-confirm-delete");
    private final By addButton = By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//a[@class='button_link']");
    private final By openFilter = By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//button[@data-testid='filters_id']");
    private final By filterTechniker = By.xpath("//input[@placeholder='Filterwert']");

    public void setFilterTechniker(String newFilterValue) {
        changeField(webDriver.findElement(this.filterTechniker), newFilterValue);
    }
    @Step("Filter techniker")
    public void fillFilterTechniker(String newFilterValue){
        setFilterTechniker(newFilterValue);
    }
    public void selectEmployee() {
        webDriver.findElement(this.selectCheckbox).click();
    }

    public void deleteEmployee() {
        webDriver.findElement(this.deleteButton).click();
    }

    public void confirmDeleteEmployee() {
        webDriver.findElement(this.confirmDeleteButton).click();
    }

@Step("Open ressourcen page")
    public void goToRessourcenPage() {

        webDriver.get("http://localhost:3000/workforce-resource-local");

    }

    public void addButton() {
        webDriver.findElement(this.addButton).click();
    }
    public void openFilter(){
        webDriver.findElement(this.openFilter).click();
    }



    private void changeField(WebElement element, String newValue) {
        element.clear();
        element.sendKeys(newValue);
    }
}

