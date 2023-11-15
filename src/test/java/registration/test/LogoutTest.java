package registration.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import page.оbject.LoginPage;
import page.оbject.MainPage;
import page.оbject.ProfilePage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class LogoutTest {
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
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.setFieldName("testtestovoch1@test.ru");
        loginPage.setFieldPassword("1234567");
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();//проверка ожидание наличие элементов главной страницы
        mainPage.clickAccountButton();
        profilePage.clickButtonExit();
        mainPage.waitSauce();//проверка ожидание наличие элементов главной страницы
    }
}
