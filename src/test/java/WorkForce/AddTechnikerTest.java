package WorkForce;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DispositionPage;
import pageObjects.MitarbeiterPool;
import pageObjects.RessourcenPage;
import pageObjects.StammdatenPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddTechnikerTest {
    @Test
    public void addTechniker() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        RessourcenPage ressourcenPage = new RessourcenPage(driver);

        //WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        //How to use waiter instead of all(?) sleeps in the test?
        //@Before
        ressourcenPage.goToRessourcenPage();
        Thread.sleep(2000);
        ressourcenPage.openFilter();
        ressourcenPage.fillFilterTechniker("Anna123");
        Thread.sleep(2000);
        ressourcenPage.openFilter();
        List<WebElement> elementsBefore = driver.findElements(By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//div[contains(text(),'Keine Ergebnisse')]"));
        assertEquals("Techniker already exists", 1, elementsBefore.size()); //(size = 0, Techniker exists, size = 1, Techniker dos not exists)

        Thread.sleep(500);

        ressourcenPage.addButton();

        Thread.sleep(500);

        //go to the techniker creation form
        StammdatenPage stammdatenPage = new StammdatenPage(driver);
        stammdatenPage.fillStammdaten("Anna123", "Fuchs", "Anna",
                "123_001", "456_001", "016000000", "test@test.com");

        //go the 2nd page of the form
        stammdatenPage.goToDisposition();


        //fill the 2nd page of the form
        DispositionPage dispositionPage = new DispositionPage(driver);
        dispositionPage.fillDisposition("01605", "Cologne",
                "Walder", "12", "Test");

        // go to the 3rd page
        dispositionPage.goNextPage();

        // fill the 3rd page
        MitarbeiterPool mitarbeiterPool = new MitarbeiterPool(driver);
        mitarbeiterPool.fillMitarbeiterPool("Berlin", "FS5556_05",
                "Berlin", "FS5556_05");

        //technicker anlegen
        mitarbeiterPool.toSubmitButton();


        Thread.sleep(2000);
//@After
        ressourcenPage.goToRessourcenPage();
        Thread.sleep(2000);

        //delete the filtered out employee
        ressourcenPage.openFilter();
        Thread.sleep(500);
        ressourcenPage.fillFilterTechniker("Anna123");
        Thread.sleep(500);
        ressourcenPage.openFilter();
        Thread.sleep(500);

        List<WebElement> elementsBeforeAdd = driver.findElements(By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//div[contains(text(),'Keine Ergebnisse')]"));
        assertEquals(0, elementsBeforeAdd.size());

        Thread.sleep(500);
        ressourcenPage.selectEmployee();
        Thread.sleep(1000);
        ressourcenPage.deleteEmployee();
        Thread.sleep(1000);
        ressourcenPage.confirmDeleteEmployee();
        Thread.sleep(1000);

        List<WebElement> elementsAfter = driver.findElements(By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//div[contains(text(),'Keine Ergebnisse')]"));
        assertEquals("Techniker exists",1, elementsAfter.size());

        Thread.sleep(1000);


        driver.quit();

    }
}