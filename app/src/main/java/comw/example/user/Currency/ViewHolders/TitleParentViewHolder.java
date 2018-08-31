package comw.example.user.Currency.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import comw.example.user.R;

public class TitleParentViewHolder extends ParentViewHolder {
    private TextView currencyNameShort, currencyRate;
    private ImageView imgDelete;

    public TitleParentViewHolder(View itemView) {
        super(itemView);

        currencyNameShort = itemView.findViewById(R.id.currencyNameShort);
        currencyRate = itemView.findViewById(R.id.currencyValue);
        imgDelete = itemView.findViewById(R.id.imgDelete);
    }

    public TextView getCurrencyNameShort() {
        return currencyNameShort;
    }

    public void setCurrencyNameShort(TextView currencyNameShort) {
        this.currencyNameShort = currencyNameShort;
    }

    public TextView getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(TextView currencyRate) {
        this.currencyRate = currencyRate;
    }
}
