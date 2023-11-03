package registrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.LoginPage;
import pageObject.MainPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static config.AppConfig.APP_URL;

public class InvalidPasswordTest {
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
    public void registrationWithInvalidPassword()  {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAccountButton();

    }




    @After
    public void teardown(){
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
