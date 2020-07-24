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

public class CoffeePage extends ProductPage{
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public CoffeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }
    @FindBy(how = How.XPATH, using = "//h1[@class='catalog-heading']")
    private WebElement titleCoffee;

    @FindBy(how = How.XPATH, using = "//a[@class='goods-tile__heading']")
    private List<WebElement> listOfCoffee;

    @FindBy(how = How.XPATH, using = "//input[@id='Ambassador']/following-sibling::label")
    private WebElement checkboxAmbassador;

    public void checkTitleCoffee(String title) {
        this.verifyTitle(title,titleCoffee);
    }

    public void checkListOfItems(String formatWord) {
        this.verifyListOfProducts(formatWord, listOfCoffee);
    }

    public CoffeePage searchLineChecking(){
        checkboxAmbassador.click();
        return this;
    }


}