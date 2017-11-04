package md.mazharul.islam.jihan.reportings.Activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import md.mazharul.islam.jihan.reportings.Adapter.CentralMessageGetAdaptor;
import md.mazharul.islam.jihan.reportings.JsonModel.AdminMessageItem;
import md.mazharul.islam.jihan.reportings.JsonModel.ReporterListItem;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

public class CentralMessageGetActivity extends AppCompatActivity {

    ListView listView;
    Dialog mDialog;
    ArrayList<AdminMessageItem> messageItems=new ArrayList<AdminMessageItem>();
    CentralMessageGetAdaptor centralMessageGetAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_message_get);
        listView = (ListView) findViewById(R.id.CentralMessageGetListView);
        centralMessageGetAdaptor = new CentralMessageGetAdaptor(this, messageItems);
        listView.setAdapter(centralMessageGetAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pop(position);
            }
        });
        loadFromServer();

    }
    ////////////////for popup////////////////////////
    public void pop(int position) {

        mDialog = new Dialog(CentralMessageGetActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup_layout_central_message_get);
        TextView date= (TextView) mDialog.findViewById(R.id.date);
        date.setText(messageItems.get(position).datetime.split(" ")[0]);
        TextView time= (TextView) mDialog.findViewById(R.id.time);
        time.setText(messageItems.get(position).datetime.split(" ")[1]);
        TextView message= (TextView) mDialog.findViewById(R.id.message);
        message.setText(messageItems.get(position).msg);
        final Button cancelBtn= (Button) mDialog.findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });

        mDialog.show();

    }
    public void loadFromServer(){
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(ServerInfo.BASE_URL+"GetAdminMessage/",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Gson gson=new Gson();

                Type type = new TypeToken<ArrayList<AdminMessageItem>>() {}.getType();
                ArrayList<AdminMessageItem> adminMessageItems=gson.fromJson(response.toString(),type);
                messageItems.addAll(adminMessageItems);
                centralMessageGetAdaptor.notifyDataSetChanged();
            }
        });
    }
}
