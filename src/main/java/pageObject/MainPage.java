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



    private By sectionBuns = By.xpath(".//div/span[text() = 'Булки']");
    //раздел "соусы"
    private By sectionSauce = By.xpath(".//div/span[text() = 'Соусы']");
    //раздел "начинки"
    private By sectionFilling = By.xpath(".//div/span[text() = 'Начинки']");

    //раздел "булки"
    private By selectedSectionBuns = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Булки']");
    // локатор выбран раздел "соусы"
    private By selectedSectionSauce = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Соусы']");
    // локатор выбран раздел "начинки"
    private By selectedSectionFilling = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Начинки']");

    //локатор на кнопку "Конструктор"
    private By buttonConstructor = By.xpath(".//nav//a/p[text() = 'Конструктор']");
    private By fieldBurger = By.xpath(".//h1[@class = \"text text_type_main-large mb-5 mt-10\"]");




























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


    //ожидание надписи Собирите бургер
    public void waitBurger() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(fieldBurger));
    }



    public void clickMainButton() {
        driver.findElement(mainButton).click();
    }
    public void waitMain() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(mainButton));
    }







    //Метод ожидания перехода к элементу "Соусы"
    public void waitSauce() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedSectionSauce));
    }

    //Метод ожидания перехода к элементу "Начинки"
    public void waitFilling() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedSectionFilling));
    }

    //Метод для клика по разделу "Булки"
    public void clickSectionBuns() {
        driver.findElement(sectionBuns).click();
        waitBuns();
    }

    //Метод для клика по разделу "Соусы"
    public void clickSectionSauce() {
        driver.findElement(sectionSauce).click();
        waitSauce();
    }

    //Метод для клика по разделу "Начинки"
    public void clickSectionFilling() {
        driver.findElement(sectionFilling).click();
        waitFilling();
    }

    //Метод ожидания подсветки раздела булки
    public void waitBuns() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(selectedSectionBuns));
    }
    public void switchingLogic(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSectionFilling();
        mainPage.waitFilling();

        mainPage.clickSectionSauce();
        mainPage.waitSauce();

        mainPage.clickSectionBuns();
        mainPage.waitBuns();

    }
    //клик по конструктору
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }















}
