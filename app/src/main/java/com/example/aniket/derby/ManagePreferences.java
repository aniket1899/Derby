package com.example.aniket.derby;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagePreferences extends AppCompatActivity {
    private static FloatingActionButton fabEdit;
    private static TextView location;
    private static TextView start_time;
    private static TextView end_time;
    private static TextView days;
    private static TextView turf1;
    private static TextView turf2;
    private static TextView turf3;
    private static TextView turf4;
    private static TextView turf5;
    private static TextView level;
    private static SessionManager session;
    private static PreferenceConversion converter;
    private static ArrayList<String > user_pref_days = new ArrayList<String>();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_manage_preferences, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_confirm:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_preferences);
        setTitle("Preferences");
        fabEdit= (FloatingActionButton) findViewById(R.id.fab_edit);
        location = (TextView) findViewById(R.id.pref_location);
        start_time = (TextView) findViewById(R.id.pref_start_time);
        end_time = (TextView) findViewById(R.id.pref_end_time);
        days = (TextView) findViewById(R.id.pref_days);
        turf1 = (TextView) findViewById(R.id.pref_turf1);
        turf2 = (TextView) findViewById(R.id.pref_turf2);
        turf3 = (TextView) findViewById(R.id.pref_turf3);
        turf4 = (TextView) findViewById(R.id.pref_turf4);
        turf5 = (TextView) findViewById(R.id.pref_turf5);
        level = (TextView) findViewById(R.id.pref_level);
        converter = new PreferenceConversion();

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startEditPreferences();            }
        });

        session = new SessionManager(getBaseContext());
        if(!session.isUserPreferencesSet())
        {

            location.setText("--");
            start_time.setText("--");
            end_time.setText("--");
            days.setText("--");
            level.setText("--");
            turf1.setText("--");
            turf2.setText("--");
            turf3.setText("--");
            turf4.setText("--");
            turf5.setText("--");

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ManagePreferences.this);
            alertDialogBuilder.setTitle("Manage preferences?")

                    .setMessage("User Preferences are not yet set. Do you want to set it up?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startEditPreferences();

                        }
                    })
                    .setNegativeButton("Not right now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                    .setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));

        }
        else {
            setData();
        }




    }

    private void startEditPreferences()
    {
        startActivityForResult(new Intent(getBaseContext(),EditPreferences.class),RESULT_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK)
        {
            if(data.getBooleanExtra("ISPREFSET",false))
            {
                setData();
            }
        }
    }
    private void setData()
    {
        HashMap<String ,String > userPreferences = session.getUserPreferences();
        location.setText(userPreferences.get(session.KEY_USER_PREFERENCE_LOCATION));
        start_time.setText(converter.convert24to12(Integer.parseInt(userPreferences.get(session.KEY_START_TIME))));
        end_time.setText(converter.convert24to12(Integer.parseInt(userPreferences.get(session.KEY_END_TIME))));
        level.setText(userPreferences.get(session.KEY_USER_PREFERENCE_LEVEL));
        turf1.setText(userPreferences.get(session.KEY_TURF+"1"));
        turf2.setText(userPreferences.get(session.KEY_TURF+"2"));
        turf3.setText(userPreferences.get(session.KEY_TURF+"3"));
        turf4.setText(userPreferences.get(session.KEY_TURF+"4"));
        turf5.setText(userPreferences.get(session.KEY_TURF+"5"));
        StringBuilder weekdays = new StringBuilder();

        for(int i=0;i<Integer.parseInt(userPreferences.get(session.KEY_ARRAY_SIZE));i++)
        {

            String str = userPreferences.get(session.KEY_DAYS_ARRAY+(i+1));
            user_pref_days.add(str);
        }

        weekdays = converter.getDays(user_pref_days);
        days.setText(weekdays);


    }
}