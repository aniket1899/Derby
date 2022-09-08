package com.example.aniket.derby;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ChallengeMainProcessing extends AppCompatActivity {
    private static ProgressBar progressBar;
    private static ArrayList<String> arrayListID;
    private static TextView result_text;
    private static Button button_progress;
    private static TextView finding_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_main_processing);

        progressBar = (ProgressBar) findViewById(R.id.challenge_main_progress_bar);
        result_text = (TextView) findViewById(R.id.challenge_main_result_text);
        button_progress = (Button) findViewById(R.id.challenge_main_button_progress);
        finding_text = (TextView) findViewById(R.id.challenge_main_finding_text);
        new AsyncTaskFindChallenges().execute("yes");
    }

    private class AsyncTaskFindChallenges extends AsyncTask<String,String ,Integer>
    {
        @Override
        protected void onPreExecute() {
            Toast.makeText(ChallengeMainProcessing.this,"Finding match(es) for you. This might take some time...",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Integer doInBackground(String... strings) {

            arrayListID = new ArrayList<String>();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            arrayListID.add("1");
            arrayListID.add("2");
            arrayListID.add("3");
            arrayListID.add("4");
            arrayListID.add("5");

            return arrayListID.size();
        }

        @Override
        protected void onPostExecute(Integer arrayListIDSize) {
            Toast.makeText(ChallengeMainProcessing.this,Integer.toString(arrayListIDSize),Toast.LENGTH_SHORT).show();

            progressBar.setVisibility(View.GONE);
            finding_text.setVisibility(View.GONE);
            button_progress.setVisibility(View.VISIBLE);
            result_text.setVisibility(View.VISIBLE);
            if(arrayListIDSize <= 0)
            {
                result_text.setText("No matches found. Would you like to put a challenge in the challenge pool for other players to accept?");
                button_progress.setText("Put a Challenge");
                button_progress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
/*
                        startActivity(new Intent(ChallengeMainProcessing.this,));
*/

                    }
                });
            }else
            {
                result_text.setText(arrayListIDSize+" Matches Found!");
                button_progress.setText("View Matches");
                button_progress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ChallengeMainProcessing.this,MatchResult.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("ArrayList",(Serializable)arrayListID);
                        intent.putExtra("Bundle",bundle);
                        startActivity(intent);
                    }
                });
            }

        }
    }
}
