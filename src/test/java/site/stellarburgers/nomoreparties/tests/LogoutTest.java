package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

public class LogoutTest extends BaseTest{

    @Test
    public void testLogoutPersonalAccount() {

        mainPage.clickAccountButton();
        loginPage.setFieldName("pypypy@test.ru");
        loginPage.setFieldPassword("12345678910");
        loginPage.clickButtonSignIn();
        mainPage.waitSauce();
        mainPage.clickAccountButton();
        profilePage.clickButtonExit();
    }


}