package site.stellarburgers.nomoreparties.tests;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import site.stellarburgers.nomoreparties.api.ApiUser;
import site.stellarburgers.nomoreparties.pages.LoginPage;
import site.stellarburgers.nomoreparties.pages.MainPage;
import site.stellarburgers.nomoreparties.pages.ProfilePage;
import site.stellarburgers.nomoreparties.pages.RegisterPage;

import java.time.Duration;

import static site.stellarburgers.nomoreparties.config.AppConfig.APP_URL;
import static site.stellarburgers.nomoreparties.config.BrowserSelect.setDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MainPage mainPage;
    protected ProfilePage profilePage;
    protected RegisterPage registerPage;
    protected static Faker faker = new Faker();
    protected static ApiUser apiUser = new ApiUser();

    @Before
    public void setUp() {
        driver = setDriver("chrome");

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
