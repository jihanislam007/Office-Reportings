package md.mazharul.islam.jihan.reportings.Activity;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.filter.Filter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import md.mazharul.islam.jihan.reportings.Adapter.RecycleViewAdaptor;
import md.mazharul.islam.jihan.reportings.Offline.OfflineInfo;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

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
    Uri videoUri;
    LinearLayout progressBar;
    NumberProgressBar progressBarNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporter);


        logout = (TextView) findViewById(R.id.LogOutTextView);
        progressBar = (LinearLayout) findViewById(R.id.progressBar);
        progressBarNumber = (NumberProgressBar) findViewById(R.id.progressBarNumber);

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
                videoUri = null;
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
        //  alImage = new ArrayList<>(Arrays.asList(R.drawable.camera, R.drawable.camera, R.drawable.camera));
        //  crossImage = new ArrayList<>(Arrays.asList(R.drawable.camera, R.drawable.camera, R.drawable.camera));

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.ImagePreviewRecyclerView);
        //mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecycleViewAdaptor(ReporterActivity.this, alImage);
        mRecyclerView.setAdapter(mAdapter);
        //////////////////////////Recycle view/////////////////////////////

       /* /////////////////////for EditText foucs start///////////////////
        reportingAddress.setSelected(false);
        reportHeading.setSelected(false);
        report.setSelected(false);
        /////////////////////for EditText foucs finish///////////////////*/

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int maxselection = 3 - alImage.size();
                if (maxselection == 0) {
                    Toast.makeText(ReporterActivity.this, "Maximum selection completed.please reduce one or more", Toast.LENGTH_SHORT).show();
                    return;
                }
                picture.setVisibility(View.VISIBLE);
                Matisse.from(ReporterActivity.this)
                        .choose(MimeType.ofImage())
                        .showSingleMediaType(true)
                        .countable(true)
                        .maxSelectable(maxselection)
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
                Intent in = new Intent(ReporterActivity.this, CentralMessageGetActivity.class);
                startActivity(in);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);
                progressBarNumber.setProgress(1);

                OfflineInfo offlineInfo=new OfflineInfo(ReporterActivity.this);
                AsyncHttpClient client = new AsyncHttpClient();
                client.setTimeout(1000*60*60*60);
                final RequestParams params = new RequestParams();
                File[] files = new File[alImage.size()];
                int i = 0;
                for (Uri uri : alImage
                        ) {
                    File file = new File(getRealPathFromURI(uri));
                    files[i++] = file;
                }
                try {
                    if (i > 0) {
                        params.put("photos", files);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                if (videoUri != null) {
                    File file = new File(getRealPathFromURI(videoUri));
                    try {
                        params.put("video", file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                params.add("reportingAddress",reportingAddress.getText().toString());
                params.add("reportHeading",reportHeading.getText().toString());
                params.add("report",report.getText().toString());
                params.add("username",offlineInfo.getUserName());



                client.post(ServerInfo.BASE_URL + "CreateReport/", params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        System.out.println(response.toString());
                        try {
                            if(response.getBoolean("res")){
                                Toast.makeText(ReporterActivity.this, "Successfully save report", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onProgress(long bytesWritten, long totalSize) {
                        super.onProgress(bytesWritten, totalSize);
                        long progressPercentage = (long)100*bytesWritten/totalSize;
                        progressBarNumber.setProgress((int) progressPercentage);
                    }

                    @Override
                    public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                        System.out.println(params);
                        progressBar.setVisibility(View.GONE);
                    }
                });

            }
        });
    }

    public String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};

        //This method was deprecated in API level 11
        //Cursor cursor = managedQuery(contentUri, proj, null, null, null);

        CursorLoader cursorLoader = new CursorLoader(
                this,
                contentUri, proj, null, null, null);
        Cursor cursor = cursorLoader.loadInBackground();

        int column_index =
                cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);
            alImage.addAll(uris);
            mAdapter.notifyDataSetChanged();
        }

        if (requestCode == 112 && resultCode == RESULT_OK) {
            List<Uri> uris = Matisse.obtainResult(data);

            if (uris.size() >= 1) {
                videoPreview.setVideoURI(uris.get(0));
                videoPreview.seekTo(5000);
                videoPreviewlayout.setVisibility(View.VISIBLE);
                videoUri = uris.get(0);
            }

        }

    }

}
