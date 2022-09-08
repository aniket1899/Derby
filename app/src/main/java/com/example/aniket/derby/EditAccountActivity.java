package com.example.aniket.derby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class EditAccountActivity extends AppCompatActivity {

    private String user_location;
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        setTitle("Manage Preferences");

        EditText name = (EditText) findViewById(R.id.edit_account_name);
        EditText email = (EditText) findViewById(R.id.edit_account_email);
        session = new SessionManager(getBaseContext());

        HashMap<String,String> user_details = session.getUserDetails();
        String user_name = user_details.get(session.KEY_NAME);
        String user_email = user_details.get(session.KEY_EMAIL);

        name.setText(user_name);
        email.setText(user_email);





    }


}
