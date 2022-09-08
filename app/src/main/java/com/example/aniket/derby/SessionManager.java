package com.example.aniket.derby;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by Aniket on 11/03/17.
 */

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserLogin";

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_NAME = "name";

    public static final String KEY_EMAIL = "email";

    public static final String KEY_USER_PREFERENCE_LOCATION ="user_preference_location";

    public static final String KEY_LOCATION="location";

    public static final String KEY_TURF = "turf";

    public static final String KEY_START_TIME = "start_time";

    public static final String KEY_END_TIME = "end_time";

    public static final String KEY_RATING = "rating";

    public static final String KEY_DAYS_ARRAY = "days_array_";

    private static final String IS_USER_PREFERENCES_SET = "isUserPreferencesSet";

    public static final String KEY_ARRAY_SIZE = "array_size";

    public static final String IS_TEAM_SET  = "is_team_set";

    public static final String KEY_TEAM_NAME = "team_name";

    public static final String KEY_TEAM_MEMBER = "team_member_";

    public static final String KEY_USER_PREFERENCE_LEVEL = "user_preference_level";


    public int ARRAY_SIZE;

    public SessionManager( Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String email_id, String name,String location)
    {
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_EMAIL,email_id);
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_LOCATION,location);
        editor.commit();
    }

    public void createUserPreferences(String location, String[] turfs, int startTime, int endTime,String level, float rating, String[] days)
    {


            editor.putInt(KEY_START_TIME,startTime);
            editor.putInt(KEY_END_TIME,endTime);
            editor.putFloat(KEY_RATING,rating);
            editor.putString(KEY_USER_PREFERENCE_LOCATION,location);
        editor.putString(KEY_USER_PREFERENCE_LEVEL,level);
            editor.putInt(KEY_ARRAY_SIZE, days.length);
            for(int i=0;i<days.length; i++)
            editor.putString(KEY_DAYS_ARRAY + (i+1), days[i]);
            for(int i = 0 ; i<turfs.length; i++) {
                editor.putString(KEY_TURF + (i+1), turfs[i]);
            }
            editor.commit();
    }

    public void setIsUserPreferences(boolean isUserPreferencesSet)
    {
        editor.putBoolean(IS_USER_PREFERENCES_SET,isUserPreferencesSet);
        editor.commit();
    }

    public boolean isUserPreferencesSet()
    {
        return sharedPreferences.getBoolean(IS_USER_PREFERENCES_SET,false);
    }

    public void checkLogin()
    {
        if(!this.isLoggedIn())
        {
            Intent i = new Intent(context, MainActivityLogin.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

    public HashMap<String ,String > getUserDetails()
    {
        HashMap<String ,String > userDetails = new HashMap<String ,String >();
        userDetails.put(KEY_EMAIL,sharedPreferences.getString(KEY_EMAIL,null));
        userDetails.put(KEY_NAME,sharedPreferences.getString(KEY_NAME,null));
        userDetails.put(KEY_LOCATION,sharedPreferences.getString(KEY_LOCATION,null));

        return userDetails;
    }

    public HashMap<String ,String > getUserPreferences()
    {
        HashMap<String, String> userPreferences = new HashMap<String, String>();
        userPreferences.put(KEY_USER_PREFERENCE_LOCATION,sharedPreferences.getString(KEY_USER_PREFERENCE_LOCATION,null));
        userPreferences.put(KEY_START_TIME, String.valueOf(sharedPreferences.getInt(KEY_START_TIME,0)));
        ARRAY_SIZE = sharedPreferences.getInt(KEY_ARRAY_SIZE,0);
        userPreferences.put(KEY_END_TIME,String.valueOf(ARRAY_SIZE));
        for(int i = 1 ; i<=5; i++){
            userPreferences.put(KEY_TURF+i,sharedPreferences.getString(KEY_TURF+i,null));
        }
        userPreferences.put(KEY_ARRAY_SIZE,String.valueOf(sharedPreferences.getInt(KEY_ARRAY_SIZE,0)));
        for(int i=1;i<=ARRAY_SIZE; i++)
            userPreferences.put(KEY_DAYS_ARRAY+(i),sharedPreferences.getString(KEY_DAYS_ARRAY+(i),null));
        userPreferences.put(KEY_USER_PREFERENCE_LEVEL,sharedPreferences.getString(KEY_USER_PREFERENCE_LEVEL,null));
        userPreferences.put(KEY_RATING, String.valueOf(sharedPreferences.getFloat(KEY_RATING,0.0f)));
        return userPreferences;
    }

    public void logoutUser()
    {
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, MainActivityLogin.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(i);
    }

    public boolean isLoggedIn()
    {
        return sharedPreferences.getBoolean(IS_LOGIN,false);
    }

    public void setIsTeamSet(boolean isTeamSet)
    {
        editor.putBoolean(IS_TEAM_SET,isTeamSet);
        editor.commit();
    }

    public boolean isTeamSet()
    {
        return sharedPreferences.getBoolean(IS_TEAM_SET,false);
    }

    public void createTeam(String team_name, String[] team_member)
    {
        editor.putString(KEY_TEAM_NAME,team_name);
        for(int i = 0 ; i<5; i++)
        {
            editor.putString(KEY_TEAM_MEMBER+(i+1),team_member[i]);
        }
        editor.commit();
    }
    public HashMap<String ,String> getTeam()
    {
        HashMap<String ,String > team = new HashMap<String, String>();
        team.put(KEY_TEAM_NAME,sharedPreferences.getString(KEY_TEAM_NAME,null));
        for(int i=0; i<5; i++)
        {
            team.put(KEY_TEAM_MEMBER+(i+1),sharedPreferences.getString(KEY_TEAM_MEMBER+(i+1),null));

        }
        return team;
    }
}
