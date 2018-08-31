package comw.example.user.Currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comw.example.user.Currency.Adapter.CurrencyExpandableAdapter;
import comw.example.user.Currency.Models.TitleChild;
import comw.example.user.Currency.Models.TitleCreator;
import comw.example.user.Currency.Models.TitleParent;
import comw.example.user.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity extends AppCompatActivity {
    RecyclerView currenciesView;
    List<CurrencyData> currencies;
    List<CurrencyData> currenciesFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        currencies = new ArrayList<>();
        currenciesFilter = new ArrayList<>();

        currenciesView = (RecyclerView) findViewById(R.id.currenciesView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        currenciesView.setLayoutManager(layoutManager);

        App.getApi().getCurrencyToday("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").
                enqueue(new Callback<List<CurrencyData>>() {
                    @Override
                    public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {
                        currencies.addAll(getCurrenciesFilterList(response.body()));

                        CurrencyExpandableAdapter adapter = new CurrencyExpandableAdapter(getApplicationContext(),initData(currencies));
                        adapter.setParentClickableViewAnimationDefaultDuration();
                        adapter.setParentAndIconExpandOnClick(true);
                        currenciesView.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(Call<List<CurrencyData>> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
    }

    private List<CurrencyData> getCurrenciesFilterList(List<CurrencyData> currencies) {

        CurrencyProvider currencyProvider = new CurrencyProvider(getApplicationContext());

        for (String s:currencyProvider.getCurrencyDataObjects()) {
            Iterator<CurrencyData> iterator = currencies.iterator();

            while (iterator.hasNext()){
                CurrencyData currencyData = iterator.next();

                if(currencyData.getCc().equals(s)) {
                    currenciesFilter.add(currencyData);
                }
            }
        }
        return currenciesFilter;
    }

    private List<ParentObject> initData(List<CurrencyData> data) {
        TitleCreator titleCreator = TitleCreator.getTitleCreator(getApplicationContext(),data);

        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObjects = new ArrayList<>();

        for (TitleParent titleParentObject : titles) {

            List<Object> childList = new ArrayList<>();

            childList.add(new TitleChild(
                    "by week",
                    "by month",
                    "by year",
                    "by all time"));

            titleParentObject.setChildObjectList(childList);
            parentObjects.add(titleParentObject);
        }
        return parentObjects;
    }
}
