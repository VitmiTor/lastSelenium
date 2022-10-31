package PageObjects.login;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class UserPage extends BasePage {

    private final $$ usernameText = $$(By.className("nav-link"));

    private final $ sideBarInput = $(By.className("sidebar"));

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(sideBarInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {

    }

    public String getUserText() {
        return usernameText.getElementIndex(3).getText();
    }

}
