package article;

import PageObjects.Pages.PostedPage;
import PageObjects.Pages.ProfileUser;
import PageObjects.login.UserPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteArticle extends BaseTest {

    private UserPage userPage;

    private ProfileUser profileUser;
    private PostedPage postedPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignIn();
        commonFlows.SignIn();
        userPage.clickOnUSer();
        profileUser.firstArticle();
    }

    @Test(groups = regression)
    public void deleteArticle() {
        var a = postedPage.titlePost();
        postedPage.deleteArticleButton();
        userPage.waitPageToLoad();
        userPage.clickOnUSer();
        logs.info(a + " nombre del Post a eliminar");
        logs.info(profileUser.firstArticleText() + " Articulo encontrado");
        Assert.assertNotEquals(profileUser.firstArticleText(), a);
    }

    @Override
    protected void initPages(WebDriver driver) {
        userPage = new UserPage(driver);
        profileUser = new ProfileUser(driver);
        postedPage = new PostedPage(driver);
    }
}
