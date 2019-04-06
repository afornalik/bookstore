package model.product.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleRate {

    @JsonProperty(value="currency")
    private String currency;

    @JsonProperty(value="code")
    private String code;

    @JsonProperty(value="ask")
    private Double currencySellCourse;

    @JsonProperty(value="bid")
    private  Double currencyBuyCourse;

    public SingleRate(String currency, String code, Double currencySellCourse, Double currencyBuyCourse) {
        this.currency = currency;
        this.code = code;
        this.currencySellCourse = currencySellCourse;
        this.currencyBuyCourse = currencyBuyCourse;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public Double getCurrencySellCourse() {
        return currencySellCourse;
    }

    public Double getCurrencyBuyCourse() {
        return currencyBuyCourse;
    }
}
