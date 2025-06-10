package site.stellarburgers.nomoreparties.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.nomoreparties.pages.LoginPage;
import site.stellarburgers.nomoreparties.pages.MainPage;
import site.stellarburgers.nomoreparties.pages.ProfilePage;
import site.stellarburgers.nomoreparties.pages.RegisterPage;

import java.time.Duration;

import static site.stellarburgers.nomoreparties.config.AppConfig.APP_URL;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected ProfilePage profilePage;
    protected RegisterPage registerPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver(); // все ок
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(11));
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        registerPage = new RegisterPage(driver);

        driver.get(APP_URL);

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
