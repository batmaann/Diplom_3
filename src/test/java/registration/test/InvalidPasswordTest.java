package registration.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.оbject.LoginPage;
import page.оbject.MainPage;
import page.оbject.RegistorPage;

import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class InvalidPasswordTest {
    ChromeDriver driver;
    String name = RandomStringUtils.randomAlphabetic(6);
    String email = "test@" + RandomStringUtils.randomAlphabetic(6) + ".ru";
    String password = RandomStringUtils.randomAlphabetic(5);

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }


    @Test
    public void registrationWithValidPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistorPage registorPage = new RegistorPage(driver);
        mainPage.clickAccountButton();
        loginPage.findTextRegisterFeild();
        registorPage.waitLoadPage();
        registorPage.clickButtonRegister();
        registorPage.register(name, email, password);
        loginPage.findTextIncorrectPassword();
    }

    @After
    public void teardown() {
        driver.quit();

    }


//    private void setUpChrome() {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        ChromeDriverService service = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("chromedriver-mac-arm64/chromedriver"))
//                .build();
//
//        ChromeOptions options = new ChromeOptions()
//                .setBinary("/Applications/Google Chrome.app/Contents/MacOS")
//                .addArguments("--remote-alLow-origins=*");
//
//        driver = new ChromeDriver(service, options);
//    }


}
