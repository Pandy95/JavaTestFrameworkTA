package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='page-header__HeaderTitle-qbclzk-3 jOZkgn']" )
    private WebElement header;

    @FindBy(xpath = "//div[@id='cookiebanner']")
    private WebElement cookieBanner;

    @FindBy(xpath = "//button[@id='cookiebotDialogOkButton']")
    private WebElement cookiebotDialogOkButton;

    @FindBy(xpath = "//header/div/div/ul/li/a[@href='https://www.cropp.com/ua/uk/vzuttia']")
    private WebElement tabShoes;

    @FindBy(xpath = "//header/div/div/ul/li/ul/div/a[@href='https://www.cropp.com/ua/uk/vzuttia/cholovikam']")
    private WebElement tabShoesAllMen;

    @FindBy(xpath = "//span[@data-testid='store-switcher']")
    private WebElement languageButton;

    public void openHomePage(String url) {
        driver.get(url);
    }
    public void coockieAccept(){
        if (cookieBanner.isDisplayed())cookiebotDialogOkButton.click();
    }
    public boolean isRightHeaderVisible(){
        return header.isDisplayed();
    }
    public void moveToElement(){
        new Actions(driver)
                .moveToElement(tabShoes)
                .perform();
    }
    public void clickOnShoesAllMen(){
        tabShoesAllMen.click();
    }

    public void changeLanguage(){
        languageButton.click();
    }
}
