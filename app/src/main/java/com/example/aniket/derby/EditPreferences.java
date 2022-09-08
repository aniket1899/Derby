package com.example.aniket.derby;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;

public class EditPreferences extends AppCompatActivity {
    private static final String[] locations = {"--Select Location--","Thane", "Mulund", "Bhandup", "CST"};
    private static final String[] start_time = {"--Select Time--","06:00 AM","07:00 AM","08:00 AM","09:00 AM","10:00 AM","11:00 AM",
            "12:00 AM","01:00 PM","02:00 PM","03:00 PM","04:00 PM",
            "05:00 PM","06:00 PM","07:00 PM","08:00 PM","09:00 PM",
            "10:00 PM"};
    private static final String[] end_time = {"--Select Time--","07:00 AM","08:00 AM","09:00 AM","10:00 AM","11:00 AM",
            "12:00 AM","01:00 PM","02:00 PM","03:00 PM","04:00 PM",
            "05:00 PM","06:00 PM","07:00 PM","08:00 PM","09:00 PM",
            "10:00 PM","11:00 PM"};
    private static final String[] level= {"--Select Level--", FeedReaderContract.FeedEntry.COLUMN_PREF_LEVEL_AVERAGE,
            FeedReaderContract.FeedEntry.COLUMN_PREF_LEVEL_INTERMEDIATE,
            FeedReaderContract.FeedEntry.COLUMN_PREF_LEVEL_PROFESSIONAL};
    private static ArrayList<String> turf= new ArrayList<String>();

