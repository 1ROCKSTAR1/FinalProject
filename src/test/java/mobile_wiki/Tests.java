package mobile_wiki;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import wikipages.MainScreen;

import static com.codeborne.selenide.Selenide.back;


@Tag("mobile_wiki")
public class Tests extends BaseTest {

    MainScreen mainScreen = new MainScreen();

    @Test
    @DisplayName("Проверка что результат не пустой")
    void searchEmptyTest() {
        back();
        boolean actualResult = mainScreen
                .clickOnFakeSearchField()
                .sendSearchPhraseInRealSearchField("NASCAR")
                .checkAllResultsNotEmpty();

        Assertions.assertTrue(actualResult);
    }

    @Test
    @DisplayName("Проверка хэдера вкладки 'saved' ")
    void savedTabTestPOM() {
        back();
        String expectedHeader = mainScreen
                .clickOnSavedTab()
                .getSavedTabHeader();

        Assertions.assertEquals("Saved", expectedHeader);
    }

    @Test
    @DisplayName("Проверка хэдера вкладки 'settings' ")
    void savedSettingsTestPOM() {
        back();
        String expectedHeader = mainScreen
                .clickOnMoreTab()
                .clickOnSettings()
                .getSettingsTabHeader();

        Assertions.assertEquals("Settings", expectedHeader);
    }

    @Test
    @DisplayName("Проверка switch 'show link previews' ")
    void showPreviewTestPOM() {
        back();
        boolean expectedShowPreviewCondition = mainScreen
                .clickOnMoreTab()
                .clickOnSettings()
                .checkShowPreviewIsTrue();

        Assertions.assertTrue(expectedShowPreviewCondition);
    }

    @Test
    @DisplayName("Проверка switch 'prefer offline' ")
    void preferOfflineTestPOM() {
        back();
        boolean expectedPreferOfflineCondition = mainScreen
                .clickOnMoreTab()
                .clickOnSettings()
                .scrollToPreferOffline()
                .checkPreferOfflineIsFalse();

        Assertions.assertTrue(expectedPreferOfflineCondition);
    }
}
