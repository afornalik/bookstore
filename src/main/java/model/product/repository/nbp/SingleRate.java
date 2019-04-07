package model.product.repository.nbp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SingleRate {

    @JsonProperty(value="currency")
    private String currency;

    @JsonProperty(value="code")
    private String code;

    @JsonProperty(value="bid")
    private Double currencySellCourse;

    @JsonProperty(value="ask")
    private  Double currencyBuyCourse;

    @JsonCreator
    public SingleRate(@JsonProperty(value="currency") String currency,
                      @JsonProperty(value="code") String code,
                      @JsonProperty(value="bid") Double currencySellCourse,
                      @JsonProperty(value="ask") Double currencyBuyCourse) {
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

    @Override
    public String toString() {
        return "SingleRate{" +
                "currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", currencySellCourse=" + currencySellCourse +
                ", currencyBuyCourse=" + currencyBuyCourse +
                '}'+"\n---------------------------------------------------\n";
    }
}
