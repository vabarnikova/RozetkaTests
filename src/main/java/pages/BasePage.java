package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;


public class BasePage extends ProductPage{

    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.NAME, using = "search")
    private WebElement inpSearch;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']/span")
    private List<WebElement> listOfgoods;

    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'header-topline__user-link')]")
    private WebElement userLink;

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'menu-categories_type_main')]//a[contains(@href, 'alkoholnie')]")
    private WebElement item;

    public AlcoholPage getPageAlcohol() {
        item.click();
        return new AlcoholPage(driver);
    }

    public void clickRozetkaSearch(String searchWord) {
        inpSearch.click();
        inpSearch.sendKeys(searchWord);
        inpSearch.sendKeys(Keys.ENTER);
    }

    public void checkListOfItems(String formatWord) {
        this.verifyListOfProducts(formatWord,listOfgoods);
    }

    public SignInPage goToSignIn() {
        userLink.click();
        return new SignInPage(driver);
    }
}