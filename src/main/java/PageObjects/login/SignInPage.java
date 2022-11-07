package PageObjects.login;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class SignInPage extends BasePage {
    private final $ emailInput = $(By.cssSelector("input[type='email']"));
    private final $ passwordInput = $(By.cssSelector("input[type='password']"));
    private final $ buttonInput = $(By.cssSelector("button[type='submit']"));
    private final $ linkInput = $(By.linkText("Need an account?"));

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting SignIn to load")
    @Override
    public void waitPageToLoad() {
        waitPage(linkInput, this.getClass().getSimpleName());
    }

    @Step("Click on SignUp")
    @Override
    public void verifyPage() {
        softAssert.assertTrue(emailInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(buttonInput.isDisplayed());
        softAssert.assertAll();
    }

    @Step("Filling SignIn form")
    public void fillingSingInform(String email, String password) {
        logs.debug("filling email " + email);
        emailInput.sendKeys(email);

        logs.debug("filling password " + password);
        passwordInput.sendKeys(password);

        logs.debug("clicking button ");
        buttonInput.click();
    }

    @Step("Click on link of 'need an account?'")
    public void clickLink() {
        logs.info("clicking on link 'need an account'");
        linkInput.click();
    }
}
