package comw.example.user.Currency.Models;

public class TitleChild {
    private String scheduleLastWeek, scheduleLastMonth, scheduleLastYear, scheduleAllTime;

    public TitleChild(String scheduleLastWeek, String scheduleLastMonth, String scheduleLastYear, String scheduleAllTime) {
        this.scheduleLastWeek = scheduleLastWeek;
        this.scheduleLastMonth = scheduleLastMonth;
        this.scheduleLastYear = scheduleLastYear;
        this.scheduleAllTime = scheduleAllTime;
    }

    public String getScheduleLastWeek() {
        return scheduleLastWeek;
    }

    public void setScheduleLastWeek(String scheduleLastWeek) {
        this.scheduleLastWeek = scheduleLastWeek;
    }

    public String getScheduleLastMonth() {
        return scheduleLastMonth;
    }

    public void setScheduleLastMonth(String scheduleLastMonth) {
        this.scheduleLastMonth = scheduleLastMonth;
    }

    public String getScheduleLastYear() {
        return scheduleLastYear;
    }

    public void setScheduleLastYear(String scheduleLastYear) {
        this.scheduleLastYear = scheduleLastYear;
    }

    public String getScheduleAllTime() {
        return scheduleAllTime;
    }

    public void setScheduleAllTime(String scheduleAllTime) {
        this.scheduleAllTime = scheduleAllTime;
    }
}
