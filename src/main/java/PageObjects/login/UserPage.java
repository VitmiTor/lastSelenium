package PageObjects.login;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.list.$$;
import webElements.single.$;

public class UserPage extends BasePage {

    private final $$ navigationOption = $$(By.className("nav-link"));

    private final $ sideBarInput = $(By.className("sidebar"));


    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting User Page to load")
    @Override
    public void waitPageToLoad() {
        waitPage(sideBarInput, this.getClass().getSimpleName());
    }

    @Step("Verifying User Page")
    @Override
    public void verifyPage() {
        Assert.assertTrue(sideBarInput.isDisplayed());
    }

    @Step("Clicking on User")
    public void clickOnUSer() {
        waitPageToLoad();
        navigationOption.getElementIndex(3).click();
    }

    @Step("Getting user Text")
    public String getUserText() {
        logs.info("getting user Text");
        return navigationOption.getElementIndex(3).getText();
    }

    @Step("Go to Setting")
    public void goSetting() {
        logs.info("going to Settings");
        navigationOption.getElementIndex(2).click();
    }

    @Step("go to NewPost")
    public void goNewPost() {
        logs.info("Going to NewPost");
        navigationOption.getElementIndex(1).click();
    }
}
