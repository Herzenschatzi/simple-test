package WorkForce;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.DispositionPage;
import pageObjects.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPageTest {
    private WebDriver driver = null;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void openTest() throws InterruptedException {
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));//wait until butt appears, but max 5
        driver.get("http://localhost:3000/");

        Thread.sleep(500);

        WebElement element = driver.findElement(By.xpath("//*[@id='main-menu']/h1")); //xpath by id
        assertEquals(element.getText(), "Main page");

        /*
            * -> Любой элемент (div, span, h1, p, href... любой html элемент-тэг)
            div -> div


            1. Любой элемент но с id = "single-spa-application:@ad-portal/navbar"
            2. У найденного элемента найди в дочерних span, который содержит текст "Workforce Resource local"

         */
        MainPage mainPage = new MainPage(driver);
        //WebElement oneButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]//span[contains(text(),'Workforce Resource local')]"));
        mainPage.oneButton();
        Thread.sleep(2000);

        //WebElement resButton = driver.findElement(By.xpath("//*[@id=\"single-spa-application:@ad-portal/navbar\"]//*[contains(text(),'Ressourcen')]"));
        //waiter.until(ExpectedConditions.visibilityOf(resButton)).click();
        mainPage.resButton();

        Assert.assertEquals("http://localhost:3000/workforce-resource-local", driver.getCurrentUrl());
    }
}
