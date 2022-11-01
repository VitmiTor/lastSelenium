package PageObjects.Pages;

import base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class NewPostPage extends BasePage {

    private final $ buttonInput = $(By.cssSelector("button[type='button']"));
    private final $ descriptionInput = $(By.cssSelector("textarea[class='form-control']"));
    private final $$ textBox = $$(By.cssSelector("input[type='text']"));

    private String a = "";

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(buttonInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(buttonInput.isDisplayed());
        softAssert.assertTrue(descriptionInput.isDisplayed());
        softAssert.assertAll();
    }

    public void createArticle() {
        waitPageToLoad();
        var faker = new Faker();
        a = faker.backToTheFuture().character();
        textBox.getElementIndex(0).sendKeys(a);
        textBox.getElementIndex(1).sendKeys(faker.backToTheFuture().quote());
        descriptionInput.sendKeys(faker.team().sport());
        textBox.getElementIndex(2).sendKeys(faker.aquaTeenHungerForce().character());
        buttonInput.click();
    }

    public String articleName() {
        return a;
    }
}
