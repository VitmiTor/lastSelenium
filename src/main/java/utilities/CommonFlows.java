package utilities;

import PageObjects.bars.HeaderPage;
import PageObjects.login.SignInPage;
import PageObjects.login.UserPage;
import data.DataProviders;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final WebDriver driver;
    private final String mainUrl = "https://react-redux.realworld.io/";
    private final DataProviders dataProviders = new DataProviders();

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToSignUp() {
        var headerPage = new HeaderPage(driver);
        driver.get(mainUrl);
        headerPage.waitPageToLoad();
        headerPage.clickSignUpInput();
    }

    public void goToSignIn() {
        var headerPage = new HeaderPage(driver);
        driver.get(mainUrl);
        headerPage.waitPageToLoad();
        headerPage.clickSignInInput();
    }

    public void goToHome() {
        var headerPage = new HeaderPage(driver);
        driver.get(mainUrl);
        headerPage.waitPageToLoad();
        headerPage.clickHomeInput();
    }

    public void SignIn() {
        var signIn = new SignInPage(driver);
        var signInfor = dataProviders.getUserInfoHardcoded();
        signIn.fillingSingInform(signInfor.getEmail(), signInfor.getPassword());
    }

    public void goToSettings() {
        var userPage = new UserPage(driver);
        userPage.goSetting();
    }

    public void newPost() {
        goToSignIn();
        SignIn();
        var userPage = new UserPage(driver);
        userPage.waitPageToLoad();
        userPage.goNewPost();
    }

}
