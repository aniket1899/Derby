package com.example.aniket.derby;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.delay;

public class MainActivityLogin extends Activity {
    private static EditText email;
    private static EditText password;
    private static Button login;
    private static Button register;
    private static Button loadDB;
    private static SessionManager session;
    private static String location;
    private static String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        email = (EditText) findViewById(R.id.e_email);
        password = (EditText) findViewById(R.id.e_password);
        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_register);
        loadDB = (Button) findViewById(R.id.login_load_db);

        session = new SessionManager(getApplicationContext());

        if(session.isLoggedIn())
        {
            Intent intent_login = new Intent(MainActivityLogin.this,HomeActivityNavBar.class);
            intent_login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent_login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent_login);
            finish();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!email.getText().toString().contains("@")||!email.getText().toString().contains(".")||email.getText().toString().isEmpty())
                {
                    email.setError("Enter valid Email ID");
                }
                if(password.getText().toString().isEmpty()||password.getText().toString().length()<6)
                {
                    password.setError("Enter valid password");
                }
                else{
                        new AsyncAuthenticate().execute(email.getText().toString(),password.getText().toString());
                     /*final ProgressDialog progressDialog = new ProgressDialog(MainActivityLogin.this);
                     progressDialog.setIndeterminate(true);
                     progressDialog.setMessage("Logging in...");
                     progressDialog.show();*/
                    /*final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Do something after 5s = 5000ms
                            if(email.getText().toString().equals("a@a.com")||email.getText().toString().equals("b@b.com"))
                            {

                                if(password.getText().toString().equals("abc1234"))
                                {
                                    //get name and location from db
                                    name = "Aaaaa Aaaaa";
                                    location="Mulund";

                                    session.createLoginSession(email.getText().toString(),name,location);

                                    Intent intent_login = new Intent(MainActivityLogin.this,HomeActivityNavBar.class);
                                    intent_login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent_login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent_login);
                                    finish();
                                }
                                else{
                                    progressDialog.cancel();
                                    createDialog("Incorrect password. Try again.");
                                }
                            }
                    else {
                                progressDialog.cancel();
                                createDialog("Incorrect email. Try again");
                            }

                        }
                    }, 5000);*/



                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_register = new Intent(MainActivityLogin.this,Register.class);
                startActivity(intent_register);
            }
        });

        loadDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncLoginDatabaseRunner().execute("a");
            }
        });
    }
    private void createDialog(String message)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivityLogin.this);
        alertDialogBuilder.setTitle("Manage preferences?")
                .setIcon(R.drawable.ic_edit_black_24dp)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        password.setText("");
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(MainActivityLogin.this, R.color.colorPrimary));

    }



private class AsyncLoginDatabaseRunner extends AsyncTask<String,String ,String >
{
     private ProgressDialog progressDialog;
    @Override
    protected String doInBackground(String... strings) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return strings[0];
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.cancel();
        Toast.makeText(MainActivityLogin.this,"DB created"+s,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPreExecute() {
        loadDB.setVisibility(View.GONE);
         progressDialog = new ProgressDialog(MainActivityLogin.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating and initializing db...");
        progressDialog.show();
    }
}
private class AsyncAuthenticate extends AsyncTask<String,String,String>
{
    private ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final  String s_email = strings[0];
        final  String s_password = strings[1];

        //db operations
        final String db_email = "a@a.com";
        final String db_password = "abc1234";


                if(s_email.equals(db_email)||s_email.equals("yourname@mail.com"))
                {

                    if(s_password.equals(db_password))
                    {
                        //get name and location from db
                        final String db_location = "Thane";
                        final String db_name = "Your Name";

                        session.createLoginSession("yourname@mail.com",db_name,db_location);

                        Intent intent_login = new Intent(MainActivityLogin.this,HomeActivityNavBar.class);
                        intent_login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent_login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent_login);
                        finish();
                    }
                    else{
                        progressDialog.cancel();
                        createDialog("Incorrect password. Try again.");
                    }
                }
                else {
                    progressDialog.cancel();
                    createDialog("Incorrect email. Try again");
                }

        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(MainActivityLogin.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.cancel();
    }
}
}
