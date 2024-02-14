package WorkForce;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.StammdatenPage;
import utils.GeneralUtils;

import java.time.Duration;

public class AddTechnikerTest {
    @Test
    public void addTechniker() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        GeneralUtils generalUtils = new GeneralUtils(driver);

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));//wait until butt appears, but max 5
        driver.get("http://localhost:3000/workforce-resource-local");

        //  можно как то заиспользовать тест TechnikOpenTest  для перехода на страницу с таблицей техников?

        Thread.sleep(500);
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]//a[@class=\"button_link\"]"));
        addButton.click();

        //go to the techniker creation form


        StammdatenPage stammdatenPage = new StammdatenPage(driver);
        stammdatenPage.fillStammdaten("Anna1230", "Fuchs", "Anna",
                "123_001");
//
        //fill the 1st page of the form


        //go the 2nd page of the form
        WebElement disposButton = driver.findElement(By.xpath("//div[@id='navigation_header-disposition-id']//button"));
        disposButton.click();
        //fill the 2nd page of the form

        generalUtils.fillInputByXpath("postcode-input-id", "01605");
        generalUtils.fillInputByXpath("city-input-id", "Cologne");
        generalUtils.fillInputByXpath("street-name-input-id", "Walder");
        generalUtils.fillInputByXpath("street-nr-first-input-id", "12");
        generalUtils.fillInputByXpath("action-planning-group-input-id", "Test");

        // go to the 3rd page

        WebElement poolButton = driver.findElement(By.xpath("//div[@id='navigation_header-pool-id']//button"));
        poolButton.click();

        // fill the 3rd page

        generalUtils.fillDropDown("//input[@id='Aktueller-district-autocomplete-id']", "Berlin", "//ul[@id='Aktueller-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]");
        generalUtils.fillDropDown("//input[@id='Aktueller-pool-autocomplete-id']", "FS5556_05", "//ul[@id='Aktueller-pool-autocomplete-id-listbox']//li[contains(text(), 'FS5556_05')]");
        generalUtils.fillDropDown("//input[@id='Haupt-district-autocomplete-id']", "Berlin", "//ul[@id='Haupt-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]");
        generalUtils.fillDropDownShort("Haupt-pool-autocomplete-id", "FS5556_05"); //короткий вариант тех же методов выше

        //technicker anlegen

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]//button[@id='employee-request-button-id']"));
        submitButton.click();

        driver.quit();
    }
}