package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;

    HomePage homePage;

    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string}")
    public void openPage(final String url){
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks whether {string} is written in the header of the site")
    public void checkHeader() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isRightHeaderVisible();

}
    @After
    public void tearDown() {
        driver.close();
    }

}
