package md.mazharul.islam.jihan.reportings.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import md.mazharul.islam.jihan.reportings.Adapter.AdminListViewAdaptor;
import md.mazharul.islam.jihan.reportings.JsonModel.ReportListItem;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

public class AdminViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;
    ArrayList<ReportListItem> reportListItems=new ArrayList<ReportListItem>();
    AdminListViewAdaptor adminListViewAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ///////////////////listView/////////////////////////////
        listView = (ListView) findViewById(R.id.AdminNewsListView);
        adminListViewAdaptor = new AdminListViewAdaptor(this,reportListItems);
        listView.setAdapter(adminListViewAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(AdminViewActivity.this , AdminNewsViewActivity.class);
                in.putExtra("id",reportListItems.get(position).reportId);
                startActivity(in);
            }
        });

        ///////////////////listView/////////////////////////////

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadReportList();
    }
    public void loadReportList(){
        System.out.println("try to load server data");
        AsyncHttpClient asyncHttpClient=new AsyncHttpClient();
        asyncHttpClient.get(ServerInfo.BASE_URL+"GetAllReport/",new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                Gson gson=new Gson();
                Type type = new TypeToken<ArrayList<ReportListItem>>() {}.getType();
                ArrayList<ReportListItem> listItems=gson.fromJson(response.toString(),
                        type);

                reportListItems.addAll(listItems);
                adminListViewAdaptor.notifyDataSetChanged();

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent in = new Intent(AdminViewActivity.this , GenarelMessageSendActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_gallery) {
            Intent in = new Intent(AdminViewActivity.this , ReporterListActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_slideshow) {
            Intent in = new Intent(AdminViewActivity.this , NewAcountActivity.class);
            startActivity(in);
        } else if (id == R.id.passwod_change) {
            Intent in = new Intent(AdminViewActivity.this , AdminPasswordChangActivity.class);
            startActivity(in);

        } else if (id == R.id.settings_change) {
            Intent in = new Intent(AdminViewActivity.this , SettingsActivity.class);
            startActivity(in);
        }/* else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        reportListItems.clear();
        adminListViewAdaptor.notifyDataSetChanged();
        loadReportList();
        System.out.println("On Resume call in admin view");
    }
}
