package registrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;
import pageObject.RegistorPage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class LogoutTest {
    ChromeDriver driver;
    String name = RandomStringUtils.randomAlphabetic(6);
    String email = "test@" + RandomStringUtils.randomAlphabetic(6) + ".ru";
    String password = RandomStringUtils.randomAlphabetic(6);

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
    public void testLogoutPersonalAccount(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.setFieldName("testtestovoch1@test.ru");
        loginPage.setFieldPassword("1234567");
        loginPage.clickButtonSignIn();
        mainPage.clickAccountButton();
        profilePage.clickButtonExit();

    }
}
