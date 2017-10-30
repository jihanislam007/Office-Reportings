package md.mazharul.islam.jihan.reportings.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import md.mazharul.islam.jihan.reportings.R;

public class ReporterActivity extends AppCompatActivity {

    TextView logout;

    ImageView getMessage;
    ImageView picture;
    ImageView video;
    ImageView pre1;
    ImageView pre2;
    ImageView pre3;
    ImageView Cancelpre1;
    ImageView Cancelpre2;
    ImageView Cancelpre3;

    VideoView videoPreview;
    ImageView CancelpreVideo;

    EditText reportingAddress;
    EditText reportHeading;
    EditText report;

    Button send;

    LinearLayout imagePreviewlayout;
    LinearLayout videoPreviewlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporter);

        logout = (TextView) findViewById(R.id.LogOutTextView);

        getMessage = (ImageView) findViewById(R.id.GetMessageImageView);
        picture = (ImageView) findViewById(R.id.PictureImageView);
        video = (ImageView) findViewById(R.id.videoImageView);
        pre1 = (ImageView) findViewById(R.id.PreviewOneImageView);
        pre2 = (ImageView) findViewById(R.id.PreviewTwoImageView);
        pre3 = (ImageView) findViewById(R.id.PreviewThreeImageView);
        Cancelpre1 = (ImageView) findViewById(R.id.CancelPreviewOneimageView);
        Cancelpre2 = (ImageView) findViewById(R.id.CancelPreviewTwoimageView);
        Cancelpre3 = (ImageView) findViewById(R.id.CancelPreviewThreeimageView);

        videoPreview = (VideoView) findViewById(R.id.videoPreviewVideoView);
        CancelpreVideo = (ImageView) findViewById(R.id.CancelvideoPreviewimageView);

        reportingAddress = (EditText) findViewById(R.id.ReportAdressEditText);
        reportHeading = (EditText) findViewById(R.id.HeadingEditText);
        report = (EditText) findViewById(R.id.ReportEditText);

        send = (Button) findViewById(R.id.SendButton);

        imagePreviewlayout = (LinearLayout) findViewById(R.id.ImagePreviewLayout);
        videoPreviewlayout = (LinearLayout) findViewById(R.id.VideoPreviewLayout);

        /////////////////////for EditText foucs start///////////////////
        reportingAddress.setSelected(false);
        reportHeading.setSelected(false);
        report.setSelected(false);
        /////////////////////for EditText foucs finish///////////////////

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePreviewlayout.setVisibility(View.VISIBLE);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoPreviewlayout.setVisibility(View.VISIBLE);
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
}
