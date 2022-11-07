package article;

import PageObjects.Pages.PostedPage;
import PageObjects.Pages.ProfileUser;
import PageObjects.login.SignInPage;
import PageObjects.login.UserPage;
import base.BaseTest;
import data.DataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static data.DataProviders.COMMENTARIES;

public class NewComment extends BaseTest {

    private SignInPage signInPage;
    private UserPage userPage;
    private ProfileUser profileUser;
    private PostedPage postedPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();

    }

    @Test(dataProvider = COMMENTARIES, dataProviderClass = DataProviders.class, groups = smoke)
    public void createComment(String comentarios) {
        userPage.clickOnUSer();
        profileUser.firstArticle();
        postedPage.writeCommentary(comentarios);
    }

    @Override
    protected void initPages(WebDriver driver) {
        signInPage = new SignInPage(driver);
        userPage = new UserPage(driver);
        profileUser = new ProfileUser(driver);
        postedPage = new PostedPage(driver);
    }
}
