package exercise4;

import PageObjects.login.SignInPage;
import PageObjects.login.SignUpPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignIn1 extends BaseTest {

    private SignInPage signInPage;
    private UserPage userPage;
    private SignUpPage signUpPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.goToSignIn();
    }

    @Test
    public void verifySignIn() {
        signInPage.verifyPage();
    }

    @Test
    public void fillingSignin() {
        var userInfor = dataProvider.getUserInfoHardcoded();
        signInPage.fillingSingInform(userInfor.getEmail(), userInfor.getPassword());
        userPage.waitPageToLoad();
        Assert.assertEquals(userPage.getUserText(), userInfor.getUser());
    }

    @Test
    public void goToLinkText() {
        signInPage.clickLink();
        signUpPage.waitPageToLoad();
    }

    @Override
    protected void initPages(WebDriver driver) {
        signInPage = new SignInPage(driver);
        userPage = new UserPage(driver);
        signUpPage = new SignUpPage(driver);
    }


}
