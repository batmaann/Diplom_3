package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    WebDriver driver;

    private By mainButton = By.xpath(".//div/header/nav/div[@class]");
    //главная кнопка

    private By accountProfile = By.xpath(".//nav/a/p[@class=\"AppHeader_header__linkText__3q_va ml-2\"]");
    //личный кабинет

    private By emailField = By.xpath("text input__textfield text_type_main-default");

    //поле почты

    private By passwordField = By.xpath(".//div/div/input[@type=\"password\"]");
    //поле пароля

    private By comeInField = By.className("button_button_type_primary__1O7Bx");
    //поле для входа

    private By registerField = By.xpath(".//div/p/a[@href=\"/register\"]");
    //поле регистрации
























    //методы для главной страницы





    public void clickAccountButton() {
        driver.findElement(accountProfile).click();
    }

    public void clickEmailButton() {
        driver.findElement(emailField).click();
    }
    public void clickRegisterFieldButton() {
        driver.findElement(registerField).click();
    }
    public void waitLoadPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(mainButton));
    }















}
