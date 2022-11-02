package PageObjects.Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class PostedPage extends BasePage {

    private final $ buttonSubmit = $(By.cssSelector("button[type='submit']"));
    private final $ title = $(By.cssSelector("div[class='container']>h1"));
    private final $ commentaryBoxInput = $(By.cssSelector("textarea[class='form-control']"));
    private final $ editButtonInput = $(By.className("ion-edit"));
    private final $ deleteButtonInput = $(By.className("ion-trash-a"));
    private final $$ binInput = $$(By.className("mod-options"));

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
        waitPageToLoad();
        return title.getText();
    }

    public void writeCommentary(String text) {
        waitPageToLoad();
        commentaryBoxInput.sendKeys(text);
        buttonSubmit.click();
        waitPage(binInput.getElementIndex(0), "bin of the comment");
    }

    public void editArticleButton() {
        waitPageToLoad();
        editButtonInput.click();
    }

    public void deleteArticleButton() {
        waitPageToLoad();
        deleteButtonInput.click();
    }


}
