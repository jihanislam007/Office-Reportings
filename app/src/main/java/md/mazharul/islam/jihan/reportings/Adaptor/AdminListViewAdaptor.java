package md.mazharul.islam.jihan.reportings.Adaptor;

/**
 * Created by Jihan on 11-Oct-17.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import md.mazharul.islam.jihan.reportings.R;

public class AdminListViewAdaptor extends BaseAdapter
{
    Activity context;
    String name[];
    String address[];
    String time[];
    String news[];

    public AdminListViewAdaptor(Activity context, String[] name, String[] address , String[] time ,String[] news) {
        super();
        this.context = context;
        this.name = name;
        this.address = address;
        this.time = time;
        this.news = news;
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return name.length;
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
        TextView nameText;
        TextView addresstxt;
        TextView timetxt;
        TextView newstxt;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.custom_listview_admin_view, null);
            holder = new ViewHolder();
            holder.nameText = (TextView) convertView.findViewById(R.id.NameTextView);
            holder.addresstxt = (TextView) convertView.findViewById(R.id.AddressTextView);
            holder.timetxt = (TextView) convertView.findViewById(R.id.TimeTextView);
            holder.newstxt = (TextView) convertView.findViewById(R.id.NewsTextView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameText.setText(name[position]);
        holder.addresstxt.setText(address[position]);
        holder.timetxt.setText(time[position]);
        holder.newstxt.setText(news[position]);

        return convertView;
    }

}