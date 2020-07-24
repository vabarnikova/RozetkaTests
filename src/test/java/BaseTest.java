import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.BasePage;
import pages.SignInPage;

public class BaseTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;

    @BeforeClass
    public void Initial() {
        driver.get("http://rozetka.com.ua/");
        mainPage = new BasePage(driver);
    }

    @Test
    public void SearchTests() {
        mainPage.clickRozetkaSearch("ноутбук");
        mainPage.checkListOfItems("ноутбук");

    }

    @Test
    public void incorrectAuthTest() {
        signInPage = mainPage.goToSignIn();
        signInPage.inputAllKeys("smt", "4g4h44ys");
        signInPage.incorrectEmailField("#fee8e8");
    }

}
