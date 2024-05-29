package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CurrencyComponent {

    private SelenideElement currencySelector = $("[data-selenium='currency-container-selected-currency']"),
            currencyPopUp = $("[data-selenium='currency-popup']");

    public void selectCurrency(String currency) {
        currencySelector.click();
        currencyPopUp.$(byText(currency)).closest("button").click();
    }

    public void checkCurrencyName(String currency) {
        currencySelector.shouldHave(text(currency));
    }
}