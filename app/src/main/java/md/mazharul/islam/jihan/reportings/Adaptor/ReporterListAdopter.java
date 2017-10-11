package md.mazharul.islam.jihan.reportings.Adaptor;

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

public class ReporterListAdopter extends BaseAdapter {

    Activity context;
    String name[];
    String address[];

    public ReporterListAdopter(Activity context, String[] name, String[] address ) {
        super();
        this.context = context;
        this.name = name;
        this.address = address;
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
    private class ViewHolderList {
        TextView nameText;
        TextView addresstxt;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ReporterListAdopter.ViewHolderList holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.custom_listview_reporter_list, null);
            holder = new ReporterListAdopter.ViewHolderList();
            holder.nameText = (TextView) convertView.findViewById(R.id.NameTextView);
            holder.addresstxt = (TextView) convertView.findViewById(R.id.AddressTextView);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ReporterListAdopter.ViewHolderList) convertView.getTag();
        }

        holder.nameText.setText(name[position]);
        holder.addresstxt.setText(address[position]);

        return convertView;
    }

}