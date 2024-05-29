package tests;

import data.Currency;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;
import pages.OffersPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrlStartingWith;

public class ParametrizedTests extends TestBase {

    MainPage mainPage = new MainPage();
    OffersPage offersPage = new OffersPage();

    @EnumSource(Currency.class)
    @ParameterizedTest(name = "Смена валюты на {0}")
    @Tag("MINOR")
    @DisplayName("После смены валюты, выбранная валюта отображается на кнопке селектора")
    void selectedCurrencyShouldBeDisplayedOnCurrencyButton(Currency currency) {
        mainPage.openPage()
                .selectCurrency(currency.getCurrencyFullName())
                .checkCurrencyName(currency.getCurrencyCode());
    }

    static Stream<Arguments> pricesAreDisplayedInSelectedCurrencyAfterChange() {
        return Stream.of(
                Arguments.of(
                        Currency.RUB,
                        "Belgrade"
                ),
                Arguments.of(
                        Currency.EUR,
                        "Toronto"
                ),
                Arguments.of(
                        Currency.USD,
                        "New York"
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Валюта {0} для отелей в {1}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("SMOKE")
    })
    @DisplayName("Цены для разных направлений отображаются в выбранной валюте после ее смены")
    void pricesAreDisplayedInSelectedCurrencyAfterChange(Currency currency, String destination) {
        mainPage.openPage()
                .selectCurrency(currency.getCurrencyFullName())
                .selectDestination(destination)
                .closeDateSelector()
                .closeOccupancyBox()
                .pressSearch();

        offersPage.checkPriceCurrency(currency.getCurrencyCode());
    }

    @Disabled("AGD-33456")
    @CsvFileSource(resources = "/CurrencyFullNames.csv")
    @ParameterizedTest(name = "Валюта {0} {1}")
    @Tag("MINOR")
    @DisplayName("После переключения валюты она отображается в боковом меню")
    void currencyShouldBeDisplayedInHamburgerMenu(String currencyAbbreviation, String currencyFullName) {
        mainPage.openPage()
                .selectCurrency(currencyFullName)
                .openHamburgerMenu()
                .checkCurrencyInHamburgerMenu(currencyAbbreviation, currencyFullName);
    }

    @CsvFileSource(resources = "/LanguagesAndUrls.csv")
    @ParameterizedTest(name = "Адрес https://www.agoda.com{1} для языка {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("SMOKE")
    })
    @DisplayName("После переключения языка страница переключается на версию для выбранного региона")
    void pageUrlShouldBeChangedAccordingToSelectedRegion(String language, String url) {
        mainPage.openPage()
                .selectLanguage(language);
        webdriver().shouldHave(currentFrameUrlStartingWith(baseUrl + url));
    }
}