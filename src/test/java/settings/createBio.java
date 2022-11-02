package settings;

import PageObjects.Pages.SettingPage;
import PageObjects.login.SignInPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class createBio extends BaseTest {

    private SignInPage signInPage;
    private SettingPage settingPage;
    private UserPage userPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.goToSignIn();
        signInPage.waitPageToLoad();
        commonFlows.SignIn();
        userPage.waitPageToLoad();
        commonFlows.goToSettings();
    }

    @Test
    public void verifySet() {
        settingPage.verifyPage();
    }

    @Test
    public void createBio() {
        settingPage.waitPageToLoad();
        settingPage.fillingBio();
        userPage.waitPageToLoad();
        Assert.assertEquals(settingPage.getNewname(), userPage.getUserText());
    }


    @Override
    protected void initPages(WebDriver driver) {
        signInPage = new SignInPage(driver);
        settingPage = new SettingPage(driver);
        userPage = new UserPage(driver);
    }
}
