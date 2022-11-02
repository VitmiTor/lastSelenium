package PageObjects.login;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.list.$$;
import webElements.single.$;

public class UserPage extends BasePage {

    private final $$ navigationOption = $$(By.className("nav-link"));

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

    public void clickOnUSer() {
        waitPageToLoad();
        navigationOption.getElementIndex(3).click();
    }

    public String getUserText() {
        return navigationOption.getElementIndex(3).getText();
    }

    public void goSetting() {
        navigationOption.getElementIndex(2).click();
    }

    public void goNewPost() {
        navigationOption.getElementIndex(1).click();
    }

}
