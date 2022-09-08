package com.example.aniket.derby;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChallengeInitialActivity extends AppCompatActivity {
    private Button button_manage_preferences, button_manage_team;
    private FloatingActionButton fab_proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_initial);
        setTitle("Challenge");
        button_manage_preferences = (Button) findViewById(R.id.button_manage_preferences);
        button_manage_team = (Button) findViewById(R.id.button_manage_team);
        fab_proceed  = (FloatingActionButton) findViewById(R.id.fab_proceed);
        button_manage_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChallengeInitialActivity.this,ManagePreferences.class));
            }
        });
        button_manage_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChallengeInitialActivity.this,ManageTeamActivity.class));
            }
        });
        fab_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

         startActivity(new Intent(ChallengeInitialActivity.this,ChallengeMainProcessing.class));

            }
        });
    }
}
