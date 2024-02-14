package WorkForce;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FilterUtils;
import utils.GeneralUtils;

import java.time.Duration;
import java.util.List;

public class FilteringTechnikListTest {

    @Test
    public void testTechniker() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        GeneralUtils generalUtils = new GeneralUtils(driver);
        FilterUtils filterUtils = new FilterUtils(driver);
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));//wait until butt appears, but max 5
        driver.get("http://localhost:3000/workforce-resource-local");

        Thread.sleep(1000);

        filterUtils.openFilter("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//button[@data-testid='filters_id']");
        Thread.sleep(500);
        //sleep?

        filterUtils.filterTechniker("//*[@placeholder='Filterwert']", "Anna123");
        Thread.sleep(500);
        filterUtils.openFilter("//*[@id='single-spa-application:@ad-portal/workforce-resource-local']//button[@data-testid='filters_id']");

        Thread.sleep(500);

        // =======>
        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='main-menu']//div[@role='grid']//div[@role='row']"));
        Assert.assertEquals(2, rows.size());

        WebElement annaRow = rows.get(1);

        List<WebElement> cells = annaRow.findElements(By.xpath("//div[@role='cell']"));
        Assert.assertEquals(8, cells.size());

        Assert.assertEquals("Anna", cells.get(1).getText());
        Assert.assertEquals("Fuchs", cells.get(2).getText());
        Assert.assertEquals("test@test.com", cells.get(3).getText());
        Assert.assertEquals("FS5556_05", cells.get(4).getText());
        Assert.assertEquals("FS5556_05", cells.get(5).getText());

        driver.quit();
    }
}
