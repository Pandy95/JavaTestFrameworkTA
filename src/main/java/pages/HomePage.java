package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='page-header__HeaderTitle-qbclzk-3 jOZkgn']" )
    private WebElement header;

    public void openHomePage(String url) {
        driver.get(url);
    }


}
