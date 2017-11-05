package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

public class GenarelMessageSendActivity extends AppCompatActivity {

    EditText ReportEditText;
    Button LogInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genarel_message_send);
        ReportEditText= (EditText) findViewById(R.id.ReportEditText);
        LogInButton= (Button) findViewById(R.id.LogInButton);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sentMsg();
            }
        });

    }

    private void sentMsg() {
        String msg=ReportEditText.getText().toString();
        AsyncHttpClient httpClient=new AsyncHttpClient();
        RequestParams params=new RequestParams();
        params.add("msg",msg);
        httpClient.post(ServerInfo.BASE_URL+"AddAdminMessage/",params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(GenarelMessageSendActivity.this, "Successfully post message", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
