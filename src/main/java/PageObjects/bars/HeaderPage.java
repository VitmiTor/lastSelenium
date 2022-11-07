package PageObjects.bars;

import base.BasePage;
import io.qameta.allure.Step;
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

    @Step("Waiting Header Page to load")
    @Override
    public void waitPageToLoad() {
        waitPage(signInInput, this.getClass().getSimpleName());
    }

    @Step("Verifying Header Page")
    @Override
    public void verifyPage() {
        softAssert.assertTrue(signUpInput.isDisplayed());
        softAssert.assertTrue(signInInput.isDisplayed());
        softAssert.assertTrue(homeInput.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Click on SignUp")
    public void clickSignUpInput() {
        logs.info("Clicking on SignUp");
        signUpInput.click();
    }

    @Step("Click on SignIn")
    public void clickSignInInput() {
        logs.info("Clicking on SignIn");
        signInInput.click();
    }

    @Step("Click on Home")
    public void clickHomeInput() {
        logs.info("clicking on Home");
        homeInput.click();
    }
}
