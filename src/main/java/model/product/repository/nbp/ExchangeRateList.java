package model.product.repository.nbp;

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
