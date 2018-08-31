package comw.example.user.Currency.Models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import comw.example.user.Currency.CurrencyData;

public class TitleCreator {
    static TitleCreator titleCreator;
    private List<TitleParent> titleParents;
    private Context context;
    private List<CurrencyData> currencyDataList;

    private TitleCreator(Context context,List<CurrencyData> currencyDataList) {
        this.context = context;
        this.currencyDataList = currencyDataList;

        titleParents = new ArrayList<>();

        for (CurrencyData data:currencyDataList) {
            titleParents.add(new TitleParent(data.getCc(),String.valueOf(data.getRate())));
        }
    }


    public static TitleCreator getTitleCreator(Context context, List<CurrencyData> currencyDataList){
        if (titleCreator == null) {
            titleCreator = new TitleCreator(context, currencyDataList);
        }
        return titleCreator;
    }

    public List<TitleParent> getAll(){
        return titleParents;
    }
}
