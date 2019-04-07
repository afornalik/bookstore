package model.product.repository.nbp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.List;


public class ExchangeRate {

    @JsonProperty(value = "table")
    private String table;

    @JsonProperty(value ="no")
    private String no;

    @JsonProperty(value = "tradingDate")
    private String tradingDate;


    @JsonProperty(value = "effectiveDate")
    private String effectiveDate;

    @JsonProperty(value = "rates")
    private List<SingleRate> rates;



    @JsonCreator
    public ExchangeRate(@JsonProperty(value = "table") String table,
                        @JsonProperty(value = "no") String no,
                        @JsonProperty(value = "tradingDate") String tradingDate,
                        @JsonProperty(value = "effectiveDate") String effectiveDate,
                        @JsonProperty(value = "rates") List<SingleRate> rates) {
        this.table = table;
        this.no = no;
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

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "table='" + table + '\'' +
                ", no='" + no + '\'' +
                ", tradingDate='" + tradingDate + '\'' +
                ", effectiveDate='" + effectiveDate + '\n' +
                ", rates=" + rates +
                '}';
    }
}
