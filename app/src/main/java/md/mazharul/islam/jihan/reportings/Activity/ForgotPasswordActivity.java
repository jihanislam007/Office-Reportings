package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import md.mazharul.islam.jihan.reportings.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText email;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = (EditText) findViewById(R.id.EmailEditText);
        confirm = (Button) findViewById(R.id.ConfirmButton);

    }
}
