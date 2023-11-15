package page.оbject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private final By incorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    private final By fieldName = By.xpath(".//fieldset[1]//div/input");
    private final By fieldPassword = By.xpath(".//div/input[@name = 'Пароль']");

    private final By userAlreadyRegistered = By.xpath(".//p[text() = 'Такой пользователь уже существует']");

    //private By incorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    private final By buttonSignIn = By.xpath(".//button[text() = 'Войти']");

    private final By buttonRegister = By.xpath(".//div/p/a[@href=\"/register\"]");

    //Метод ожидания появления текста о существовании пользователя при повторной регистрации
    @Step("Шаг ожидания появления текста")
    public void waitTextUserAlreadyRegistered() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(userAlreadyRegistered));
    }

    //Метод поиска текста "Такой пользователь уже существует" при повторной регистрации такого же пользователя
    @Step("Поиск текста \"Такой пользователь уже существует\"")
    public String findTextUserAlreadyRegistered() {
        waitTextUserAlreadyRegistered();
        return driver.findElement(userAlreadyRegistered).getText();
    }

    @Step("Шаг для поиска текста \"Некорректный пароль\" при вводе пароля менее 6 символов")
    public void findTextIncorrectPassword() {
        WebElement invalidElement = driver.findElement(incorrectPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", invalidElement);
    }

    @Step("Шаг для поиска текста зарегистрироваться")
    public void findTextRegisterFeild() {
        WebElement element = driver.findElement(buttonRegister);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @Step("Шаг для ввода значения в поле Имя")
    public void setFieldName(String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(name);
    }


    @Step("Шаг для ввода значения в поле Пароль")
    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Шаг для клика по кнопке \"Войти\"")
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

}