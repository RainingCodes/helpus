package dduwcom.mobile.helpus;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelpAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<HelpData> helpDataList;
    private LayoutInflater layoutInflater;

    public HelpAdapter(Context context, int layout, ArrayList<HelpData> helpDataList) {
        this.context = context;
        this.layout = layout;
        this.helpDataList = helpDataList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return helpDataList.size();
    }

    public Object getItem(int position){
        return helpDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return helpDataList.get(position).get_id();
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final int pos = position;
//        RecyclerView.ViewHolder holder;
        //viewHolder 만들어야해요

        if (convertView == null){
            convertView = layoutInflater.inflate(layout, parent, false);
        }
//        holder = new RecyclerView.ViewHolder() {
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//        }
        TextView location = convertView.findViewById(R.id.location);
        TextView message = convertView.findViewById(R.id.message);
        ImageButton icon = convertView.findViewById(R.id.icon);

        location.setText(helpDataList.get(pos).getLocation());
        message.setText(helpDataList.get(pos).getMsg());
//        icon.setFocusable(false);

        return convertView;
    }
}
