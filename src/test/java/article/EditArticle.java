package article;

import PageObjects.Pages.NewPostPage;
import PageObjects.Pages.PostedPage;
import PageObjects.Pages.ProfileUser;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditArticle extends BaseTest {

    private PostedPage postedPage;
    private UserPage userPage;
    private ProfileUser profileUser;
    private NewPostPage newPostPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();
    }

    @Test
    public void editingArticle() {
        userPage.clickOnUSer();
        profileUser.firstArticle();
        postedPage.editArticleButton();
        newPostPage.editingOldArticle();
        var c = newPostPage.editedArticleTtitle();
        postedPage.waitPageToLoad();
        var d = postedPage.titlePost();
        logs.info(c + " este es el C");
        logs.info(d + " este es el D");
        Assert.assertEquals(c, d);
    }

    @Override
    protected void initPages(WebDriver driver) {
        postedPage = new PostedPage(driver);
        userPage = new UserPage(driver);
        profileUser = new ProfileUser(driver);
        newPostPage = new NewPostPage(driver);
    }
}
