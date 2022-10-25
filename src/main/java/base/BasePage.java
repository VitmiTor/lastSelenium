package base;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webElements.single.$;

public abstract class BasePage {
    protected Logs logs = new Logs();
    protected final WebDriver driver;
    private int timeOut;
    protected SoftAssert softAssert;

   
    public BasePage(WebDriver driver, int timeOut) {
        this.driver = driver;
        this.timeOut = timeOut;
        softAssert = new SoftAssert();
    }

    protected void waitPage($ element, String pageName) {
        var message = String.format("Waiting %s page to load ", pageName);
        logs.info(message);
        element.waitForVisibility(timeOut);

        message = String.format("%s loaded successfully ", pageName);
        logs.info(message);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
