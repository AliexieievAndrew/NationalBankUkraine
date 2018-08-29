package comw.example.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        CurrencyAdapter adapter = new CurrencyAdapter(currencies);
        currenciesView.setAdapter(adapter);
        currenciesView.getAdapter().notifyDataSetChanged();


        App.getApi().getCurrencyToday("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json").
                enqueue(new Callback<List<CurrencyData>>() {
                    @Override
                    public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {

                        currencies.addAll(getCurrenciesFilterList(response.body()));
                        currenciesView.getAdapter().notifyDataSetChanged();
                    }
                    @Override
                    public void onFailure(Call<List<CurrencyData>> call, Throwable t) {
                        Log.d("TAG", "onFailure: ");
                    }
                });
    }

    public List<CurrencyData> getCurrenciesFilterList(List<CurrencyData> currencies) {

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
}
