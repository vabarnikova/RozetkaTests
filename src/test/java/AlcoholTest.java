import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AlcoholPage;
import pages.CoffeePage;

public class AlcoholTest extends WebDriverSettings {
    protected AlcoholPage alcoholPage;
    protected CoffeePage coffeePage;

    @BeforeClass
    public void init() {
        driver.get("https://rozetka.com.ua/alkoholnie-napitki-i-produkty/c4626923/");
        alcoholPage = new AlcoholPage(driver);
    }

    @Test
    public void titleChekcingTest() {
        alcoholPage.verifyAlcoholTitle("Алкогольные напитки и продукты");
    }

    @Test
    public void titleCoffeeTest() {
        coffeePage = alcoholPage.clickCoffee();
        coffeePage.checkTitleCoffee("Кофе");
    }
}
