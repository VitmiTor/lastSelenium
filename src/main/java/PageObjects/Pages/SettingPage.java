package PageObjects.Pages;

import base.BasePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class SettingPage extends BasePage {

    private final $ title = $(By.className("text-xs-center"));
    private final $ buttonLogOut = $(By.cssSelector("button[class='btn btn-outline-danger']"));
    private final $$ textBox = $$(By.cssSelector("input[type='text']"));
    private final $ buttonUpdate = $(By.cssSelector("button[type='submit']"));

    private final $ textBio = $(By.cssSelector("textarea[class='form-control form-control-lg']"));
    private String newname;

    public SettingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting Setting Page to load")
    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Step("Verifying Setting Page")
    @Override
    public void verifyPage() {
        waitPageToLoad();
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertTrue(buttonLogOut.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Clicking on LogOut")
    public void LogOut() {
        logs.info("Clicking on LogOut");
        buttonLogOut.click();
    }

    @Step("Refilling Bio information")
    public void fillingBio() {
        var faker = new Faker();

        newname = faker.name().fullName();
        logs.info("writing name");
        textBox.getElementIndex(1).clear().sendKeys(newname);

        logs.info("writing biography of the user");
        textBio.sendKeys(faker.aquaTeenHungerForce().character());

        logs.info("Clicking button save");
        buttonUpdate.click();
    }

    @Step("Getting New Name of thew User")
    public String getNewname() {
        return newname;
    }
}
