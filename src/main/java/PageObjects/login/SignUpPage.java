package PageObjects.login;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class SignUpPage extends BasePage {
    private final $ linkText = $(By.linkText("Have an account?"));
    private final $ userNameInput = $(By.cssSelector("input[type='text']"));
    private final $ emailInput = $(By.cssSelector("input[type='email']"));
    private final $ passwordInput = $(By.cssSelector("input[type='password']"));
    private final $ buttonInput = $(By.cssSelector("button[type='submit']"));
    private final $ errorMessageText = $(By.cssSelector("ul[class='error-messages']"));

    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void waitPageToLoad() {
        waitPage(linkText, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(linkText.isDisplayed());
        softAssert.assertTrue(userNameInput.isDisplayed());
        softAssert.assertTrue(emailInput.isDisplayed());
        softAssert.assertTrue(passwordInput.isDisplayed());
        softAssert.assertTrue(buttonInput.isDisplayed());
        softAssert.assertAll();
    }

    public void fillingForm(String username, String email, String password) {
        logs.info("Filling username " + username);
        userNameInput.sendKeys(username);

        logs.info("Filling email " + email);
        emailInput.sendKeys(email);

        logs.info("Filling passwrod " + password);
        passwordInput.sendKeys(password);

        logs.info("clicking SignIN button");
        buttonInput.click();
    }

    @Step("Verifying errorMessage")
    public void verifyErrorMessage(String errorMessage) {
        waitPage(errorMessageText, this.getClass().getSimpleName());
        logs.info("Verifying errorMessage");
        softAssert.assertTrue(errorMessageText.isDisplayed());
        logs.info(errorMessageText.getText() + " obteniendo data de la pagina");
        softAssert.assertTrue(errorMessageText.getText().contains(errorMessage), " no la frase no es igual");
        softAssert.assertAll();
    }

}
