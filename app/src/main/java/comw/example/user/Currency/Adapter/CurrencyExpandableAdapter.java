package comw.example.user.Currency.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import comw.example.user.Currency.Models.TitleChild;
import comw.example.user.Currency.Models.TitleParent;
import comw.example.user.Currency.ViewHolders.TitleChildViewHolder;
import comw.example.user.Currency.ViewHolders.TitleParentViewHolder;
import comw.example.user.R;

public class CurrencyExpandableAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {
    private LayoutInflater layoutInflater;

    public CurrencyExpandableAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.expandable_currency_parent, viewGroup, false);

        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.expandable_currency_child, viewGroup, false);

        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent = (TitleParent) o;

        titleParentViewHolder.getCurrencyNameShort().setText(titleParent.getCurrencyNameShort());
        titleParentViewHolder.getCurrencyRate().setText(titleParent.getCurrencyRate());
    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        TitleChild title = (TitleChild) o;

        titleChildViewHolder.getScheduleAllTime().setText(title.getScheduleAllTime());
        titleChildViewHolder.getScheduleLastWeek().setText(title.getScheduleLastWeek());
        titleChildViewHolder.getScheduleLastMonth().setText(title.getScheduleLastMonth());
        titleChildViewHolder.getScheduleLastYear().setText(title.getScheduleLastYear());

    }
}
