import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.MainPage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class SwitchToPersonaFieldsTest {
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
    public void switchingFields() {
        MainPage mainPage = new MainPage(driver);
        mainPage.switchingLogic();

    }

    @After
    public void teardown() {
        driver.quit();

    }


}
