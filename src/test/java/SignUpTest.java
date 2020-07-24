import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpTest extends WebDriverSettings {
    protected BasePage mainPage;
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void Init(){
        driver.get("http://rozetka.com.ua/");
        mainPage = new BasePage(driver);
    }
    //go to signUp
    @Test
    public void emptyNameSignUp(){

        signInPage = mainPage.goToSignIn();
        signUpPage = signInPage.goToSignUp();
        signUpPage.failRegistration("", "v.abashdajs@gmail.com", "u6h4fks");
        signUpPage.errorMessage("Введите свое имя на кириллице");
    }
}
