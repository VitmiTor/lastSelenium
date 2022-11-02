package PageObjects.login;

import base.BasePage;
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

    @Override
    public void waitPageToLoad() {
        waitPage(linkInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(emailInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(buttonInput.isDisplayed());
        softAssert.assertAll();
    }

    public void fillingSingInform(String email, String password) {
        logs.debug("filling email " + email);
        emailInput.sendKeys(email);

        logs.debug("filling password " + password);
        passwordInput.sendKeys(password);

        logs.debug("clicking button ");
        buttonInput.click();
    }

    public void clickLink() {
        linkInput.click();
    }
}
