package utilities;

import PageObjects.Pages.HeaderPage;
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

}
