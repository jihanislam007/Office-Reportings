package md.mazharul.islam.jihan.reportings.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import md.mazharul.islam.jihan.reportings.R;

public class SettingsActivity extends AppCompatActivity {

    EditText SenderEmailAddress,
            SenderEmailPassword,
            ReciverEmailAddress;
    ListView SettingListView;
    Button AddReciverMail;
    ImageView LessSecureImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        SenderEmailAddress = (EditText) findViewById(R.id.SenderEmailAddressEditText);
        SenderEmailPassword = (EditText) findViewById(R.id.EmailPasswordEditText);
        ReciverEmailAddress = (EditText) findViewById(R.id.ReciverEmailAddressEditText);

        SettingListView = (ListView) findViewById(R.id.SettingListView);
        AddReciverMail = (Button) findViewById(R.id.EmailAddButton);
        LessSecureImageView = (ImageView) findViewById(R.id.LessSecureImageView);


    }
}
