package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InvalidPasswordTest extends BaseTest {
    private final static String NAME = faker.name().firstName();
    private final static String EMAIL = faker.internet().emailAddress();
    private final static String PASSWORD = faker.internet().password(1, 5, true, true, true);

    @Test
    public void registrationWithValidPassword() {
        mainPage.clickAccountButton();
        loginPage.findTextRegisterField();
        registerPage.waitLoadPage();
        registerPage.clickButtonRegister();
        registerPage.register(NAME, EMAIL, PASSWORD);
        assertTrue(loginPage.isTextIncorrectPassword());
    }

}
