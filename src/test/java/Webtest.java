import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtest {
    public static void main(String[] args) {

        openBrowser();
    }
    public static void openBrowser(){
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
