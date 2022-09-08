package com.example.aniket.derby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.action_search:
                toast("search");
                return true;
            case R.id.action_help:
                toast("help");
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CardView cardChallenge = (CardView) findViewById(R.id.card_view_Challenge_a_team);
        CardView cardSearch = (CardView) findViewById(R.id.card_view_Search_team);
        CardView cardBook = (CardView) findViewById(R.id.card_view_Book_turf_slots);
        CardView cardEvents = (CardView) findViewById(R.id.card_view_Events);

        cardChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Chalenge");
            }
        });

        cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Search");
            }
        });

        cardBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Book");
            }
        });

        cardEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("Events");
            }
        });

    }
    protected void toast(String text)
    {
        Toast.makeText(HomeActivity.this,text,Toast.LENGTH_SHORT).show();
    }
}
