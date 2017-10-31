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

import java.io.File;
import java.util.List;

import md.mazharul.islam.jihan.reportings.R;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ReporterActivity extends AppCompatActivity {

    TextView logout;

    ImageView getMessage;
    LinearLayout picture;
    LinearLayout video;
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



        EasyImage.configuration(this)
                .setImagesFolderName("AOS")
                .setAllowMultiplePickInGallery(true);
        logout = (TextView) findViewById(R.id.LogOutTextView);

        getMessage = (ImageView) findViewById(R.id.GetMessageImageView);
        picture = (LinearLayout) findViewById(R.id.PictureImageViewLayout);
        video = (LinearLayout) findViewById(R.id.videoImageViewLayout);
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
                EasyImage.openGallery(ReporterActivity.this, 0);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagesPicked(List<File> imagesFiles, EasyImage.ImageSource source, int type) {
                System.out.println("List foundrapidpr");
            }
        });

    }
}
