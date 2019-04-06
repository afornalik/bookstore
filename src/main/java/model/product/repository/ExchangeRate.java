package model.product.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExchangeRate {

    @JsonProperty(value = "table")
    private String table;

    @JsonProperty(value = "tradingDate")
    private String tradingDate;

    @JsonProperty(value = "effectiveDate")
    private String effectiveDate;

    @JsonProperty(value = "rates")
    private List<SingleRate> rates;

    public ExchangeRate(String table, String tradingDate, String effectiveDate, List<SingleRate> rates) {
        this.table = table;
        this.tradingDate = tradingDate;
        this.effectiveDate = effectiveDate;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public List<SingleRate> getRates() {
        return rates;
    }
}
