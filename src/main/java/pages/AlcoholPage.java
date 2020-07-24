package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlcoholPage extends ProductPage{
    protected WebDriver driver;
    private final Wait<WebDriver> waits;

    public AlcoholPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    @FindBy(how = How.XPATH, using = "//h1[@class='portal__heading']")
    private WebElement heading;

    @FindBy(how = How.XPATH, using = "//li[@class='tile-cats__item']/a[@title='Кофе']")
    private WebElement coffeeButton;

    public void verifyAlcoholTitle(String title) {
        this.verifyTitle(title, heading);
    }

    public CoffeePage clickCoffee() {
        coffeeButton.click();
        return new CoffeePage(driver);
    }


}
