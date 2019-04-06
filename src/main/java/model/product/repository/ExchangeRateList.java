package model.product.repository;

import java.util.List;

public class ExchangeRateList {
    private List<ExchangeRate> exchangeRates;

    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public ExchangeRateList(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}
