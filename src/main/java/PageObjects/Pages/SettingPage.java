package PageObjects.Pages;

import base.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Override
    public void waitPageToLoad() {
        waitPage(title, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(title.isDisplayed());
        softAssert.assertTrue(buttonLogOut.isDisplayed());
        softAssert.assertAll();
    }

    public void LogOut() {
        buttonLogOut.click();
    }

    public void fillingBio() {
        var faker = new Faker();
        newname = faker.name().fullName();
        textBox.getElementIndex(1).sendKeys(Keys.CONTROL + "a");
        textBox.getElementIndex(1).sendKeys(newname);
        textBio.sendKeys(faker.aquaTeenHungerForce().character());
        buttonUpdate.click();

    }

    public String getNewname() {
        return newname;
    }


}
