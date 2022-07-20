package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, WebElement strst) {
        super(driver);
        this.strst = strst;
    }

    @FindBy(xpath = "strsts" )
    private WebElement strst;
}
