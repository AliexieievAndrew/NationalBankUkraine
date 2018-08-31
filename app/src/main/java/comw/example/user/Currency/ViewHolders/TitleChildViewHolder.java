package comw.example.user.Currency.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import comw.example.user.R;

public class TitleChildViewHolder extends ChildViewHolder {

    private TextView scheduleLastWeek, scheduleLastMonth, scheduleLastYear, scheduleAllTime;

    public TitleChildViewHolder(View itemView) {
        super(itemView);

        scheduleLastWeek = itemView.findViewById(R.id.scheduleLastWeek);
        scheduleLastMonth = itemView.findViewById(R.id.scheduleLastMonth);
        scheduleLastYear = itemView.findViewById(R.id.scheduleLastYear);
        scheduleAllTime = itemView.findViewById(R.id.scheduleAllTime);
    }

    public TextView getScheduleLastWeek() {
        return scheduleLastWeek;
    }

    public void setScheduleLastWeek(TextView scheduleLastWeek) {
        this.scheduleLastWeek = scheduleLastWeek;
    }

    public TextView getScheduleLastMonth() {
        return scheduleLastMonth;
    }

    public void setScheduleLastMonth(TextView scheduleLastMonth) {
        this.scheduleLastMonth = scheduleLastMonth;
    }

    public TextView getScheduleLastYear() {
        return scheduleLastYear;
    }

    public void setScheduleLastYear(TextView scheduleLastYear) {
        this.scheduleLastYear = scheduleLastYear;
    }

    public TextView getScheduleAllTime() {
        return scheduleAllTime;
    }

    public void setScheduleAllTime(TextView scheduleAllTime) {
        this.scheduleAllTime = scheduleAllTime;
    }
}
