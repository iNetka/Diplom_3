package site.stellarburgers.nomoreparties.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    WebDriver driver;

    private By mainButton = By.xpath(".//div/header/nav/div[@class]");
    //главная кнопка

    private By enterAccountButton = By.xpath("//button[contains(.,'Войти в аккаунт')]");

    private By accountProfile = By.xpath(".//nav/a/p[@class=\"AppHeader_header__linkText__3q_va ml-2\"]");
    //личный кабинет

    private By emailField = By.xpath("//input[@type='text' and contains(@class, 'input__textfield')]");
    //email

    private By passwordField = By.xpath(".//div/div/input[@type=\"password\"]");
    //пароль

    private By comeInField = By.className("button_button_type_primary__1O7Bx");
    //вход

    private By registerField = By.xpath(".//div/p/a[@href=\"/register\"]");
    //регистрация


    private By sectionBuns = By.xpath("//div[contains(@class,'tab_tab_type_current') and .//span[text()='Булки']]");
    //раздел "булки"
    private By sectionSauce = By.xpath(".//div/span[text() = 'Соусы']");
    //раздел "соусы"
    private By sectionFilling = By.xpath(".//div/span[text() = 'Начинки']");
    //раздел "начинки"

    private By selectedSectionBuns = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Булки']");
    //выбран раздел "соусы"
    private By selectedSectionSauce = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Соусы']");
    //выбран раздел "начинки"
    private By constructorTitle = By.xpath("//h1[contains(.,'Соберите бургер')]");

    private By selectedSectionFilling = By.xpath(".//div[contains(@class, 'tab_tab_type_current')]//span[text() = 'Начинки']");
    //локатор на кнопку "Конструктор"
    private By buttonConstructor = By.xpath(".//nav//a/p[text() = 'Конструктор']");
    //кнопка "Конструктор"
    private By fieldBurger = By.xpath(".//h1[@class = \"text text_type_main-large mb-5 mt-10\"]");


    //методы для главной страницы

    @Step("Клик по элементу аккаунта")
    public void clickAccountButton() {
        driver.findElement(accountProfile).click();
    }
    @Step("Клик по элементу email")
    public void clickEmailButton() {
        driver.findElement(emailField).click();
    }
    @Step("Клик по элементу регистрация")
    public void clickRegisterFieldButton() {
        driver.findElement(registerField).click();
    }
    @Step("Ожидание элемента")
    public void waitLoadPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(mainButton));
    }

    public boolean checkIfConstructorTitleVisible(){
        return driver.findElement(constructorTitle).isDisplayed();
    }

    @Step("Надпись Соберите бургер")
    public void waitBurger() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fieldBurger));
    }

    @Step("Шаг нажатие кнопки")
    public void clickMainButton() {
        driver.findElement(mainButton).click();
    }
    @Step("Шаг ожидание поля главной")
    public void waitMain() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(mainButton));
    }


    @Step("Ожидание перехода в раздел Соусы")
    public void waitSauce() {
        By sauceHeader = By.xpath("//h2[text()='Соусы']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceHeader));

    }

    @Step("Ожидание перехода в раздел Начинки")
    public void waitFilling() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedSectionFilling));
    }

    @Step("Клик по кнопке войти в аккаунт")
    public void clickAccountButtonMainPage() {
        driver.findElement(enterAccountButton).click();
    }

    public boolean checkFillings(){
        return driver.findElement(sectionFilling).isDisplayed();
    }

    public boolean checkSauce(){
        return driver.findElement(sectionSauce).isDisplayed();
    }

    public boolean checkBuns(){
        return driver.findElement(sectionBuns).isDisplayed();
    }

    @Step("Клик по разделу Булки")
    public void clickSectionBuns() {
        driver.findElement(sectionBuns).click();
        waitBuns();
    }

    @Step("Клик по разделу Соусы")
    public void clickSectionSauce() {
        driver.findElement(sectionSauce).click();
        waitSauce();
    }

    @Step("Клик по разделу Начинки")
    public void clickSectionFilling() {
        driver.findElement(sectionFilling).click();
        waitFilling();
    }

    @Step("Ожидание раздела булки")
    public void waitBuns() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedSectionBuns));
    }
    @Step("Переключение между разделами")
    public void switchingLogic() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSectionFilling();
        mainPage.waitFilling();

        mainPage.clickSectionSauce();
        mainPage.waitSauce();

        mainPage.clickSectionBuns();
        mainPage.waitBuns();

    }

    @Step("Клик по конструктору")
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

}