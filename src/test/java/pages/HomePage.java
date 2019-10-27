package pages;

import org.openqa.selenium.By;

public class HomePage {
    private BaseFunc baseFunc;

    private final By TITLE = By.xpath(".//h1[contains(@class,'headline__title')]");

    //constructor
    public HomePage (BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openFirstArticle() {
        //Find element
        baseFunc.getElement(TITLE).click();
        //click

    }
}
