package md.mazharul.islam.jihan.reportings;

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

import md.mazharul.islam.jihan.reportings.Adaptor.AdminListViewAdaptor;

public class AdminViewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name[] ={"Name1","Name2","Name3","Name4","Name5","Name6","Name7","Name8"};
        String address[] ={"Address1","Address2","Address3","Address4","Address5","Address6","Address7","Address8"};
        String time[] ={"10:20 AM","12:30 PM","10:20 AM","12:30 PM","10:20 AM","12:30 PM","10:20 AM","12:30 PM"};
        String news[] ={"Here is news one Heading for Admin pannel.......",
                "Here is news two Heading for Admin pannel.......",
                "Here is news three Heading for Admin pannel.......",
                "Here is news four Heading for Admin pannel.......",
                "Here is news five Heading for Admin pannel.......",
                "Here is news six Heading for Admin pannel.......",
                "Here is news seven Heading for Admin pannel.......",
                "Here is news eight Heading for Admin pannel......."};

        ///////////////////listView/////////////////////////////
        listView = (ListView) findViewById(R.id.AdminNewsListView);
        AdminListViewAdaptor adminListViewAdaptor = new AdminListViewAdaptor(this, name, address,time,news);
        listView.setAdapter(adminListViewAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(AdminViewActivity.this , AdminNewsViewActivity.class);
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

        }/* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
