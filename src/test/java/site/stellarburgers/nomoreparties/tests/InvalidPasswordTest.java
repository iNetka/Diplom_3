package site.stellarburgers.nomoreparties.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class InvalidPasswordTest extends BaseTest {
    private final static String NAME = RandomStringUtils.randomAlphabetic(6);
    private final static String EMAIL = "pypypy@" + RandomStringUtils.randomAlphabetic(6) + ".ru";
    private final static String PASSWORD = RandomStringUtils.randomAlphabetic(5);

    @Test
    public void registrationWithValidPassword() {
        mainPage.clickAccountButton();
        loginPage.findTextRegisterField();
        registerPage.waitLoadPage();
        registerPage.clickButtonRegister();
        registerPage.register(NAME, EMAIL, PASSWORD);
        loginPage.findTextIncorrectPassword();
    }

}
