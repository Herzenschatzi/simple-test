package WorkForce;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DispositionPage;
import pageObjects.MitarbeiterPool;
import pageObjects.StammdatenPage;

import java.time.Duration;

public class AddTechnikerTest {
    @Test
    public void addTechniker() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));//wait until butt appears, but max 5
        driver.get("http://localhost:3000/workforce-resource-local");

        //  можно как то заиспользовать тест TechnikOpenTest  для перехода на страницу с таблицей техников?

        Thread.sleep(500);
        WebElement addButton = driver.findElement(By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//a[@class='button_link']"));
        addButton.click();

        Thread.sleep(2000);

        //go to the techniker creation form
        StammdatenPage stammdatenPage = new StammdatenPage(driver);
        stammdatenPage.fillStammdaten("Anna1230", "Fuchs", "Anna",
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
        //WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]//button[@id='employee-request-button-id']"));

        Thread.sleep(2000);

        driver.quit();

    }
}