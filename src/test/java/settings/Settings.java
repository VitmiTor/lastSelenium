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

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();
        userPage.waitPageToLoad();
        commonFlows.goToSettings();
    }

    @Test(groups = smoke)
    public void verifySettings() {
        settingPage.verifyPage();
    }


    @Test(groups = regression)
    public void settings() {
        settingPage.LogOut();
    }

    @Override
    protected void initPages(WebDriver driver) {
        settingPage = new SettingPage(driver);
        userPage = new UserPage(driver);
    }
}
