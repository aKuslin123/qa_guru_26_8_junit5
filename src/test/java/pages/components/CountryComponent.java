package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CountryComponent {

    private SelenideElement languageSelector = $("[data-selenium='language-container-selected-language']"),
            languagePopUp = $("[data-selenium='language-popup']");

    public void selectLanguage(String language) {
        languageSelector.click();
        languagePopUp.$(byText(language)).closest("button").click();
    }
}