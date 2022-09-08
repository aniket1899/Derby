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
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MatchResult extends AppCompatActivity {
    private static RecyclerView recyclerView;
    private static MatchResultAdapter adapter;
    private static List<ChallengerMatchResult> resultList;
    private static String name;
    private static String startTime;
    private static String endTime;
    private static String level;
    private static String location;
    private static String days;
    private static String turf1;
    private static String turf2;
    private static String turf3;
    private static String turf4;
    private static String turf5;
    private static ArrayList<String > arrayListID;
    private static FloatingActionButton fab_match_result_reject;
    private static int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_result);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_match_result);
        fab_match_result_reject = (FloatingActionButton) findViewById(R.id.match_result_reject);
        resultList = new ArrayList<>();
        adapter = new MatchResultAdapter(MatchResult.this, resultList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        arrayListID = new ArrayList<String >();

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Bundle");
        arrayListID = (ArrayList<String>) bundle.getSerializable("ArrayList");
        if(arrayListID.size()>0)
        Toast.makeText(MatchResult.this,arrayListID.size()+arrayListID.get(0)+arrayListID.get(1)+arrayListID.get(2)+arrayListID.get(3)
                +arrayListID.get(4),Toast.LENGTH_SHORT).show();

        position = 0;


        populateCards(arrayListID.get(position));
        adapter.notifyDataSetChanged();

        fab_match_result_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAt(0);
                position++;
                if(position+1>arrayListID.size())
                {
                    fab_match_result_reject.setVisibility(View.GONE);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MatchResult.this);
                    alertDialogBuilder.setTitle("No More Matches")
                            .setIcon(R.drawable.ic_edit_black_24dp)
                            .setMessage("There are no more matches for you. Do you want to put your Challenge in the Challenge Pool?")
                            .setPositiveButton("Put Challenge", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
/*
                                    startActivity(new Intent(MatchResult.this,.class));
*/
                                }
                            })
                            .setNegativeButton("Home", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                Intent intent1 = new Intent(MatchResult.this,HomeActivityNavBar.class);
                                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent1);
                                    finish();

                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                    alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
                    alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));

                }
                else {

                    populateCards(arrayListID.get(position));
                    adapter.notifyDataSetChanged();

                }
            }
        });

    }
    private void populateCards(String ID)
    {
        //get details from ID

        name = "Name";
        startTime = "07:00 PM";
        endTime = "09:00 PM";
        location = "Thane";
        level = "Intermediate";
        days = "Monday\nFriday\nSaturday";
        turf1 = "Turf 1";
        turf2 = "Turf 2";
        turf3 = "Turf 3";
        turf4 = "Turf 4";
        turf5 = "Turf 5";

        resultList.add(new ChallengerMatchResult(name,ID,startTime,endTime,location,level,days,turf1,turf2,turf3,turf4,turf5));

    }
    private void removeAt(int position)
    {
        resultList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, resultList.size());

    }

}
