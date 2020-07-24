package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class WebDriverSettings {
    protected static WebDriver driver;

    @BeforeClass
    @Parameters("navigateTo")
    public void setUp(String navigateTo){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(navigateTo);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }
//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}