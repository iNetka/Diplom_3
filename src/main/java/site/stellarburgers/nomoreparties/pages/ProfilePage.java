package site.stellarburgers.nomoreparties.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ProfilePage {
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    //локатор на кнопку "Выйти"
    private By buttonExit = By.xpath(".//nav//li/button[text() = 'Выход']");
    private By profilePageTitle = By.xpath("//*[@id=\"root\"]/div/main/div/nav/p");
    private By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");


    @Step("Ожидание загрузки страницы")
    public void waitLoadPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
    }

    @Step("Клик по кнопке выйти")
    public void clickButtonExit() {
        waitLoadPage();
        driver.findElement(buttonExit).click();
    }

    @Step("Проверка нахождения в личном кабинете")
    public boolean checkIfOnProfilePage() {
        return driver.findElement(profilePageTitle).isDisplayed();
    }

    @Step("Переход в конструктор")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

}