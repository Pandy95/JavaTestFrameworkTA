package pages;

import interfaces.IProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllManShoesPage extends BasePage implements IProduct {

    public AllManShoesPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h3[@class='sc-eCstlR eUervm es-product-name']")
    private List<WebElement> allProductName;

    @FindBy(xpath = "//section[@class='sc-gsTEea kxkGu es-product-price']")
    private List<WebElement> allProductPrice;

    @Override
    public List<WebElement> getAllProductName() {
        return allProductName;
    }

    @Override
    public List<WebElement> getAllProductPrice(){return allProductPrice;}
}
