package site.stellarburgers.nomoreparties.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;


    //локатор поле Имя
    private By fieldName = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //локатор поле Email
    private By fieldEmail = By.xpath(".//label[text()='Email']/following-sibling::input");
    //локатор поле Пароль
    private By fieldPassword = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    //локатор кнопки "Зарегистрироваться"
    private By buttonRegister = By.xpath(".//a[@class =\"Auth_link__1fOlj\" ]");
    private By buttonSignIn = By.xpath(".//p/a[text() = 'Войти']");


    @Step("Ввод значения в поле Имя")
    public void setFieldName(String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(name);
    }

    @Step("Ввод значения в поле Email")
    public void setFieldEmail(String email) {
        driver.findElement(fieldEmail).click();
        driver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Ввод значения в поле Пароль")
    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клика по кнопке Зарегистрироваться")
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step("Клика по кнопке Войти")
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

    @Step("Ожидание загрузки страницы")
    public void waitLoadPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonRegister));
    }


    @Step("Регистрации пользователя")
    public void register(String name, String email, String password) {
        waitLoadPage();
        setFieldName(name);
        setFieldEmail(email);
        setFieldPassword(password);
        clickButtonRegister();
    }


}