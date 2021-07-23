package dduwcom.mobile.helpus;

public class PeriodData {
    private int _id;
    private String info;
    private String period;

    public PeriodData(int _id, String info, String period) {
        this._id = _id;
        this.info = info;
        this.period = period;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
