package dduwcom.mobile.helpus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyPeriodAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private PeriodData period;
    private LayoutInflater layoutInflater;

    private static class ViewHolder {
        TextView tvPeriod;
        TextView info;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return period;
    }

    @Override
    public long getItemId(int position) {
        return period.get_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        ViewHolder holder;

        if(convertView == null) {
            convertView = layoutInflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.tvPeriod =convertView.findViewById(R.id.period);
            holder.info = convertView.findViewById(R.id.info);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.tvPeriod.setText("#일");

        return convertView;
    }

    public MyPeriodAdapter(Context context, int layout, PeriodData period) {
        this.context = context;
        this.layout = layout;
        this.period = period;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
