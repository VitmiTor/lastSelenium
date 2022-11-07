package PageObjects.Pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webElements.list.$$;
import webElements.single.$;

public class ProfileUser extends BasePage {

    private $ myArticlesInput = $(By.xpath("//a[text()='My Articles']"));
    private $$ articleInput = $$(By.className("preview-link"));
    private $ editProfileInput = $(By.className("ion-gear-a"));

    public ProfileUser(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting ProfileUser Page to load")
    @Override
    public void waitPageToLoad() {
        waitPage(myArticlesInput, this.getClass().getSimpleName());
    }

    @Step("Verifying ProfileUSer Page")
    @Override
    public void verifyPage() {
        Assert.assertTrue(myArticlesInput.isDisplayed());
    }

    @Step("Clicking on first article")
    public void firstArticle() {
        waitPageToLoad();
        logs.info("Clicking on first article");
        articleInput.getElementIndex(0).click();
    }

    @Step("Getting first article Text")
    public String firstArticleText() {
        waitPageToLoad();
        logs.info("Getting first article Text");
        return articleInput.getElementIndex(0).getText();
    }

    @Step("Click on editProfile")
    public void edittingProfile() {
        waitPageToLoad();
        logs.info("Getting first article Text");
        editProfileInput.click();
    }
}
