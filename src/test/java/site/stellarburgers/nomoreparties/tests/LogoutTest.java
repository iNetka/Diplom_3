package site.stellarburgers.nomoreparties.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.nomoreparties.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest{
    private final static String NAME = faker.name().firstName();
    private final static String EMAIL = faker.internet().emailAddress();
    private final static String PASSWORD = faker.internet().password(8, 10, true, true, true);
    private static String token;

    @Before
    public void createUser(){
        User user = new User(NAME,EMAIL,PASSWORD);
        assertEquals(apiUser.registerUser(user).getStatusCode(), 200);
        token = user.getAccessToken();
    }

    @Test
    public void testLogoutPersonalAccount() {
        mainPage.clickAccountButton();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
        mainPage.clickAccountButton();
        profilePage.clickButtonExit();
        assertTrue(loginPage.checkIfOnLoginPage());
    }

    @After
    public void deleteUser(){
        assertEquals(apiUser.delete(token).getStatusCode(), 202);
    }

}