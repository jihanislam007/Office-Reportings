package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import md.mazharul.islam.jihan.reportings.R;

public class SettingsActivity extends AppCompatActivity {

EditText SenderEmailAddress,
    SenderEmailPassword;
ListView SettingListView;
Button AddReciverMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SenderEmailAddress = (EditText) findViewById(R.id.EmailAddressEditText);
        SenderEmailPassword = (EditText) findViewById(R.id.EmailPasswordEditText);

        SettingListView = (ListView) findViewById(R.id.SettingListView);
        AddReciverMail = (Button) findViewById(R.id.EmailAddButton);


    }
}
