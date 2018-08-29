package comw.example.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * Class methods add and remove the list of currencies to be tracked
 */
public class CurrencyProvider {
    private static final String currencySettings = "currencySettings";
    private static final String currencyName = "currencyName";
    private static final String defCurrencyValue = "currencyValue";

    private Context context;
    private List<String> currencyDataList;
    private SharedPreferences sharedPreferences;

    public CurrencyProvider(Context context) {
        this.context = context;
        currencyDataList = new ArrayList<>();
        sharedPreferences = context.getSharedPreferences(currencySettings, context.MODE_PRIVATE);
        retrieveSharedValue();
        packageSharedPreferences();
    }

    public void addCurrencyDataObject(String currency) {
        currencyDataList.add(currency);
        packageSharedPreferences();
    }
    public void removeCurrencyDataObject(String currency) {
        currencyDataList.remove(currency);
        packageSharedPreferences();
    }

    public List<String> getCurrencyDataObjects() {
        return currencyDataList;
    }

    private void packageSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<>();
        set.addAll(currencyDataList);
        editor.putStringSet(currencyName, set);
        editor.apply();
    }

    private void retrieveSharedValue() {
        Set<String> defSet = new HashSet<>();
        defSet.add("USD");
        Set<String> set = sharedPreferences.getStringSet(currencyName, defSet);
        currencyDataList.addAll(set);
    }
}
