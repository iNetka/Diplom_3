package site.stellarburgers.nomoreparties.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.nomoreparties.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransitionsTest extends BaseTest {

    private final static String NAME = faker.name().firstName();
    private final static String EMAIL = faker.internet().emailAddress();
    private final static String PASSWORD = faker.internet().password(8, 10, true, true, true);
    private static String token;

    @Before
    public void createUser() {
        User user = new User(NAME, EMAIL, PASSWORD);
        assertEquals(apiUser.registerUser(user).getStatusCode(), 200);
        token = user.getAccessToken();
    }

    @Test
    public void testLoginCabinet() {
        mainPage.clickAccountButton();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
    }

    @Test
    public void testLoginButtonEnterAccount() {
        mainPage.clickAccountButtonMainPage();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
    }

    @Test
    public void testLoginRegistration() {
        mainPage.clickAccountButton();
        registerPage.waitLoadPage();
        registerPage.clickButtonRegister();
        registerPage.clickButtonSignIn();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
    }

    @Test
    public void testLoginRecoverPassword() {
        mainPage.clickAccountButton();
        loginPage.clickRecoverPassword();
        registerPage.clickButtonSignIn();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
    }

    @Test
    public void testGoToCabinet() {
        mainPage.clickAccountButton();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
        mainPage.clickAccountButton();
        assertTrue(profilePage.checkIfOnProfilePage());
    }

    @Test
    public void testGoToCabinetAndToConstructor() {
        mainPage.clickAccountButton();
        loginPage.setFieldName(EMAIL);
        loginPage.setFieldPassword(PASSWORD);
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
        mainPage.clickAccountButton();
        assertTrue(profilePage.checkIfOnProfilePage());
        profilePage.clickConstructor();
        mainPage.checkIfConstructorTitleVisible();
    }

    @After
    public void deleteUser() {
        assertEquals(apiUser.delete(token).getStatusCode(), 202);
    }


}
