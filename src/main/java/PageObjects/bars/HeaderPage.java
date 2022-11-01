package PageObjects.bars;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class HeaderPage extends BasePage {

    private final $ signUpInput = $(By.xpath("//a[text()='Sign up']"));
    private final $ signInInput = $(By.xpath("//a[text()='Sign in']"));
    private final $ homeInput = $(By.xpath("//a[text()='Home']"));

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(signInInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(signUpInput.isDisplayed());
        softAssert.assertTrue(signInInput.isDisplayed());
        softAssert.assertTrue(homeInput.isDisplayed());
        softAssert.assertAll();
    }

    public void clickSignUpInput() {
        signUpInput.click();
    }

    public void clickSignInInput() {
        signInInput.click();
    }

    public void clickHomeInput() {
        homeInput.click();
    }
}
