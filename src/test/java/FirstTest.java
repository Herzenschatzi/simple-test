import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test

    public void firstTest() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
