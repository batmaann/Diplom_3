import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class TransitionsTest {
    ChromeDriver driver;


    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }


    @Test
    public void testLogoutPersonalAccount() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickAccountButton();
        mainPage.clickButtonConstructor();
        mainPage.waitBurger();

        mainPage.clickAccountButton();
        mainPage.clickMainButton();
        mainPage.waitMain();


    }
}
