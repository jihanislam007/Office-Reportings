package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import md.mazharul.islam.jihan.reportings.Offline.OfflineInfo;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText email;
    Button confirm;
    OfflineInfo offlineInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        offlineInfo=new OfflineInfo(this);

        email = (EditText) findViewById(R.id.EmailEditText);
        confirm = (Button) findViewById(R.id.ConfirmButton);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(ServerInfo.BASE_URL + "GetPasswordUser", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            if (offlineInfo.getEmail().equalsIgnoreCase(email.getText().toString())){
                                String body="your user name : <h1>"+response.getString("userName")+"</h1>" +
                                        "your Password : <h1>"+response.getString("password")+"</h1>";
                                sendFromGMail(response.getJSONObject("email_info").getString("email"),response.getJSONObject("email_info").getString("password"),email.getText().toString(),"Password",
                                        body);
                            }else{
                                Toast.makeText(ForgotPasswordActivity.this, "We can't verify you.Please contact with us", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });



    }
    private void sendFromGMail(String from, String pass, String to, String subject, String body) {
        BackgroundMail.newBuilder(this)
                .withUsername(from)
                .withPassword(pass)
                .withMailto(to)
                .withType(BackgroundMail.TYPE_HTML)
                .withSubject(subject)
                .withBody(body)
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        //do some magic
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        //do some magic
                    }
                })
                .send();
    }
}
