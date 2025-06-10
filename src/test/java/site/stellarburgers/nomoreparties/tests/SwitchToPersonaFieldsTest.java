package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

public class SwitchToPersonaFieldsTest extends BaseTest {

    @Test
    public void switchingFields() {
        mainPage.clickSectionFilling();
        mainPage.waitFilling();

        mainPage.clickSectionSauce();
        mainPage.waitSauce();

        mainPage.clickSectionBuns();
        mainPage.waitBuns();
    }

}
