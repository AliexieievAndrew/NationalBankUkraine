package comw.example.user.Currency;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class CurrencyData {
    @SerializedName("r030")
    @Expose
    private Integer r030;
    @SerializedName("txt")
    @Expose
    private String txt;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("cc")
    @Expose
    private String cc;
    @SerializedName("exchangedate")
    @Expose
    private String exchangedate;

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    // name of the currency
    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    // currency rate
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    // short currency name
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

}
