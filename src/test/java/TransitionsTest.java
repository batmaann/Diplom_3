import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import page.оbject.LoginPage;
import page.оbject.MainPage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class TransitionsTest {
    ChromeDriver driver;


    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }


    @Test
    public void testLogoutPersonalAccount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        mainPage.clickButtonConstructor();
        mainPage.waitBurger();

    }
    @Test
    public void testLogoutPersonalAccount2() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAccountButton();
        mainPage.clickMainButton();
        mainPage.waitMain();
    }
}
