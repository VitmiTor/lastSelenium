package PageObjects.Pages;

import base.BasePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class NewPostPage extends BasePage {

    private final $ buttonInput = $(By.cssSelector("button[type='button']"));
    private final $ descriptionInput = $(By.cssSelector("textarea[class='form-control']"));
    private final $$ textBox = $$(By.cssSelector("input[type='text']"));

    private String a = "old";
    private String b = "new";

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    @Step("Wait NewPostPage to load")
    @Override
    public void waitPageToLoad() {
        waitPage(buttonInput, this.getClass().getSimpleName());
    }

    @Step("go to Home page")
    @Override
    public void verifyPage() {
        softAssert.assertTrue(buttonInput.isDisplayed());
        softAssert.assertTrue(descriptionInput.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Creating Article")
    public void createArticle() {
        waitPageToLoad();
        var faker = new Faker();
        a = faker.backToTheFuture().character();
        logs.info("writing title of the article ");
        textBox.getElementIndex(0).sendKeys(a);

        logs.info("writing about the article");
        textBox.getElementIndex(1).sendKeys(faker.backToTheFuture().quote());

        logs.info("writing the description of the article");
        descriptionInput.sendKeys(faker.team().sport());

        logs.info("writing the tag of the article");
        textBox.getElementIndex(2).sendKeys(faker.aquaTeenHungerForce().character());

        logs.info("saving the article");
        buttonInput.click();
    }

    @Step("Editing an old Article")
    public void editingOldArticle() {
        waitPageToLoad();
        var faker = new Faker();
        b = faker.dragonBall().character();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.getLocalizedMessage();
        }
        logs.info("editing title of the article ");
        textBox.getElementIndex(0).clear().sendKeys(b);

        logs.info("editing about the article");
        textBox.getElementIndex(1).clear().sendKeys(faker.backToTheFuture().quote());

        logs.info("editing the description of the article");
        descriptionInput.clear().sendKeys(faker.team().sport());

        logs.info("editing the tag of the article");
        textBox.getElementIndex(2).clear().sendKeys(faker.aquaTeenHungerForce().character());

        logs.info("saving the article");
        buttonInput.click();
    }

    @Step("Getting the Title of the edited article")
    public String editedArticleTtitle() {
        return b;
    }

    @Step("Geting new Article name")
    public String articleName() {
        return a;
    }
}
