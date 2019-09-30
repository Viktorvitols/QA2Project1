import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DelfiArticleTest {

    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-22')]");
    // By - тип локатора
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[@class = 'article-title']/a");
    private final By ARTICLE = By.xpath(".//span[@class = 'text-size-22 d-block']");
    private final By COMMENT_PAGE_COMMENTS = By.xpath(".//span[@class = 'type-cnt']");
    private final By COMMENT_ICON = By.xpath(".//i[@class = 'icon-ui-comments']");
    private final By PLUS_ARTICLE_PAGE_TITLE = By.xpath(".//h1[@class ='text-size-22  d-inline']");

    @Test
    public void titleAndCommentsTest() {

        //Open browser
        System.setProperty("webdriver.chrome.driver", "c:/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Delfi home page
        driver.get("http://rus.delfi.lv");

        //Find first article
        WebElement article = driver.findElements(ARTICLE).get(0);

        //Find first article title - локаторы наверх
        WebElement homePageTitle = article.findElement(HOME_PAGE_TITLE);

        //Save to string
        String titleToCompare = homePageTitle.getText();

        //Find comments count
        Integer commentsToCompare = 0;

        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty()) {
            WebElement homePageComments = article.findElement(HOME_PAGE_COMMENTS);

            //Save to integer
            String commentsToParse = homePageComments.getText(); // *(1)
            commentsToParse = commentsToParse.substring(1, commentsToParse.length() - 1); // *1 (убрали скобки)
            commentsToCompare = Integer.valueOf(commentsToParse);
        }

        //Open article page
        homePageTitle.click();

        //Find title
        String apTitle;
        if (!driver.findElements(ARTICLE_PAGE_TITLE).isEmpty()) {
            apTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        } else {
            apTitle = driver.findElement(PLUS_ARTICLE_PAGE_TITLE).getText();
        }

        //Check title
        Assertions.assertEquals(titleToCompare, apTitle, "Wrong title on article page!");

        //Find comment count (строкой ниже говнокод)
        Integer apComments = 0;
        if (!driver.findElements(ARTICLE_PAGE_COMMENTS).isEmpty()) {
//            (строкой ниже говнокод)
            apComments = Integer.valueOf(driver.findElement(ARTICLE_PAGE_COMMENTS).getText().substring(1, driver.findElement(ARTICLE_PAGE_COMMENTS).getText().length() - 1));
        }

        //Check comment count
        Assertions.assertEquals(commentsToCompare, apComments, "Comments count is not the same as in the home page");

        //Open comments page
        //driver.findElement(ARTICLE_PAGE_TITLE).click(); ***не работает, если нет комментов***
        if (!driver.findElements(COMMENT_ICON).isEmpty()) {
            driver.findElement(COMMENT_ICON).click();
        } else {
            driver.close();
            System.exit(0);
        }

        //Find title
        String cpTitle = driver.findElement(COMMENTS_PAGE_TITLE).getText() + " "; //there is a fixed space in articles' title, probably to make a gap between the title and a comments count

        //Check title (compare with previous page)
        Assertions.assertEquals(titleToCompare, cpTitle, "Wrong title on comments page");

        //Get comment count
        Integer cpComments = 0;
        List<WebElement> cpAllComments = driver.findElements(COMMENT_PAGE_COMMENTS);
        if (!cpAllComments.isEmpty()) {
            WebElement anonComments = cpAllComments.get(0);
            WebElement regComments = cpAllComments.get(1);
            String numbersToParse = anonComments.getText();
            String numbersToParse1 = regComments.getText();
            numbersToParse = numbersToParse.substring(1, numbersToParse.length() - 1);
            numbersToParse1 = numbersToParse1.substring(1, numbersToParse1.length() - 1);
            Integer cpAnonComments = Integer.valueOf(numbersToParse);
            Integer cpRegComments = Integer.valueOf(numbersToParse1);
            cpComments = cpAnonComments + cpRegComments;
        }

        //Check comment count
        Assertions.assertEquals(commentsToCompare, cpComments, "Comment number on comment page is not the same as on the home page");
        //Close Browser!!!
        driver.close();

    }

}
