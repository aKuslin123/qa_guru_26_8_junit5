package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CountryComponent;
import pages.components.CurrencyComponent;
import pages.components.HamburgerMenuComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement destinationInput = $("#textInput"),
            checkInBox = $("#check-in-box"),
            occupancyBox = $("[data-element-name='occupancy-box'"),
            searchButton = $("[data-selenium='searchButton']"),
            suggestedDestinationWrapper = $(".Searchbox__wrapper");

    CountryComponent countryComponent = new CountryComponent();
    CurrencyComponent currencyComponent = new CurrencyComponent();
    HamburgerMenuComponent hamburgerMenuComponent = new HamburgerMenuComponent();


    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage selectCurrency(String currency) {

        currencyComponent.selectCurrency(currency);

        return this;
    }

    public MainPage selectDestination(String destination) {
        destinationInput.setValue(destination);
        suggestedDestinationWrapper.$("li").click();
        return this;
    }

    public MainPage closeDateSelector() {
        checkInBox.click();
        return this;
    }

    public MainPage closeOccupancyBox() {
        occupancyBox.click();
        return this;
    }

    public MainPage pressSearch() {
        searchButton.click();
        return this;
    }

    public MainPage openHamburgerMenu() {
        hamburgerMenuComponent.openHamburgerMenu();
        return this;
    }

    public MainPage selectLanguage(String language) {
        countryComponent.selectLanguage(language);
        return this;
    }

    public MainPage checkCurrencyName(String currency) {
        currencyComponent.checkCurrencyName(currency);

        return this;
    }

    public MainPage checkCurrencyInHamburgerMenu(String currencyAbbreviation, String currencyName) {
        hamburgerMenuComponent.checkCurrencyInHamburgerMenu(
                currencyAbbreviation, currencyName);
        return this;
    }
}
