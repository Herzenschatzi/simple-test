package WorkForce;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AddTechnikerTest {
    @Test
    public void addTechniker() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));//wait until butt appears, but max 5
        driver.get("http://localhost:3000/");

//  можно как то заиспользовать тест TechnikOpenTest  для перехода на страницу с таблицей техников?

        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//*[@id='main-menu']/h1")); //xpath by id
        assertEquals(element.getText(), "Main page");

        WebElement oneButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]//span[contains(text(),'Workforce Resource local')]"));
        oneButton.click();

        //Thread.sleep(200); //check waiting bc sleep could prolong the exec

        WebElement resButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]//*[contains(text(),'Ressourcen')]"));
        waiter.until(ExpectedConditions.visibilityOf(resButton)).click();
        Thread.sleep(2000);
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]//a[@class=\"button_link\"]"));

        //Waiting until page will be successfully loaded (for manual check)
        addButton.click();
        Thread.sleep(1000);


        //go to the techniker creation form
        /*
        WebElement addTechnikerButton = driver.findElement(
                By.xpath("/*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//button[@id=\"create_employee-button-id\"]"));
        addTechnikerButton.click();
        */

        //fill the 1st page of the form
        WebElement benutzerkennungField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='origin-id-input-id']"));
        benutzerkennungField.sendKeys("Anna123");

        WebElement nachnameField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='family_name-input-id']\n"));
        nachnameField.sendKeys("Fuchs");

        WebElement vornameField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='given_name-input-id']\n"));
        vornameField.sendKeys("Anna");

        WebElement prsnNummerField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='personnel_number-input-id']\n"));
        prsnNummerField.sendKeys("123");

        WebElement prsnNummerHrField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='personnel_number_hr-input-id']\n"));
        prsnNummerHrField.sendKeys("456");

        WebElement telMobilField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='mobile-input-id']\n"));
        telMobilField.sendKeys("016000000");

        WebElement emailField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='email-address-input-id']\n"));
        emailField.sendKeys("test@test.com");

        //go the 2nd page of the form
        WebElement disposButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                "//div[@id='navigation_header-disposition-id']//button"));

        disposButton.click();
        Thread.sleep(500);
        //fill the 2nd page of the form

        WebElement plzField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='postcode-input-id']"));
        plzField.sendKeys("01605");

        WebElement ortField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='city-input-id']"));
        ortField.sendKeys("Cologne");

        WebElement strasseField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='street-name-input-id']"));
        strasseField.sendKeys("Walder");

        WebElement hausnumField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='street-nr-first-input-id']"));
        hausnumField.sendKeys("12");

        WebElement smileField = driver.findElement(
                By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                        "//input[@id='action-planning-group-input-id']"));
        smileField.sendKeys("Test");

        // go to the 3rd page

        WebElement poolButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]" +
                "//div[@id='navigation_header-pool-id']//button"));
        poolButton.click();
        Thread.sleep(500);

        // fill the 3rd page

        WebElement actPoolList = driver.findElement(
                By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//input[@id='Aktueller-district-autocomplete-id']"));
        actPoolList.sendKeys("Berlin");
        driver.findElement(By.xpath("//ul[@id='Aktueller-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]")).click();

        Thread.sleep(500);

        WebElement actMPool = driver.findElement(
                By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//input[@id='Aktueller-pool-autocomplete-id']"));
        actMPool.sendKeys("FS5556_05");
        driver.findElement(By.xpath("//ul[@id='Aktueller-pool-autocomplete-id-listbox']//li[contains(text(), 'FS5556_05')]")).click();

        Thread.sleep(2000);

        WebElement hauptPoolList = driver.findElement(
                By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//input[@id='Haupt-district-autocomplete-id']"));
        hauptPoolList.sendKeys("Berlin");
        driver.findElement(By.xpath("//ul[@id='Haupt-district-autocomplete-id-listbox']//li[contains(text(), 'Berlin')]")).click();

        Thread.sleep(500);

        WebElement actHPool = driver.findElement(
                By.xpath("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//input[@id='Haupt-pool-autocomplete-id']"));
        actHPool.sendKeys("FS5556_05");
        driver.findElement(By.xpath("//ul[@id='Haupt-pool-autocomplete-id-listbox']//li[contains(text(), 'FS5556_05')]")).click();

        //technicker anlegen

        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/workforce-resource-local\"]//button[@id='employee-request-button-id']"));
        Thread.sleep(500);
        submitButton.click();
        Thread.sleep(500);


        //driver.findElement(By.xpath("//*[contains(text(),'FS5556_05')]")).click();
        //Thread.sleep(2000);


    }
}