    private String user_preference_location;
    private String user_preference_start_time;
    private String user_preference_end_time;
    private String user_preference_level;
    private String[] user_preference_days = new String[7];
    private String[] user_preference_days_previous = new String[7];
    private SessionManager session;
    CheckBox checkBoxMonday;
    CheckBox checkBoxTuesday ;
    CheckBox checkBoxWednesday;
    CheckBox checkBoxThursday;
    CheckBox checkBoxFriday;
    CheckBox checkBoxSaturday;
    CheckBox checkBoxSunday ;
    FloatingActionButton fab_update;
    PreferenceConversion converter;
    private static String end_time_selected = null;
    private static String location_selected = null;
    private static String start_time_selected = null;
    private static String level_selected = null;
    private static String turf1_selected = null;
    private static String turf2_selected = null;
    private static String turf3_selected = null;
    private static String turf4_selected = null;
    private static String turf5_selected = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_preferences);
        session = new SessionManager(getBaseContext());

        setTitle("Manage Preferences");

        final Spinner spinner_location = (Spinner) findViewById(R.id.spinner_location);
        final Spinner spinner_start_time = (Spinner) findViewById(R.id.spinner_start_time);
        Spinner spinner_end_time = (Spinner) findViewById(R.id.spinner_end_time);
        Spinner spinner_level = (Spinner) findViewById(R.id.spinner_level);
        Spinner spinner_turf1 = (Spinner) findViewById(R.id.spinner_turf1);
        Spinner spinner_turf2 = (Spinner) findViewById(R.id.spinner_turf2);
        Spinner spinner_turf3 = (Spinner) findViewById(R.id.spinner_turf3);
        Spinner spinner_turf4 = (Spinner) findViewById(R.id.spinner_turf4);
        Spinner spinner_turf5 = (Spinner) findViewById(R.id.spinner_turf5);


        session = new SessionManager(getBaseContext());
        converter = new PreferenceConversion();

        final CoordinatorLayout edit_preferences_coordinator_layout = (CoordinatorLayout) findViewById(R.id.edit_preferences_coordinator_layout);
         checkBoxMonday = (CheckBox) findViewById(R.id.checkbox_Monday);
         checkBoxTuesday = (CheckBox) findViewById(R.id.checkbox_Tuesday);
         checkBoxWednesday = (CheckBox) findViewById(R.id.checkbox_Wednesday);
         checkBoxThursday = (CheckBox) findViewById(R.id.checkbox_Thursday);
         checkBoxFriday = (CheckBox) findViewById(R.id.checkbox_Friday);
         checkBoxSaturday = (CheckBox) findViewById(R.id.checkbox_Saturday);
         checkBoxSunday = (CheckBox) findViewById(R.id.checkbox_Sunday);

        turf.add("--Select Turf--");


        final Button button_select_all_days = (Button) findViewById(R.id.button_select_all_days);

        ArrayAdapter<String> adapter_location = new ArrayAdapter<String>(EditPreferences.this, android.R.layout.simple_spinner_dropdown_item, locations);
        spinner_location.setAdapter(adapter_location);


        spinner_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 location_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                location_selected = locations[0];
            }
        });

        ArrayAdapter<String> adapter_start_time = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, start_time);
        spinner_start_time.setAdapter(adapter_start_time);
        spinner_start_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                start_time_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                start_time_selected = start_time[0];
            }
        });
        ArrayAdapter<String> adapter_end_time = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, end_time);
        spinner_end_time.setAdapter(adapter_end_time);
        spinner_end_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 end_time_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                end_time_selected = end_time[0];
            }
        });
        ArrayAdapter<String> adapter_level = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, level);
        spinner_level.setAdapter(adapter_level);
        spinner_level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                level_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                level_selected = level[0];
            }
        });
        ArrayAdapter<String> adapter_turf1 = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, turf);
        spinner_turf1.setAdapter(adapter_turf1);
        spinner_turf1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                turf1_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                turf1_selected = turf.get(0);
            }
        });
        ArrayAdapter<String> adapter_turf2 = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, turf);
        spinner_turf2.setAdapter(adapter_turf2);
        spinner_turf2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                turf2_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                turf2_selected = turf.get(0);
            }
        });
        ArrayAdapter<String> adapter_turf3 = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, turf);
        spinner_turf3.setAdapter(adapter_turf3);
        spinner_turf3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                turf3_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                turf3_selected = turf.get(0);
            }
        });
        ArrayAdapter<String> adapter_turf4 = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, turf);
        spinner_turf4.setAdapter(adapter_turf4);
        spinner_turf4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                turf4_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                turf4_selected = turf.get(0);
            }
        });
        ArrayAdapter<String> adapter_turf5 = new ArrayAdapter<String>(EditPreferences.this,
                android.R.layout.simple_spinner_dropdown_item, turf);
        spinner_turf5.setAdapter(adapter_turf5);
        spinner_turf5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                turf5_selected = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                turf5_selected = turf.get(0);
            }
        });


        if(session.isUserPreferencesSet())
        {
            HashMap<String,String > userPreferences = session.getUserPreferences();
            user_preference_location = userPreferences.get(session.KEY_USER_PREFERENCE_LOCATION);
            user_preference_start_time = converter.convert24to12(Integer.parseInt(userPreferences.get(session.KEY_START_TIME)));
            user_preference_end_time = converter.convert24to12(Integer.parseInt(userPreferences.get(session.KEY_END_TIME)));
            user_preference_level = userPreferences.get(session.KEY_USER_PREFERENCE_LEVEL);
            toast(user_preference_level);
            for(int i = 0 ; i<7; i++)
            {
                user_preference_days[i] = userPreferences.get(session.KEY_DAYS_ARRAY+(i+1));

            }
            Toast.makeText(getBaseContext(),user_preference_days[0]+user_preference_days[1]+user_preference_days[2]+user_preference_days[3]+user_preference_days[4]
                    +user_preference_days[5]+user_preference_days[6],Toast.LENGTH_SHORT).show();
            Toast.makeText(getBaseContext(),userPreferences.get(session.KEY_ARRAY_SIZE),Toast.LENGTH_SHORT).show();
            spinner_location.setSelection(adapter_location.getPosition(user_preference_location));
            spinner_start_time.setSelection(adapter_start_time.getPosition(user_preference_start_time));
            spinner_level.setSelection(adapter_level.getPosition(user_preference_level));
            spinner_end_time.setSelection(adapter_end_time.getPosition(user_preference_end_time));
            if(user_preference_days[0].equals(converter.YES))
                checkBoxMonday.setChecked(true);
            if(user_preference_days[1].equals(converter.YES))
                checkBoxTuesday.setChecked(true);
            if(user_preference_days[2].equals(converter.YES))
                checkBoxWednesday.setChecked(true);
            if(user_preference_days[3].equals(converter.YES))
                checkBoxThursday.setChecked(true);
            if(user_preference_days[4].equals(converter.YES))
                checkBoxFriday.setChecked(true);
            if(user_preference_days[5].equals(converter.YES))
                checkBoxSaturday.setChecked(true);
            if(user_preference_days[6].equals(converter.YES))
                checkBoxSunday.setChecked(true);
        }

        button_select_all_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxMonday.setChecked(true);
                checkBoxTuesday.setChecked(true);
                checkBoxWednesday.setChecked(true);
                checkBoxThursday.setChecked(true);
                checkBoxFriday.setChecked(true);
                checkBoxSaturday.setChecked(true);
                checkBoxSunday.setChecked(true);
                button_select_all_days.setBackgroundColor(Color.LTGRAY);
                button_select_all_days.setClickable(false);
            }
        });




        fab_update = (FloatingActionButton) findViewById(R.id.fab_update);
        fab_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (location_selected.equals(locations[0]) || start_time_selected.equals(start_time[0]) || end_time_selected.equals(end_time[0])) {
                    Snackbar.make(edit_preferences_coordinator_layout, "Select all attributes to proceed", Snackbar.LENGTH_LONG)
                            .show();
                }
                if(session.isUserPreferencesSet()) {
                    String[] daysArray = new String[7];
                    for (int k = 0; k < 7; k++) {
                        daysArray[k] = converter.NO;
                    }

                    if (checkBoxMonday.isChecked()) {
                        daysArray[0] = converter.YES;

                    }
                    if (checkBoxTuesday.isChecked()) {
                        daysArray[1] = converter.YES;

                    }
                    if (checkBoxWednesday.isChecked()) {
                        daysArray[2] = converter.YES;

                    }
                    if (checkBoxThursday.isChecked()) {
                        daysArray[3] = converter.YES;

                    }
                    if (checkBoxFriday.isChecked()) {
                        daysArray[4] = converter.YES;

                    }
                    if (checkBoxSaturday.isChecked()) {
                        daysArray[5] = converter.YES;

                    }
                    if (checkBoxSunday.isChecked()) {
                        daysArray[6] = converter.YES;

                    }
                /*StringBuilder dummy = new StringBuilder();
                for(int k=0;k<daysArray.length;k++)
                    dummy.append(daysArray[k]);
                Toast.makeText(getBaseContext(),location_selected+end_time_selected+start_time_selected,Toast.LENGTH_SHORT).show();*/
                    /*if (location_selected.equals(locations[0]) || start_time_selected.equals(start_time[0]) || end_time_selected.equals(end_time[0])) {
                        Snackbar.make(edit_preferences_coordinator_layout, "Select all attributes to proceed", Snackbar.LENGTH_LONG)
                                .show();
                    }*/
                    if (!end_time_selected.equals(end_time[0]) && !start_time_selected.equals(start_time[0]) &&
                            (converter.convert12to24int(start_time_selected) > converter.convert12to24int(end_time_selected))) {
                        Snackbar.make(edit_preferences_coordinator_layout, "Cannot choose End Time prior to Start Time", Snackbar.LENGTH_LONG)
                                .show();

                    }
                    if (session.isUserPreferencesSet()) {
                        if (location_selected.equals(user_preference_location) &&
                                start_time_selected.equals(user_preference_start_time) &&
                                end_time_selected.equals(user_preference_end_time)) {
                            Snackbar.make(edit_preferences_coordinator_layout, "No changes made. Confirm?", Snackbar.LENGTH_INDEFINITE)
                                    .setAction("OK", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent();
                                            intent.putExtra("ISPREFSET", true);
                                            setResult(RESULT_CANCELED, intent);
                                            finish();
                                        }
                                    })
                                    .setActionTextColor(Color.GREEN)
                                    .show();
                        } else {
                            if (!location_selected.equals(user_preference_location)) {
                                //update location
                                toast("1");
                                updateAndRevert();
                            }
                            if (!start_time_selected.equals(user_preference_start_time)) {
                                //update
                                toast("2");
                                updateAndRevert();
                            }
                            if (!end_time_selected.equals(user_preference_end_time)) {
                                //update
                                toast("3");
                                updateAndRevert();
                            }
                        }
                    }
                    else {
                        //update
                        updateAndRevert();

                    }
                }





            }
        });
    }
    private void toast(String t)
    {
        Toast.makeText(getBaseContext(),t,Toast.LENGTH_SHORT).show();
    }
    private void updateAndRevert()
    {
        //set user prefs
        Intent intent = new Intent();
        intent.putExtra("ISPREFSET",true);
        setResult(RESULT_OK,intent);
        finish();
    }
}
