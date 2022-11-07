package PageObjects.Pages;

import base.BasePage;
import io.qameta.allure.Step;
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

    @Step("Waiting PostedPage To load")
    @Override
    public void waitPageToLoad() {
        waitPage(buttonSubmit, this.getClass().getSimpleName());
    }

    @Step("Verifying PostedPage Page")
    @Override
    public void verifyPage() {
        softAssert.assertTrue(buttonSubmit.isDisplayed());
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertTrue(commentaryBoxInput.isDisplayed());
        softAssert.assertTrue(editButtonInput.isDisplayed());
        softAssert.assertTrue(deleteButtonInput.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Getting Title Post")
    public String titlePost() {
        waitPageToLoad();
        logs.info("getting title Text");
        return title.getText();
    }

    @Step("Writting commentaries")
    public void writeCommentary(String text) {
        waitPageToLoad();
        logs.info("writing commentary in the article");
        commentaryBoxInput.sendKeys(text);

        logs.info("saving commentary");
        buttonSubmit.click();

        logs.info("waiting for the bin button of the commentary");
        waitPage(binInput.getElementIndex(0), "bin of the comment");
    }

    @Step("clicking on editArticleButton")
    public void editArticleButton() {
        waitPageToLoad();
        logs.info("clicking on editArticleButton");
        editButtonInput.click();
    }

    @Step("Clicking on delete Article Button")
    public void deleteArticleButton() {
        waitPageToLoad();
        logs.info("Clicking on delete Article Button");
        deleteButtonInput.click();
    }
}
