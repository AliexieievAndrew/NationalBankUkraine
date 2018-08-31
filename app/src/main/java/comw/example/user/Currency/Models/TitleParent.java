package comw.example.user.Currency.Models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

public class TitleParent implements ParentObject {

    private List<Object> currencyList;
    private UUID _id;
    private String currencyNameShort, currencyRate;

    public TitleParent(String currencyNameShort, String currencyRate) {
        this.currencyNameShort = currencyNameShort;
        this.currencyRate = currencyRate;
        _id = UUID.randomUUID();
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getCurrencyNameShort() {
        return currencyNameShort;
    }

    public void setCurrencyNameShort(String currencyNameShort) {
        this.currencyNameShort = currencyNameShort;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    @Override
    public List<Object> getChildObjectList() {
        return currencyList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        currencyList = list;
    }
}
