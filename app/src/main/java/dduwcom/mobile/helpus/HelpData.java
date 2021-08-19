package dduwcom.mobile.helpus;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import java.io.Serializable;

public class HelpData implements Serializable {
    private int _id;
    private String location;
    private String msg;
    private ImageView bellIcon;


    public HelpData(String location, String msg){
        this.location = location;
        this.msg = msg;

    }
    public HelpData(int _id, String location, String msg){
        this._id = _id;
        this.location = location;
        this.msg = msg;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setBellYellow() {
        //imageView
        bellIcon.setImageResource(R.drawable.yellow);
    }

}
