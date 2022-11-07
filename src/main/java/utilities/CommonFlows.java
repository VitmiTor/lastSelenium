package utilities;

import PageObjects.bars.HeaderPage;
import PageObjects.login.SignInPage;
import PageObjects.login.UserPage;
import data.DataProviders;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final WebDriver driver;
    private final Logs logs = new Logs();
    private final String mainUrl = "https://react-redux.realworld.io/";
    private final DataProviders dataProviders = new DataProviders();

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    @Step("go to SignUp page")
    public void goToSignUp() {
        var headerPage = new HeaderPage(driver);
        logs.info("go to Url");
        driver.get(mainUrl);

        logs.info("waiting header Page To load");
        headerPage.waitPageToLoad();
        logs.info("Clicking on SignUp in the header page");
        headerPage.clickSignUpInput();
    }

    @Step("go to SignIn page")
    public void goToSignIn() {
        var headerPage = new HeaderPage(driver);
        logs.info("go to Url");
        driver.get(mainUrl);

        logs.info("waiting header Page to load");
        headerPage.waitPageToLoad();
        logs.info("clicking SigIn button");
        headerPage.clickSignInInput();
    }

    @Step("go to Home page")
    public void goToHome() {
        var headerPage = new HeaderPage(driver);
        logs.info("go to Url");
        driver.get(mainUrl);

        logs.info("waiting header Page to load");
        headerPage.waitPageToLoad();

        logs.info("Clicking Home button");
        headerPage.clickHomeInput();
    }

    @Step("Filling SignIn textBoxes")
    public void SignIn() {
        var signIn = new SignInPage(driver);
        var signInfor = dataProviders.getUserInfoHardcoded();

        logs.info("Waiting SignIn Page to load");
        signIn.waitPageToLoad();

        logs.info("Filling Sign in form");
        signIn.fillingSingInform(signInfor.getEmail(), signInfor.getPassword());
    }

    @Step("go to Setting Page")
    public void goToSettings() {
        var userPage = new UserPage(driver);
        logs.info("go to Setting Page");
        userPage.goSetting();
    }

    @Step("go to NewPost page")
    public void newPost() {
        goToSignIn();
        SignIn();
        var userPage = new UserPage(driver);
        logs.info("going to user Page");
        userPage.waitPageToLoad();
        logs.info("going to NewPost Page");
        userPage.goNewPost();
    }
}
