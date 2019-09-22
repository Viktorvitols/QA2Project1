import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiArticleTest {

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    // By - тип локатора
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");

    @Test
    public void titleAndCommentsTest() {

        //Open browser
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi home page
        driver.get("http://rus.delfi.lv");

        //Find first article title - локаторы наверх
        WebElement homePageTitle = driver.findElement(HOME_PAGE_TITLE);

        //Save to string
        String titleToCompare = homePageTitle.getText();

        //Find comments count
        WebElement homePageComments = driver.findElement(HOME_PAGE_COMMENTS);

        //Save to integer
        String commentsToParse = homePageComments.getText(); // *(1)
        commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); // *1 (убрали скобки)
        Integer commentsToCompare = Integer.valueOf(commentsToParse);

        //Open article page

        //Find title
        //Check title
        //Find comment count
        //Check comment count
        //Open comments page
        //Find title
        //Check title (compare with previous page)
        //Get comment count
        //Check comment count
        //Close Browser!!!

    }


}
