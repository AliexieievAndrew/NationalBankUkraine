package comw.example.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder> {

    private List<CurrencyData> currencies;

    public CurrencyAdapter(List<CurrencyData> currencies) {
        this.currencies = currencies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_currency, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CurrencyData currency = currencies.get(position);

        holder.currencyName.setText(currency.getTxt());
        holder.currencyRate.setText(String.valueOf(currency.getRate()));
        holder.currencyExchangeDate.setText(currency.getExchangedate());
    }

    @Override
    public int getItemCount() {
        if (currencies == null)
            return 0;
        return currencies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView currencyName;
        TextView currencyRate;
        TextView currencyExchangeDate;

        public ViewHolder(View itemView) {
            super(itemView);

            currencyName = (TextView) itemView.findViewById(R.id.currencyName);
            currencyRate = (TextView) itemView.findViewById(R.id.currencyRate);
            currencyExchangeDate = (TextView) itemView.findViewById(R.id.currencyExchangeDate);
        }
    }
}
