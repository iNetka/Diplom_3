package site.stellarburgers.nomoreparties.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelect {

    public static WebDriver setDriver(String browserName){
        switch (browserName){
            case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

}