package md.mazharul.islam.jihan.reportings.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

import md.mazharul.islam.jihan.reportings.Adapter.RecycleViewAdaptor;
import md.mazharul.islam.jihan.reportings.R;

public class ReporterActivity extends AppCompatActivity {

    TextView logout;

    ImageView getMessage;
    LinearLayout picture;
    LinearLayout video;
    /*ImageView pre1;
    ImageView pre2;
    ImageView pre3;
    ImageView Cancelpre1;
    ImageView Cancelpre2;
    ImageView Cancelpre3;*/

    VideoView videoPreview;
    ImageView CancelpreVideo;

    EditText reportingAddress;
    EditText reportHeading;
    EditText report;

    Button send;

    LinearLayout imagePreviewlayout;
    LinearLayout videoPreviewlayout;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
  //  ArrayList<String> alName;
    ArrayList<Uri> alImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporter);




        logout = (TextView) findViewById(R.id.LogOutTextView);

        getMessage = (ImageView) findViewById(R.id.GetMessageImageView);
        picture = (LinearLayout) findViewById(R.id.PictureImageViewLayout);
        video = (LinearLayout) findViewById(R.id.videoImageViewLayout);
        /*pre1 = (ImageView) findViewById(R.id.PreviewOneImageView);
        pre2 = (ImageView) findViewById(R.id.PreviewTwoImageView);
        pre3 = (ImageView) findViewById(R.id.PreviewThreeImageView);
        Cancelpre1 = (ImageView) findViewById(R.id.CancelPreviewOneimageView);



        Cancelpre2 = (ImageView) findViewById(R.id.CancelPreviewTwoimageView);
        Cancelpre3 = (ImageView) findViewById(R.id.CancelPreviewThreeimageView);
*/
        videoPreview = (VideoView) findViewById(R.id.videoPreviewVideoView);
        CancelpreVideo = (ImageView) findViewById(R.id.CancelvideoPreviewimageView);
        CancelpreVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoPreviewlayout.setVisibility(View.GONE);
            }
        });

        reportingAddress = (EditText) findViewById(R.id.ReportAdressEditText);
        reportHeading = (EditText) findViewById(R.id.HeadingEditText);
        report = (EditText) findViewById(R.id.ReportEditText);

        send = (Button) findViewById(R.id.SendButton);

        imagePreviewlayout = (LinearLayout) findViewById(R.id.ImagePreviewLayout);
        videoPreviewlayout = (LinearLayout) findViewById(R.id.VideoPreviewLayout);

        //////////////////////////Recycle view/////////////////////////////

        alImage = new ArrayList<>();

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.ImagePreviewRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecycleViewAdaptor(ReporterActivity.this, alImage);
        mRecyclerView.setAdapter(mAdapter);
        //////////////////////////Recycle view/////////////////////////////

        /////////////////////for EditText foucs start///////////////////
        reportingAddress.setSelected(false);
        reportHeading.setSelected(false);
        report.setSelected(false);
        /////////////////////for EditText foucs finish///////////////////

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picture.setVisibility(View.VISIBLE);
                Matisse.from(ReporterActivity.this)
                        .choose(MimeType.ofImage())
                        .showSingleMediaType(true)
                        .countable(true)
                        .maxSelectable(3)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(111);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Matisse.from(ReporterActivity.this)
                        .choose(MimeType.ofVideo())
                        .showSingleMediaType(true)
                        .countable(true)
                        .maxSelectable(1)
                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                        .thumbnailScale(0.85f)
                        .imageEngine(new GlideEngine())
                        .forResult(112);
            }
        });

        getMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ReporterActivity.this , CentralMessageGetActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            List<Uri> uris= Matisse.obtainResult(data);

        }

        if (requestCode == 112 && resultCode == RESULT_OK) {
            List<Uri> uris= Matisse.obtainResult(data);
            if(uris.size()>=1){
                videoPreview.setVideoURI(uris.get(0));
                videoPreview.seekTo(5000);
                videoPreviewlayout.setVisibility(View.VISIBLE);
            }

        }

    }

}
