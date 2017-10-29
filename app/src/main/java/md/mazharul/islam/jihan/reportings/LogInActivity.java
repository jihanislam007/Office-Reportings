package md.mazharul.islam.jihan.reportings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LogInActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner logInSpiner;
    EditText user_name;
    EditText password;
    Button logIn;
    TextView forgot_pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

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
                    Intent in = new Intent(LogInActivity.this , ReporterActivity.class);
                    startActivity(in);
                }
            });
        }

        else if(position == 1){
            forgot_pass.setVisibility(View.VISIBLE);
            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(LogInActivity.this , AdminViewActivity.class);
                    startActivity(in);
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