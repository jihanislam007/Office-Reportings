package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import md.mazharul.islam.jihan.reportings.R;

public class AdminPasswordChangActivity extends AppCompatActivity {
    EditText PasswordCarecterOneEditText,PasswordCarecterTwoEditText,PasswordCarecterThreeEditText,PasswordNumberOneEditText,PasswordNumberTwoEditText,PasswordNumberThreeEditText;

    EditText oldPasswordCarecterOneEditText,oldPasswordCarecterTwoEditText,oldPasswordCarecterThreeEditText,oldPasswordNumberOneEditText,oldPasswordNumberTwoEditText,oldPasswordNumberThreeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_password_chang);

        PasswordCarecterOneEditText= (EditText) findViewById(R.id.PasswordCarecterOneEditText);
        PasswordCarecterTwoEditText= (EditText) findViewById(R.id.PasswordCarecterTwoEditText);
        PasswordCarecterThreeEditText= (EditText) findViewById(R.id.PasswordCarecterThreeEditText);
        PasswordNumberOneEditText= (EditText) findViewById(R.id.PasswordNumberOneEditText);
        PasswordNumberTwoEditText= (EditText) findViewById(R.id.PasswordNumberTwoEditText);
        PasswordNumberThreeEditText= (EditText) findViewById(R.id.PasswordNumberThreeEditText);

        oldPasswordCarecterOneEditText= (EditText) findViewById(R.id.OldPasswordCarecterOneEditText);
        oldPasswordCarecterTwoEditText= (EditText) findViewById(R.id.OldPasswordCarecterTwoEditText);
        oldPasswordCarecterThreeEditText= (EditText) findViewById(R.id.OldPasswordCarecterThreeEditText);
        oldPasswordNumberOneEditText= (EditText) findViewById(R.id.OldPasswordNumberOneEditText);
        oldPasswordNumberTwoEditText= (EditText) findViewById(R.id.OldPasswordNumberTwoEditText);
        oldPasswordNumberThreeEditText= (EditText) findViewById(R.id.OldPasswordNumberThreeEditText);

        editTextFocusController();

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

        oldPasswordCarecterOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordCarecterOneEditText.clearFocus();
                    oldPasswordCarecterOneEditText.requestFocus();
                    oldPasswordCarecterOneEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        oldPasswordCarecterTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordCarecterTwoEditText.clearFocus();
                    oldPasswordCarecterTwoEditText.requestFocus();
                    oldPasswordCarecterTwoEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        oldPasswordCarecterThreeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordCarecterThreeEditText.clearFocus();
                    oldPasswordCarecterThreeEditText.requestFocus();
                    oldPasswordCarecterThreeEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        oldPasswordNumberOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordNumberOneEditText.clearFocus();
                    oldPasswordNumberOneEditText.requestFocus();
                    oldPasswordNumberOneEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        oldPasswordNumberTwoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordNumberTwoEditText.clearFocus();
                    oldPasswordNumberTwoEditText.requestFocus();
                    oldPasswordNumberTwoEditText.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        oldPasswordCarecterOneEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>=1){
                    oldPasswordCarecterOneEditText.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
