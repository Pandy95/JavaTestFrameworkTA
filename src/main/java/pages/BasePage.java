package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@id='cookiebanner']")
    private WebElement cookieBanner;

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    private WebElement cookiebotDialogOkButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void cookieAccept() {
        if (cookieBanner.isDisplayed())cookiebotDialogOkButton.click();
    }


    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

}
