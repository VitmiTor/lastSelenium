package PageObjects.Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class PostedPage extends BasePage {

    private final $ buttonSubmit = $(By.cssSelector("button[type='submit']"));
    private final $ title = $(By.cssSelector("div[class='container']>h1"));

    public PostedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(buttonSubmit, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public String titlePost() {
        return title.getText();
    }

}
