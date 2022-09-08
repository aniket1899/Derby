package com.example.aniket.derby;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class HomeActivityNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SessionManager session;
    private static boolean db_isUserPreferencesSet;
    private static String db_location;
    private static String db_level;
    private static String[] db_turfs = new String[5];
    private static int db_start_time_24h, db_end_time_24h;
    private static float db_rating;
    private static String[] db_days = new String[7];
    private static boolean db_is_team_set;
    private static String db_team_name;
    private static String[] db_team_members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_home_nav_bar);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);

                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutHome);


                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                        HomeActivityNavBar.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                drawer.addDrawerListener(toggle);
                toggle.syncState();

                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                if (navigationView != null) {
                    navigationView.setNavigationItemSelectedListener(HomeActivityNavBar.this);
                    setTitle("Derby");
                    setFragment(new HomeFragment());
                    navigationView.getMenu().getItem(0).setChecked(true);
                }
                View  hView =  navigationView.getHeaderView(0);
        TextView text_header_name = (TextView)hView.findViewById(R.id.text_header_name);
        TextView text_header_email = (TextView)hView.findViewById(R.id.text_header_email);


//Sqlite
        db_isUserPreferencesSet = true;
        db_location = "Thane";
        db_turfs = new String[]{"Dribble, Thane","Kalidas, Mulund","Upvan, Thane","Trickshot, Thane","Urban Sports, Thane"};
        db_start_time_24h = 16;
        db_end_time_24h = 18;
        db_level = FeedReaderContract.FeedEntry.COLUMN_PREF_LEVEL_INTERMEDIATE;
        db_rating = 2.5f;
        db_days= new String[]{"y", "y", "y", "n", "n", "y", "y"};
        db_is_team_set = true;
        db_team_name = "Your Team Name";
        //session
        session = new SessionManager(getApplicationContext());

        HashMap<String,String> userDetails = new HashMap<String, String>();
        userDetails = session.getUserDetails();

        text_header_name.setText(userDetails.get(session.KEY_NAME));
        text_header_email.setText(userDetails.get(session.KEY_EMAIL));



        db_team_members = new String[]{userDetails.get(session.KEY_NAME),"Team Member1","Team Member2","Team Member3","Team Member4"};

        session.checkLogin();
        session.setIsUserPreferences(db_isUserPreferencesSet);
        if(session.isUserPreferencesSet())
        {
            session.createUserPreferences(db_location,db_turfs,db_start_time_24h,db_end_time_24h,db_level,db_rating,db_days);


        }
        else {

            Snackbar snackbar = Snackbar.make(coordinatorLayout,"User Preferences not set. Set it up now?",Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(HomeActivityNavBar.this,ManagePreferences.class));
                        }
                    })
                    .setActionTextColor(Color.GREEN);
            snackbar.show();

        }
        session.setIsTeamSet(db_is_team_set);
        if(session.isTeamSet()) {
            session.createTeam(db_team_name, db_team_members);
        }else {

            Snackbar snackbar = Snackbar.make(coordinatorLayout,"Team not set. Set it up now?",Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(HomeActivityNavBar.this,ManagePreferences.class));
                        }
                    })
                    .setActionTextColor(Color.GREEN);
            snackbar.show();

        }

        /*View view = findViewById(R.id.header_home);
        TextView header_name = (TextView) findViewById(R.id.text_header_name);
        TextView header_email = (TextView) findViewById(R.id.text_header_email);
        HashMap<String ,String > userDetails = session.getUserDetails();
        header_name.setText(userDetails.get(session.KEY_NAME));
        header_email.setText(userDetails.get(session.KEY_EMAIL));*/
    }
    protected void toast(String text)
    {
        Toast.makeText(HomeActivityNavBar.this,text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity_nav_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }
        if (id == R.id.action_logout)
        {
            session.logoutUser();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home)
        {
            setFragment(new HomeFragment(),item);
        }
        else if (id == R.id.nav_my_account) {
                setFragment(new AccountFragment(),item);
        } else if (id == R.id.nav_manage_team) {
                setFragment(new ManageTeamFragment(),item);
        } else if (id == R.id.nav_manage_preferences) {
            startActivity(new Intent(getBaseContext(),ManagePreferences.class));

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_help_feedback) {

        } else if (id == R.id.nav_about_us) {

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    protected void setFragment(Fragment fragment, MenuItem item)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout_main,fragment).addToBackStack( "tag" ).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
    }
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_layout_main, fragment).commit();
    }

}
