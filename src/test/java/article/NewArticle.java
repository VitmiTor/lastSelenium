package article;

import PageObjects.Pages.NewPostPage;
import PageObjects.Pages.PostedPage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewArticle extends BaseTest {

    private NewPostPage newPostPage;
    private PostedPage postedPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.newPost();
    }

    @Test
    public void verify() {
        newPostPage.verifyPage();
    }

    @Test
    public void createArticle() {
        newPostPage.createArticle();
        postedPage.waitPageToLoad();
        Assert.assertEquals(newPostPage.articleName(), postedPage.titlePost());
    }

    
    @Override
    protected void initPages(WebDriver driver) {
        newPostPage = new NewPostPage(driver);
        postedPage = new PostedPage(driver);
    }
}
