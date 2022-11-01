package settings;

import PageObjects.Pages.SettingPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Settings extends BaseTest {

    private SettingPage settingPage;
    private UserPage userPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();
        userPage.waitPageToLoad();
        commonFlows.goToSettings();
    }

    @Test
    public void verifySettings() {
        settingPage.verifyPage();
    }


    @Test
    public void settings() {
        settingPage.LogOut();
    }

    @Override
    protected void initPages(WebDriver driver) {
        settingPage = new SettingPage(driver);
        userPage = new UserPage(driver);
    }
}
