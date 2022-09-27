package stepdefinition;

import classes.Product;
import interfaces.IProduct;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllManShoesPage;
import pages.AllStoresPage;
import pages.BasePage;
import pages.HomePage;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    AllManShoesPage allMenShoesPage;
    PageFactoryManager pageFactoryManager;
    AllStoresPage allStoresPage;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string} page")
    public void userOpenPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);                     
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User accepts cookies")
    public void userAcceptsCookies() {
        homePage.coockieAccept();
    }

    @When("User moves a cursor to the tab menu Shoes")
    public void userMovesACursorToTheTabMenuShoes() {
        homePage.moveToElement();
    }

    @And("User clicks All for men")
    public void userClicksAllForMen() {
        homePage.clickOnShoesAllMen();
        allMenShoesPage = pageFactoryManager.getAllMenShoesPage();
        allMenShoesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);

    }

    @When("User clicks Language button")
    public void userClicksLanguageButton() {
        homePage.changeLanguage();
        allStoresPage = pageFactoryManager.getAllStoresPage();
        allStoresPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User changes location to {string}")
    public void userChangesLocationToLocation(String location) {
        allStoresPage.ChangeLocation(location);
    }

    @Then("User checks that url has changed to {string}")
    public void userChecksThatUrlHasChangedToExpectedUrl(String expectedUrl) {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Then("User checks if products on page contains word {string} more than {string} times")
    public void userChecksIfProductsOnPageContainsWordKeyWordMoreThanTimesTimes(String keyWord, String times) {
        List<WebElement> allProductName = allMenShoesPage.getAllProductName();
        long count = allProductName.stream().filter(element -> element.getText().contains(keyWord)).count();
        assertTrue(count > Integer.parseInt(times));
    }

    @Then("User checks that product page contains word {string} have a price greater than {string}")
    public void userChecksThatProductPageContainsWordNameOfProductHaveAPriceGreaterThanPriceOfProduct(
            String nameOfProduct, String price) {
        allMenShoesPage = pageFactoryManager.getAllMenShoesPage();
        allMenShoesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        List<Product> allProducts = allMenShoesPage.getProductsList
                (allMenShoesPage.getAllProductName(), allMenShoesPage.getAllProductPrice());
        Predicate<Product> byPrice = product -> product.getPrice() < Integer.parseInt(price);
        long count = allProducts.stream().filter(product -> product
                .getName().contains(nameOfProduct))
                .filter(byPrice).count();
        assertEquals(0, count);
    }
}
