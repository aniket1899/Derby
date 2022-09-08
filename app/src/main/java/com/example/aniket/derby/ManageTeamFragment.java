package com.example.aniket.derby;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

import static android.app.Activity.RESULT_OK;


public class ManageTeamFragment extends Fragment {

    private static TextView team_name;
    private static TextView team_member_1;
    private static TextView team_member_2;
    private static TextView team_member_3;
    private static TextView team_member_4;
    private static TextView team_member_5;
    SessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_manage_team, container, false);
        FloatingActionButton fab_edit_team = (FloatingActionButton) rootView.findViewById(R.id.fab_edit_team);
        fab_edit_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startEditTeam();
            }
        });
        team_name = (TextView) rootView.findViewById(R.id.manage_team_team_name);
        team_member_1 = (TextView) rootView.findViewById(R.id.manage_team_member_1);
        team_member_2 = (TextView) rootView.findViewById(R.id.manage_team_member_2);
        team_member_3 = (TextView) rootView.findViewById(R.id.manage_team_member_3);
        team_member_4 = (TextView) rootView.findViewById(R.id.manage_team_member_4);
        team_member_5 = (TextView) rootView.findViewById(R.id.manage_team_member_5);

        session = new SessionManager(getActivity());

        if(session.isTeamSet())
        {
         setData();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setTitle("Manage preferences?")

                    .setMessage("User Preferences are not yet set. Do you want to set it up?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startEditTeam();
                        }
                    })
                    /*.setNegativeButton("Not right now", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })*/;
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            /*alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                    .setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));*/
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
                    .setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));

        }

        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_OK)
        {
            if(data.getBooleanExtra("ISTEAMSET",false))
            {
                setData();
            }
        }
    }
private void setData()
{
    HashMap<String ,String > team = session.getTeam();
    team_name.setText(team.get(session.KEY_TEAM_NAME));
    team_member_1.setText(team.get(session.KEY_TEAM_MEMBER+"1"));
    team_member_2.setText(team.get(session.KEY_TEAM_MEMBER+"2"));
    team_member_3.setText(team.get(session.KEY_TEAM_MEMBER+"3"));
    team_member_4.setText(team.get(session.KEY_TEAM_MEMBER+"4"));
    team_member_5.setText(team.get(session.KEY_TEAM_MEMBER+"5"));
}
private void startEditTeam()
{
    startActivityForResult(new Intent(getActivity(),EditTeam.class),RESULT_OK);

}
}
