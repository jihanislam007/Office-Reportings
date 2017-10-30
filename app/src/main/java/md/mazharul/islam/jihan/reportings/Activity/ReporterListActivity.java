package md.mazharul.islam.jihan.reportings.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import md.mazharul.islam.jihan.reportings.Adapter.ReporterListAdopter;
import md.mazharul.islam.jihan.reportings.R;

public class ReporterListActivity extends AppCompatActivity {

    ListView listView;
    Dialog mDialog;
    Button delete , edit , cancel;
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


                pop();

                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    });

                    edit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent in = new Intent(ReporterListActivity.this , NewAcountActivity.class);
                            startActivity(in);
                        }
                     });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });

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

        delete = (Button) mDialog.findViewById(R.id.DeleteButton);
        edit = (Button) mDialog.findViewById(R.id.EditButton);
        cancel = (Button) mDialog.findViewById(R.id.CncelButton);

    }
    ////////////////for popup////////////////////////
}
