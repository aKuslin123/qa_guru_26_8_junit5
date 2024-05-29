package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OffersPage {
    private SelenideElement hotelsListContainer = $(".hotel-list-container");

    public OffersPage checkPriceCurrency(String currency) {
        hotelsListContainer.shouldBe(visible);
        hotelsListContainer.shouldHave(text(currency));
        return this;
    }
}