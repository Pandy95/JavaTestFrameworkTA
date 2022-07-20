package stepdefinition;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;

    HomePage homePage;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();

    }

}
