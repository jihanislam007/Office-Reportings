package md.mazharul.islam.jihan.reportings;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import md.mazharul.islam.jihan.reportings.Adaptor.CentralMessageGetAdaptor;

public class CentralMessageGetActivity extends AppCompatActivity {

    ListView listView;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_message_get);

        String date[]={"05-10-2017","15-10-2017","02-10-2017","25-10-2017"};
        String time[]={"10:20 AM","12:50 PM","11:20 AM","02:50 PM"};
        String message[]={"Here is the central message command...",
                "Here is the central message command...",
        "Here is the central message command...",
        "Here is the central message command..."};

        listView = (ListView) findViewById(R.id.CentralMessageGetListView);
        CentralMessageGetAdaptor centralMessageGetAdaptor = new CentralMessageGetAdaptor(this, date , time , message);
        listView.setAdapter(centralMessageGetAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pop();
                mDialog.show();
            }
        });

    }
    ////////////////for popup////////////////////////
    public void pop() {

        mDialog = new Dialog(CentralMessageGetActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup_layout_central_message_get);

        /*firstcall = (ImageView) mDialog.findViewById(R.id.firstcallimageView);
        secondcall = (ImageView) mDialog.findViewById(R.id.secondcallimageView);
        thirdcall = (ImageView) mDialog.findViewById(R.id.thirdcallimageView);*/


    }
}
