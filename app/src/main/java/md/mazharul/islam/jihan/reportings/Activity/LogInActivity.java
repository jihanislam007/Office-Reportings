package md.mazharul.islam.jihan.reportings.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

import cz.msebera.android.httpclient.Header;
import md.mazharul.islam.jihan.reportings.R;
import md.mazharul.islam.jihan.reportings.ServerInfo.ServerInfo;

public class LogInActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner logInSpiner;
    EditText user_name;
    EditText password;
    Button logIn;
    TextView forgot_pass;
    EditText PasswordCarecterOneEditText,PasswordCarecterTwoEditText,PasswordCarecterThreeEditText,PasswordNumberOneEditText,PasswordNumberTwoEditText,PasswordNumberThreeEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        PasswordCarecterOneEditText= (EditText) findViewById(R.id.PasswordCarecterOneEditText);
        PasswordCarecterTwoEditText= (EditText) findViewById(R.id.PasswordCarecterTwoEditText);
        PasswordCarecterThreeEditText= (EditText) findViewById(R.id.PasswordCarecterThreeEditText);
        PasswordNumberOneEditText= (EditText) findViewById(R.id.PasswordNumberOneEditText);
        PasswordNumberTwoEditText= (EditText) findViewById(R.id.PasswordNumberTwoEditText);
        PasswordNumberThreeEditText= (EditText) findViewById(R.id.PasswordNumberThreeEditText);

        editTextFocusController();
        logInSpiner = (Spinner) findViewById(R.id.LogInSpinner);
        user_name = (EditText) findViewById(R.id.UserNameEditText);
     //   password = (EditText) findViewById(R.id.PasswordEditText);
        logIn = (Button) findViewById(R.id.LogInButton);
        forgot_pass = (TextView) findViewById(R.id.ForgotPassTextView);

        ///////////////Spinner////////////////////////////
        // Spinner click listener
        logInSpiner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("User");
        categories.add("Admin");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        logInSpiner.setAdapter(dataAdapter);
        ///////////////Spinner////////////////////////////
    }

    public String getPassword(){
        return PasswordCarecterOneEditText.getText().toString()+PasswordCarecterTwoEditText.getText().toString()+
                PasswordCarecterThreeEditText.getText().toString()+PasswordNumberOneEditText.getText().toString()+
                PasswordNumberTwoEditText.getText().toString()+PasswordNumberThreeEditText.getText().toString();
    }

    private void editTextFocusController() {
        PasswordCarecterOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordCarecterOneEditText.clearFocus();
                    PasswordCarecterTwoEditText.requestFocus();
                    PasswordCarecterTwoEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        PasswordCarecterTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordCarecterTwoEditText.clearFocus();
                    PasswordCarecterThreeEditText.requestFocus();
                    PasswordCarecterThreeEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        PasswordCarecterThreeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordCarecterThreeEditText.clearFocus();
                    PasswordNumberOneEditText.requestFocus();
                    PasswordNumberOneEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        PasswordNumberOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordNumberOneEditText.clearFocus();
                    PasswordNumberTwoEditText.requestFocus();
                    PasswordNumberTwoEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        PasswordNumberTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordNumberTwoEditText.clearFocus();
                    PasswordNumberThreeEditText.requestFocus();
                    PasswordNumberThreeEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        PasswordCarecterOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    PasswordNumberThreeEditText.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


               // ,,,,
    }

    //////////////////Spinner///////////////
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*// On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();*/

        if(position ==0 ){
            forgot_pass.setVisibility(View.INVISIBLE);
            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AsyncHttpClient client=new AsyncHttpClient();
                    RequestParams params=new RequestParams();
                    params.add("username",user_name.getText().toString());
                    params.add("password",getPassword());

                    client.post(ServerInfo.BASE_URL+"ReporterLogin/",params,new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                if(response.getBoolean("res")){
                                    Toast.makeText(LogInActivity.this, "Successfully login", Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(LogInActivity.this , ReporterActivity.class);
                                    startActivity(in);
                                }else{
                                    Toast.makeText(LogInActivity.this, "User name or password invalid", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {

                            }
                        }
                    });


                }
            });
        }

        else if(position == 1){
            forgot_pass.setVisibility(View.VISIBLE);
            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AsyncHttpClient client=new AsyncHttpClient();
                    RequestParams params=new RequestParams();
                    params.add("username",user_name.getText().toString());
                    params.add("password",getPassword());
                    client.post(ServerInfo.BASE_URL+"Login/",params,new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                if(response.getBoolean("res")){
                                    Toast.makeText(LogInActivity.this, "Successfully login", Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(LogInActivity.this , AdminViewActivity.class);
                                    startActivity(in);

                                }else{
                                    Toast.makeText(LogInActivity.this, "User name or password invalid", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {

                            }
                        }
                    });

                }
            });
        }

        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LogInActivity.this , ForgotPasswordActivity.class);
                startActivity(in);
            }
        });
        /*// Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item + id, Toast.LENGTH_LONG).show();*/
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    //////////////////Spinner///////////////
}