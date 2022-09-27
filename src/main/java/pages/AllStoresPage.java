package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllStoresPage extends BasePage {

    public AllStoresPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Polska')]")
    private WebElement poland;

    @FindBy(xpath = "//*[contains(text(), 'Italia')]")
    private WebElement italy;

    public void ChangeLocation(String location) {
        if (location.equals("Poland"))
        {poland.click();}
        if (location.equals("Italy"))
        {italy.click();}
    }
}