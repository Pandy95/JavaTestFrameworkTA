package manager;

import org.openqa.selenium.WebDriver;
import pages.AllManShoesPage;
import pages.AllStoresPage;
import pages.HomePage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public HomePage getHomePage(){return new HomePage(driver);}

    public AllManShoesPage getAllMenShoesPage(){
        return new AllManShoesPage(driver);
    }

    public AllStoresPage getAllStoresPage(){
        return new AllStoresPage(driver);
    }
}
