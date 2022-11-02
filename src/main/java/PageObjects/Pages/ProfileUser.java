package PageObjects.Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class ProfileUser extends BasePage {

    private $ myArticlesInput = $(By.xpath("//a[text()='My Articles']"));
    private $$ articleInput = $$(By.className("preview-link"));
    private $ editProfileInput = $(By.className("ion-gear-a"));

    public ProfileUser(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(myArticlesInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public void firstArticle() {
        waitPageToLoad();
        articleInput.getElementIndex(0).click();
    }

    public String firstArticleText() {
        waitPageToLoad();
        return articleInput.getElementIndex(0).getText();
    }

    public void edittingProfile() {
        waitPageToLoad();
        editProfileInput.click();
    }
}
