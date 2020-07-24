import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CoffeePage;

public class CoffeeTest extends WebDriverSettings {
    protected CoffeePage coffeePage;

    @Test
    public void containsWordTests(){
        coffeePage = new CoffeePage(driver);
        coffeePage.searchLineChecking();
        coffeePage.checkListOfItems("ambassador");
    }
}
