package md.mazharul.islam.jihan.reportings;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import md.mazharul.islam.jihan.reportings.Adaptor.ReporterListAdopter;

public class ReporterListActivity extends AppCompatActivity {

    ListView listView;
    Dialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporter_list);

        String name[] ={"Name1","Name2","Name3","Name4","Name5","Name6","Name7","Name8"};
        String address[] ={"Address1","Address2","Address3","Address4","Address5","Address6","Address7","Address8"};

        ///////////////////listView/////////////////////////////
        listView = (ListView) findViewById(R.id.ReporterListListView);
        ReporterListAdopter reporterListAdopter = new ReporterListAdopter(this, name, address);
        listView.setAdapter(reporterListAdopter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               /* Intent in = new Intent(AdminViewActivity.this , AdminNewsViewActivity.class);
                startActivity(in);*/
                pop();
               mDialog.show();

            }
        });

        ///////////////////listView/////////////////////////////
    }

    ////////////////for popup////////////////////////
    public void pop() {

        mDialog = new Dialog(ReporterListActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup_layout_reporter_details);

        /*firstcall = (ImageView) mDialog.findViewById(R.id.firstcallimageView);
        secondcall = (ImageView) mDialog.findViewById(R.id.secondcallimageView);
        thirdcall = (ImageView) mDialog.findViewById(R.id.thirdcallimageView);*/

    }
    ////////////////for popup////////////////////////
}
