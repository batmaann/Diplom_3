package registrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistorPage;

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
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }


    @Test
    public void registrationWithValidPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistorPage registorPage = new RegistorPage(driver);
        mainPage.clickAccountButton();
        WebElement element = driver.findElement(By.xpath(".//div/p/a[@href=\"/register\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        registorPage.waitLoadPage();
        registorPage.clickButtonRegister();
        registorPage.register(name, email, password);
        WebElement invalidElement = driver.findElement(By.xpath(".//p[text() = 'Некорректный пароль']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", invalidElement);
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
