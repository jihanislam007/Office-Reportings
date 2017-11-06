package md.mazharul.islam.jihan.reportings.Activity;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.github.rtoshiro.view.video.FullscreenVideoLayout;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;
import md.mazharul.islam.jihan.reportings.JsonModel.ReportDetails;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;
import me.relex.circleindicator.CircleIndicator;

public class AdminNewsViewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //VideoView video;
    FullscreenVideoLayout video;
    ViewPager viewPager;
    TextView header , reporter_name , address , news,reportDetailsTextView;

    ArrayList<String> imgUrls=new ArrayList<>();
    ImageSlider imageSliderAdapter;
    ReportDetails rd;
    Dialog dialog;
    FloatingActionButton fab;
    LinearLayout VideoPreviewLayout;
    Toolbar toolbar;
    Dialog mDialog;
    Spinner MailChoiceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_news_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    mail_sender_pop();
                mDialog.show();
            }
        });*/

        imageSliderAdapter=new ImageSlider(this,imgUrls);
        VideoPreviewLayout= (LinearLayout) findViewById(R.id.VideoPreviewLayout);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  downloadVideo();
                mail_sender_pop();
                mDialog.show();
            }
        });

        video = (FullscreenVideoLayout) findViewById(R.id.VideoViewVideoView);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        header = (TextView) findViewById(R.id.HeaderTextView);
        reporter_name = (TextView) findViewById(R.id.ReporterNameTextView);
        address = (TextView) findViewById(R.id.AddressTextView);
        news = (TextView) findViewById(R.id.NewsTextView);
        reportDetailsTextView = (TextView) findViewById(R.id.reportDetails);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager.setAdapter(imageSliderAdapter);
        indicator.setViewPager(viewPager);
        imageSliderAdapter.registerDataSetObserver(indicator.getDataSetObserver());

        loadServer();

    }
    public void downloadVideo(){
        dialog=new Dialog(this);
        dialog.setContentView(R.layout.download_status);
        final NumberProgressBar numberProgressBar= (NumberProgressBar) dialog.findViewById(R.id.progressBarNumber);
        System.out.println(ServerInfo.BASE_URL2+rd.video);
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(ServerInfo.BASE_URL2+rd.video, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                //System.out.println(file.getAbsolutePath());
                Toast.makeText(AdminNewsViewActivity.this, "Download complete", Toast.LENGTH_SHORT).show();
                try {
                    //copyFileOrDirectory(file,new File(getDataDir(AdminNewsViewActivity.this)));
                    System.out.println("dest file "+getDestinationFile(rd.video).getAbsolutePath());
                    copyFile(file,getDestinationFile(rd.video));
                    videoPreviewEnable();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                long progressPercentage = (long)100*bytesWritten/totalSize;
                numberProgressBar.setProgress((int) progressPercentage);
            }

            @Override
            public void onPostProcessResponse(ResponseHandlerInterface instance, HttpResponse response) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public File getDestinationFile(String file){ //newly created file or later we can check file exist or not
        try {
            return new File(getDataDir(AdminNewsViewActivity.this)+"/"+getIntent().getIntExtra("id",-1)+"."+getFileExtension(file));
        } catch (Exception e) {
            return null;
        }
    }
    private String getFileExtension(String file) {
        String name = file;
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
    public String getDataDir(Context context) throws Exception {
        /*return context.getPackageManager()
                .getPackageInfo(context.getPackageName(), 0)
                .applicationInfo.dataDir;*/
        System.out.println("Path is "+this.getFilesDir().getAbsolutePath());
        return this.getFilesDir().getAbsolutePath();
    }

    public void loadServer(){
        int id=getIntent().getIntExtra("id",-1);
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(ServerInfo.BASE_URL+"GetSingalReport/?id="+id,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Gson gson=new Gson();
                ReportDetails reportDetails=gson.fromJson(response.toString(),ReportDetails.class);
                rd=reportDetails;
                header.setText(reportDetails.headline);
                reporter_name.setText(reportDetails.reporterName);
                address.setText(reportDetails.address);
                reportDetailsTextView.setText(reportDetails.details);
                for (String s:reportDetails.photos
                        ) {
                    imgUrls.add(ServerInfo.BASE_URL2+s);
                }
                imageSliderAdapter.notifyDataSetChanged();

                if(reportDetails.video!=null && reportDetails.video.length()>1){
                    fab.setVisibility(View.VISIBLE);
                }else{
                    fab.setVisibility(View.GONE);
                }
                videoPreviewEnable();
            }
        });
    }

    public void videoPreviewEnable(){
        if(getDestinationFile(rd.video).exists()){
            VideoPreviewLayout.setVisibility(View.VISIBLE);
            Uri uri=Uri.fromFile(getDestinationFile(rd.video));
            try {
                video.setVideoURI(uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fab.setVisibility(View.GONE);
            //video.seekTo(5000);
        }else{
            VideoPreviewLayout.setVisibility(View.GONE);
        }
    }

    public static void copyFileOrDirectory(String srcDir, String dstDir) {

        try {
            File src = new File(srcDir);
            File dst = new File(dstDir, src.getName());

            if (src.isDirectory()) {

                String files[] = src.list();
                int filesLength = files.length;
                for (int i = 0; i < filesLength; i++) {
                    String src1 = (new File(src, files[i]).getPath());
                    String dst1 = dst.getPath();
                    copyFileOrDirectory(src1, dst1);

                }
            } else {
                copyFile(src, dst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.getParentFile().exists())
            destFile.getParentFile().mkdirs();

        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        //destFile.createNewFile();

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        }
        System.out.println(sourceFile.getAbsolutePath());
        System.out.println(destFile.getAbsolutePath());
    }

    ////////////////for popup////////////////////////
    public void mail_sender_pop() {
        mDialog = new Dialog(AdminNewsViewActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.popup_details_mail_sender_layout);


       /* MailChoiceSpinner = (Spinner) findViewById(R.id.MailChoiceSpinner);

        // Spinner click listener
        MailChoiceSpinner.setOnItemSelectedListener(AdminNewsViewActivity.this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        MailChoiceSpinner.setAdapter(dataAdapter);*/

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(AdminNewsViewActivity.this, i ,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    ////////////////for popup////////////////////////
}

class ImageSlider extends PagerAdapter{

    ArrayList<String> imgUrl;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public ImageSlider(Context context,ArrayList<String> imgUrl) {
        this.imgUrl=imgUrl;
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imgUrl.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        System.out.println(imgUrl.get(position));
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Glide.with(mContext)
                .load(imgUrl.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }


}