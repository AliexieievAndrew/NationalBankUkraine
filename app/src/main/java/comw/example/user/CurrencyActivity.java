package comw.example.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyActivity extends AppCompatActivity {
    RecyclerView currenciesView;
    List<CurrencyData> currencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        currencies = new ArrayList<>();

        currenciesView = (RecyclerView) findViewById(R.id.currenciesView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        currenciesView.setLayoutManager(layoutManager);

        CurrencyAdapter adapter = new CurrencyAdapter(currencies);
        currenciesView.setAdapter(adapter);

        App.getApi().getCurrencyToday("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20180824&json").
                enqueue(new Callback<List<CurrencyData>>() {
                    @Override
                    public void onResponse(Call<List<CurrencyData>> call, Response<List<CurrencyData>> response) {

                        currencies.addAll(response.body());
                        currenciesView.getAdapter().notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<CurrencyData>> call, Throwable t) {
                        Toast.makeText(CurrencyActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
