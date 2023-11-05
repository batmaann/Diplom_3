package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;



    private By incorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    private By fieldName = By.xpath(".//fieldset[1]//div/input");
    private By fieldPassword = By.xpath(".//div/input[@name = 'Пароль']");

    private By userAlreadyRegistered = By.xpath(".//p[text() = 'Такой пользователь уже существует']");

    //private By incorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");
    //локатор кнопка войти
    private By buttonSignIn = By.xpath(".//button[text() = 'Войти']");





    //Метод ожидания появления текста о существовании пользователя при повторной регистрации
    public void waitTextUserAlreadyRegistered() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(userAlreadyRegistered));
    }

    //Метод поиска текста "Такой пользователь уже существует" при повторной регистрации такого же пользователя
    public String findTextUserAlreadyRegistered() {
        waitTextUserAlreadyRegistered();
        return driver.findElement(userAlreadyRegistered).getText();
    }
    //Метод для поиска текста "Некорректный пароль" при вводе пароля менее 6 символов
    public String findTextIncorrectPassword() {
        return driver.findElement(incorrectPassword).getText();
    }


    //Метод для ввода значения в поле Имя
    public void setFieldName(String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(name);
    }


    //Метод для ввода значения в поле Пароль
    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    //Метод для клика по кнопке "Войти"
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }








}
