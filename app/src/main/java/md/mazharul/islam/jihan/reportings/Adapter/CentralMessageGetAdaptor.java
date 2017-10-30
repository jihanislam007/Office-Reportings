package md.mazharul.islam.jihan.reportings.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import md.mazharul.islam.jihan.reportings.R;

/**
 * Created by Jihan on 11-Oct-17.
 */

public class CentralMessageGetAdaptor extends BaseAdapter{

    Activity context;
    String date[];
    String time[];
    String message[];

    public CentralMessageGetAdaptor(Activity context, String[] date, String[] time , String[] message ) {
        super();
        this.context = context;
        this.date = date;
        this.time = time;
        this.message = message;
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return date.length;
    }
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    private class ViewHolder {
        TextView dateText;
        TextView timetxt;
        TextView messagetxt;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        CentralMessageGetAdaptor.ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.custom_listview_central_get_message, null);
            holder = new CentralMessageGetAdaptor.ViewHolder();
            holder.dateText = (TextView) convertView.findViewById(R.id.DateTextView);
            holder.timetxt = (TextView) convertView.findViewById(R.id.TimeTextView);
            holder.messagetxt = (TextView) convertView.findViewById(R.id.MessageTextView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (CentralMessageGetAdaptor.ViewHolder) convertView.getTag();
        }

        holder.dateText.setText(date[position]);
        holder.timetxt.setText(time[position]);
        holder.messagetxt.setText(message[position]);

        return convertView;
    }

}