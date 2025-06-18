package site.stellarburgers.nomoreparties.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

import java.time.Duration;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    private final By enterLabel = By.xpath("//h2[contains(.,'Вход')]");

    private final By incorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    private final By fieldName = By.xpath(".//fieldset[1]//div/input");
    private final By fieldPassword = By.xpath(".//div/input[@name = 'Пароль']");

    private final By userAlreadyRegistered = By.xpath(".//p[text() = 'Такой пользователь уже существует']");

    private final By buttonSignIn = By.xpath(".//button[text() = 'Войти']");

    private final By buttonRegister = By.xpath(".//div/p/a[@href=\"/register\"]");
    private final By recoverPasswordButton = By.xpath("//a[contains(.,'Восстановить пароль')]");

    @Step("Ожидание появления текста")
    public void waitTextUserAlreadyRegistered() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAlreadyRegistered));
    }

    @Step("Нажать кнопку 'Восстановить пароль'")
    public void clickRecoverPassword() {
        driver.findElement(recoverPasswordButton).click();
    }

    public boolean checkIfOnLoginPage(){
        return driver.findElement(enterLabel).isDisplayed();

    }

    //Метод поиска текста "Такой пользователь уже существует" при повторной регистрации такого же пользователя
    @Step("Текст Такой пользователь уже существует")
    public String findTextUserAlreadyRegistered() {
        waitTextUserAlreadyRegistered();
        return driver.findElement(userAlreadyRegistered).getText();
    }

    @Step("Текст Некорректный пароль при вводе пароля менее 6 символов")
    public void findTextIncorrectPassword() {
        WebElement invalidElement = driver.findElement(incorrectPassword);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", invalidElement);
    }

    @Step("Текст Зарегистрироваться")
    public void findTextRegisterField() {
        WebElement element = driver.findElement(buttonRegister);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @Step("Ввода текста в поле Имя")
    public void setFieldName(String name) {
        driver.findElement(fieldName).click();
        driver.findElement(fieldName).sendKeys(name);
    }


    @Step("Ввод текста в поле Пароль")
    public void setFieldPassword(String password) {
        driver.findElement(fieldPassword).click();
        driver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

}