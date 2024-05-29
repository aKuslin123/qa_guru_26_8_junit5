package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HamburgerMenuComponent {

    private SelenideElement hamburgerMenuButton = $("[data-selenium='header-hamburger-menu']"),
            currencyContainerHamburgerMenu = $("[data-selenium='hamburger-menu-dropdown-container']")
                    .$("[data-selenium='currency-container-selected-currency']");

    public void openHamburgerMenu() {
        hamburgerMenuButton.click();
    }

    public void checkCurrencyInHamburgerMenu(String currencyAbbreviation, String currencyName) {
        currencyContainerHamburgerMenu.shouldHave(text(currencyAbbreviation + " " + currencyName));
    }
}