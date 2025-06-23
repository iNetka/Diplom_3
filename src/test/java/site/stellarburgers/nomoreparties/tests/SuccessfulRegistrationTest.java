package site.stellarburgers.nomoreparties.tests;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import site.stellarburgers.nomoreparties.api.Credentials;


import static org.junit.Assert.*;
import static site.stellarburgers.nomoreparties.config.AppConfig.APP_URL;

public class SuccessfulRegistrationTest extends BaseTest {

    private final static String NAME = faker.name().firstName();
    private final static String EMAIL = faker.internet().emailAddress();
    private final static String PASSWORD = faker.internet().password(8, 16, true, true, true);

    @Test
    public void registrationWithValidPassword() {

        mainPage.clickAccountButton();
        registerPage.waitLoadPage();
        registerPage.clickButtonRegister();
        registerPage.register(NAME, EMAIL, PASSWORD);
        assertTrue(loginPage.checkIfOnLoginPage());
    }

    @After
    public void deleteUser() {
        try {
            // 1. Логинимся
            Credentials creds = new Credentials(EMAIL, PASSWORD);
            Response loginResponse = apiUser.login(creds);

            if (loginResponse.statusCode() != 200) {
                System.out.println("Login failed! Status: " + loginResponse.statusCode() +
                        ", Body: " + loginResponse.asString());
                return;
            }

            // 2. Удаляем пользователя
            Response deleteResponse = apiUser.delete(loginResponse);

            if (deleteResponse == null) {
                fail("Delete failed - no access token");
                return;
            }

            int statusCode = deleteResponse.statusCode();
            System.out.println("Delete status: " + statusCode);


        } catch (Exception e) {
            System.out.println("Error in deleteUser: " + e.getMessage());
            e.printStackTrace();
        }
    }

}