import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DelfiFirstTest {

    @Test
    public void delfiFirstTitleTest() {
        System.setProperty("webdriver.gecko.driver", "c:/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");



    }
}
