package page.оbject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage {
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    //локатор на кнопку "Выйти"
    private By buttonExit = By.xpath(".//nav//li/button[text() = 'Выход']");

    //методы
    @Step("Шаг ожидания загрузки страницы")
    public void waitLoadPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
    }

    @Step("клик по кнопке выйти")
    public void clickButtonExit() {
        waitLoadPage();
        driver.findElement(buttonExit).click();
    }

}
