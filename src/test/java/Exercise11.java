import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Exercise11 {
    @Test

    public   void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://autoprojekt.simplytest.de/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]//h1"));
        assertEquals(element.getText(), "Shop");
        WebElement itemCount = driver.findElement(By.xpath("//*[@id=\"site-header-cart\"]//span[contains(text(),\"0\") and @class=\"count\"]"));
        assertTrue(itemCount.getText().startsWith("0"));
        
        driver.quit();
    }
}


