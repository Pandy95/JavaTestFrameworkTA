package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AllManShoesPage;
import pages.HomePage;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    AllManShoesPage allMenShoesPage;
    PageFactoryManager pageFactoryManager;

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

    @Then("User checks whether {string} is written in the header of the site")
    public void userChecksHeader() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isRightHeaderVisible();
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

    @Then("User checks if the elements on page contains word {string} more than ten times")
    public void serChecksIfTheElementsOnPageContainsWordKeyWordMoreThanTenTimes(String keyWord) {
        List<WebElement> allElements = allMenShoesPage.getAllElements();
        long count = allElements.stream().filter(element -> element.getText().contains(keyWord)).count();

//        int count = 0;
//        for (WebElement element : allElements){
//            if (element.getText().contains(keyWord)){
//                count +=1;
//            }
//        }

        assertTrue(count > 10);
    }
}
