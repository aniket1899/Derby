package com.example.aniket.derby;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class EditTeam extends AppCompatActivity {
    private static EditText team_name;
    private static TextView team_member1;
    private static EditText team_member2;
    private static EditText team_member3;
    private static EditText team_member4;
    private static EditText team_member5;
    private static FloatingActionButton fab_confirm;
    private static String pref_team_name;
    private static ArrayList<String > pref_team_members = new ArrayList<String>();
    private static String player_name;
    SessionManager session;
    private static HashMap<String ,String > team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);
        setTitle("Manage Team");
        team_member1 = (TextView) findViewById(R.id.edit_team_member1);
        team_member2 = (EditText) findViewById(R.id.edit_team_member2);
        team_member3 = (EditText) findViewById(R.id.edit_team_member3);
        team_member4 = (EditText) findViewById(R.id.edit_team_member4);
        team_member5 = (EditText) findViewById(R.id.edit_team_member5);
        team_name = (EditText) findViewById(R.id.edit_team_name);
        fab_confirm = (FloatingActionButton) findViewById(R.id.fab_confirm_team);
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutEditTeam);
        session = new SessionManager(getBaseContext());

        if(session.isTeamSet()) {
            team = session.getTeam();
            pref_team_name = team.get(session.KEY_TEAM_NAME);
            pref_team_members.add(team.get(session.KEY_TEAM_MEMBER + "1"));
            pref_team_members.add(team.get(session.KEY_TEAM_MEMBER + "2"));
            pref_team_members.add(team.get(session.KEY_TEAM_MEMBER + "3"));
            pref_team_members.add(team.get(session.KEY_TEAM_MEMBER + "4"));
            pref_team_members.add(team.get(session.KEY_TEAM_MEMBER + "5"));
            setData();
        }


            fab_confirm.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   if (team_name.getText().toString().isEmpty() || team_member1.getText().toString().isEmpty() || team_member2.getText().toString().isEmpty() ||
                                                           team_member3.getText().toString().isEmpty() || team_member4.getText().toString().isEmpty() || team_member5.getText().toString().isEmpty()) {
                                                       Snackbar.make(coordinatorLayout, "Fill out all fields", Snackbar.LENGTH_LONG)
                                                               .show();
                                                   }
                                                   if (session.isTeamSet()) {
                                                       /*if (team_name.getText().toString().isEmpty() || team_member1.getText().toString().isEmpty() || team_member2.getText().toString().isEmpty() ||
                                                               team_member3.getText().toString().isEmpty() || team_member4.getText().toString().isEmpty() || team_member5.getText().toString().isEmpty()) {
                                                           Snackbar.make(coordinatorLayout, "Fill out all fields", Snackbar.LENGTH_LONG)
                                                                   .show();
                                                       } else*/
                                                       if (team_name.getText().toString().equals(pref_team_name)
                                                               && team_member2.getText().toString().equals(pref_team_members.get(1)) && team_member3.getText().toString().equals(pref_team_members.get(2))
                                                               && team_member4.getText().toString().equals(pref_team_members.get(3)) && team_member5.getText().toString().equals(pref_team_members.get(4))) {
                                                           final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(EditTeam.this);
                                                           alertDialogBuilder.setTitle("Manage Team")
                                                                   .setMessage("No changes made. Do you want to proceed?")
                                                                   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(DialogInterface dialogInterface, int i) {
                                                                           finish();
                                                                       }
                                                                   })
                                                                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                       @Override
                                                                       public void onClick(DialogInterface dialogInterface, int i) {

                                                                       }
                                                                   });
                                                           AlertDialog alertDialog = alertDialogBuilder.create();
                                                           alertDialog.show();
                                                           alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
                                                           alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));

                                                       } else {
                                                           if (!team_name.getText().toString().equals(pref_team_name)) {
                                                               //update team name
                                                               toast("tn");
                                                           }

                                                           if (!team_member2.getText().toString().equals(pref_team_members.get(1))) {
                                                               //update
                                                               toast("t2");

                                                           }
                                                           if (!team_member3.getText().toString().equals(pref_team_members.get(2))) {
                                                               //update
                                                               toast("t3");

                                                           }
                                                           if (!team_member4.getText().toString().equals(pref_team_members.get(3))) {
                                                               //update
                                                               toast("t4");

                                                           }
                                                           if (!team_member5.getText().toString().equals(pref_team_members.get(4))) {
                                                               //update
                                                               toast("t5");

                                                           }
                                                        updateAndRevert();
                                                       }
                                                   }
                                                   else {
                                                       //update
                                                       updateAndRevert();

                                                   }

                                               }
                                           }

            );


    }
    private void toast(String t)
    {
        Toast.makeText(getBaseContext(),t,Toast.LENGTH_SHORT).show();
    }
    private void setData()
    {
        team_name.setText(pref_team_name);
        team_member1.setText(pref_team_members.get(0));
        team_member2.setText(pref_team_members.get(1));
        team_member3.setText(pref_team_members.get(2));
        team_member4.setText(pref_team_members.get(3));
        team_member5.setText(pref_team_members.get(4));
    }
    private void updateAndRevert()
    {
        //set user prefs
        Intent intent = new Intent();
        intent.putExtra("ISTEAMSET",true);
        setResult(RESULT_OK,intent);
        finish();
    }
}
