package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    protected WebDriver driver;
    private final Wait<WebDriver> waits;


    public ProductPage(WebDriver driver){
        driver = driver;
        waits = new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
    }

    public void verifyTitle(String expTitle, WebElement actTitle) {
        waits.until(ExpectedConditions.visibilityOf(actTitle));
        String coffeeT = actTitle.getText();
        Assert.assertEquals(coffeeT, expTitle);
    }

    public void verifyListOfProducts(String searchWord, List<WebElement> listOfEl ){
        int i = 0;
        List<String> currentResult = new ArrayList<String>();
        List<WebElement> actualResult = listOfEl;
        waits.until(ExpectedConditions.visibilityOfAllElements(listOfEl));
        for (WebElement listOfFormat : actualResult) {
            currentResult.add(listOfFormat.getText().toLowerCase());
            System.out.println(currentResult);
            System.out.println(currentResult.get(i).contains(searchWord));
            Assert.assertTrue(currentResult.get(i).contains(searchWord));
            i++;
        }
    }
}
