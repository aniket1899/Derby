package com.example.aniket.derby;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PutChallengeMainActivity extends AppCompatActivity {
    private static Button buttonPutChallenge;
    private static TextView main_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_challenge_main);
        main_text = (TextView) findViewById(R.id.put_challenge_main_result_text);
        buttonPutChallenge = (Button) findViewById(R.id.put_challenge_main_button_progress);
        buttonPutChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncTaskPutChallenge().execute("yes");
            }
        });
    }

   private class AsyncTaskPutChallenge extends AsyncTask<String ,String ,String >
   {
       private ProgressDialog progressDialog;
       @Override
       protected void onPreExecute() {
           progressDialog = new ProgressDialog(PutChallengeMainActivity.this);
           progressDialog.setIndeterminate(true);
           progressDialog.setMessage("Putting Challenge...");
           progressDialog.show();
       }

       @Override
       protected void onPostExecute(String s) {

           progressDialog.cancel();

           final Handler handler = new Handler();
           handler.postDelayed(new Runnable() {
               @Override
               public void run() {
                   buttonPutChallenge.setVisibility(View.GONE);
                   main_text.setText("Challenge entered successfully!");
               }
               },3000);
           Toast.makeText(PutChallengeMainActivity.this,"Challenge entered successfully!",Toast.LENGTH_LONG).show();
           Intent intent = new Intent(PutChallengeMainActivity.this,HomeActivityNavBar.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
           finish();

       }

       @Override
       protected String doInBackground(String... strings) {

           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           //put challenge

           return null;
       }
   }
}
