package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SwitchToPersonaFieldsTest extends BaseTest {

    @Test
    public void checkFilling() {
        mainPage.clickSectionFilling();
        mainPage.waitFilling();
        assertTrue(mainPage.checkFillings());
    }

    @Test
    public void checkSectionSauce() {
        mainPage.clickSectionSauce();
        mainPage.waitSauce();
        assertTrue(mainPage.checkSauce());
    }

    @Test
    public void checkSectionBuns() {
        mainPage.clickSectionSauce();
        mainPage.clickSectionBuns();
        mainPage.waitBuns();
        assertTrue(mainPage.checkBuns());
    }


}
