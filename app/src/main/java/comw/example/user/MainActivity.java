package comw.example.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import comw.example.user.Currency.CurrencyActivity;

public class MainActivity extends AppCompatActivity {
    CardView cardCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardCurrency = (CardView) findViewById(R.id.cardCurrency);
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, CurrencyActivity.class);
        startActivity(intent);
    }
}
