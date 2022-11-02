package settings;

import PageObjects.Pages.ProfileUser;
import PageObjects.Pages.SettingPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfileSetting extends BaseTest {

    private UserPage userPage;
    private ProfileUser profileUser;
    private SettingPage settings;

    @BeforeMethod
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();
        userPage.clickOnUSer();
    }

    @Test
    public void editProfile() {
        profileUser.edittingProfile();
        settings.verifyPage();
    }

    @Override
    protected void initPages(WebDriver driver) {
        userPage = new UserPage(driver);
        profileUser = new ProfileUser(driver);
        settings = new SettingPage(driver);
    }
}
