package data;

public enum Currency {
    RUB("₽", "Российский рубль"),
    USD("USD", "Доллар США"),
    EUR("€", "Евро");

    private final String currencyCode;
    private final String currencyFullName;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getCurrencyFullName() {
        return currencyFullName;
    }

    Currency(String currencyCode, String currencyFullName) {
        this.currencyCode = currencyCode;
        this.currencyFullName = currencyFullName;
    }
}
