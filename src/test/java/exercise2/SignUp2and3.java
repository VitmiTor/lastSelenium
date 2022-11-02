package exercise2;

import PageObjects.login.SignUpPage;
import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static data.DataProviders.USER_INFORMATION_DP;

public class SignUp2and3 extends BaseTest {
    private SignUpPage signUpPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignUp();
    }

    @Test
    public void verifySignUp() {
        signUpPage.verifyPage();
    }

    @Test(groups = regression, dataProvider = USER_INFORMATION_DP, dataProviderClass = DataProviders.class)
    public void signUpUser(String username, String email, String password, String errorMessage) {
        var userInformation = dataProvider.userInformationDataProvider();
        signUpPage.fillingForm(username, email, password);
        signUpPage.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages(WebDriver driver) {
        signUpPage = new SignUpPage(driver);
    }
}
