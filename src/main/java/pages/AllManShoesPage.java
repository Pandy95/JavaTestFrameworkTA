package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllManShoesPage extends BasePage{
    public AllManShoesPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//h3[@class='sc-eCstlR eUervm es-product-name']")
    private List<WebElement> allElements;

    public  List<WebElement> getAllElements(){
        return allElements;
    }
}
