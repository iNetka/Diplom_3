package site.stellarburgers.nomoreparties.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SuccessfulRegistrationTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(6);
    String email = "pypypy@" + RandomStringUtils.randomAlphabetic(6) + ".ru";
    String password = RandomStringUtils.randomAlphabetic(6);

    @Test
    public void registrationWithValidPassword() {

        mainPage.clickAccountButton();
        WebElement element = driver.findElement(By.xpath(".//div/p/a[@href=\"/register\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        registerPage.waitLoadPage();
        registerPage.clickButtonRegister();
        registerPage.register(name, email, password);

    }

}