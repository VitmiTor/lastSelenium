package exercise1;

import PageObjects.bars.HeaderPage;
import PageObjects.login.SignUpPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUp1 extends BaseTest {
    private HeaderPage headerPage;
    private SignUpPage signUpPage;
    private UserPage userPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignUp();
    }

    @Test(groups = smoke)
    public void normalSignIn() {
        var userInfor = dataProvider.getUserInfoHardcoded();
        signUpPage.waitPageToLoad();
        signUpPage.fillingForm(userInfor.getUser(), userInfor.getEmail(), userInfor.getPassword());
        userPage.waitPageToLoad();
        Assert.assertEquals(userInfor.getUser(), userPage.getUserText());
    }

    @Override
    protected void initPages(WebDriver driver) {
        headerPage = new HeaderPage(driver);
        signUpPage = new SignUpPage(driver);
        userPage = new UserPage(driver);
    }
}
