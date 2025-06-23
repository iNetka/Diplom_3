package site.stellarburgers.nomoreparties.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SwitchToPersonaFieldsTest extends BaseTest {

    @Test
    public void clickBunsSectionButtonTest() {
        mainPage.clickSectionSauce();
        mainPage.clickSectionBuns();
        mainPage.waitBuns();
        assertTrue("Раздел 'Булки' не отображается", mainPage.checkBuns());
    }

    @Test
    public void clickSaucesSectionButtonTest() {
        mainPage.clickSectionSauce();
        mainPage.waitSauce();
        assertTrue("Раздел 'Соусы' не отображается", mainPage.checkSauce());
    }

    @Test
    public void clickFillingsSectionButtonTest() {
        mainPage.clickSectionFilling();
        mainPage.waitFilling();
        assertTrue("Раздела 'Начинки' не отображается", mainPage.checkFillings());
    }
}
