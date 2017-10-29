package md.mazharul.islam.jihan.reportings;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class AdminNewsViewActivity extends AppCompatActivity {

    VideoView video;
    ViewPager viewPager;
    TextView header , reporter_name , address , news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_news_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Downloading", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        video = (VideoView) findViewById(R.id.VideoViewVideoView);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        header = (TextView) findViewById(R.id.HeaderTextView);
        reporter_name = (TextView) findViewById(R.id.ReporterNameTextView);
        address = (TextView) findViewById(R.id.AddressTextView);
        news = (TextView) findViewById(R.id.NewsTextView);



    }

}
