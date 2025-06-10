package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

public class TransitionsTest extends BaseTest{

    @Test
    public void testLogoutPersonalAccount() {
        mainPage.clickAccountButton();
        mainPage.clickButtonConstructor();
        mainPage.waitBurger();
    }

    @Test
    public void testLogoutPersonalAccount2() {
        mainPage.clickAccountButton();
        mainPage.clickMainButton();
        mainPage.waitMain();
    }

}
