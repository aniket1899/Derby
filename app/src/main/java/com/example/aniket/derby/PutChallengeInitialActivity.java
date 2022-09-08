package com.example.aniket.derby;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.aniket.derby.R.id.fab_put_challenge_initial_proceed;

public class PutChallengeInitialActivity extends AppCompatActivity {

    private static FloatingActionButton fab_proceed;
    private static Button button_manage_preferences;
    private static Button button_manage_team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_challenge_initial);
        setTitle("Put Challenge");
        fab_proceed = (FloatingActionButton) findViewById(fab_put_challenge_initial_proceed);
        button_manage_preferences = (Button) findViewById(R.id.button_manage_preferences);
        button_manage_team = (Button) findViewById(R.id.button_manage_team);

        fab_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PutChallengeInitialActivity.this,PutChallengeMainActivity.class));
            }
        });

        button_manage_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PutChallengeInitialActivity.this,ManagePreferences.class));

            }
        });
        button_manage_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PutChallengeInitialActivity.this,ManageTeamActivity.class));

            }
        });
    }
}
