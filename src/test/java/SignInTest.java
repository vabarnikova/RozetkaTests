import core.WebDriverSettings;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SignInPage;
import pages.SignUpPage;

public class SignInTest extends WebDriverSettings {
    protected SignInPage signInPage;
    protected SignUpPage signUpPage;
    protected BasePage mainPage;

    @BeforeClass
    public void Initial() {
        driver.get("http://rozetka.com.ua/");
        mainPage = new BasePage(driver);
        signInPage = mainPage.goToSignIn();
    }
    @Test
    public void incorrectAuthTest() {
        signInPage.inputAllKeys("smt", "4g4h44ys");
        signInPage.incorrectEmailField("#fee8e8");
    }

    @Test
    public void emptyPasswdTest() {
        signInPage.inputAllKeys("smt", "");
        signInPage.incorrectPasswdField("#fee8e8");
    }


//go to signUp
//    @Test
//    public void emptyNameSignUp(){
//        signUpPage = signInPage.registrationButton();
//        signUpPage.failRegistration("", "v.abashdajs@gmail.com", "u6h4fks");
//        signUpPage.errorMessage("Введите свое имя на кириллице");
//    }
}
