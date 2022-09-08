package com.example.aniket.derby;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.HashMap;

/**
 * Created by Aniket on 02/04/17.
 */

public final class FeedReaderContract {
    private FeedReaderContract(){}

    public static class FeedEntry implements BaseColumns {

        //table player
        public static final String TABLE_PLAYER = "player";
        public static final String COLUMN_P_ID = "p_id";
        public static final String COLUMN_P_NAME = "p_name";
        public static final String COLUMN_P_EMAILID = "p_emailid";
        public static final String COLUMN_P_DOB = "p_dob";
        public static final String COLUMN_P_PHONE = "p_phone";
        public static final String COLUMN_P_LOCATION = "p_location";
        public static final String COLUMN_P_ADDRESS = "p_address";
        public static final String COLUMN_P_PASSWORD = "p_password";
        public static final String COLUMN_CAPTAIN = "captain";
        public static final String COLUMN_P_PREF_ID = "pref_id";
        public static final String COLUMN_P_TEAM_ID = "team_id";

        //table turf
        public static final String TABLE_TURF = "turf";
        public static final String COLUMN_TURF_ID = "turf_id";
        public static final String COLUMN_TURF_NAME = "turf_name";
        public static final String COLUMN_TURF_LOC = "turf_loc";
        public static final String COLUMN_TURF_ADDRESS = "turf_address";
        public static final String COLUMN_TURF_PHONE = "turf_phone";

        //table turf slots
        public static final String TABLE_TURFSLOTS = "turfslots";
        public static final String COLUMN_TURFSLOTS_ID = "turf_id";
        public static final String COLUMN_TURFSLOTS_SLOTS = "turf_slots";

        //table challengepool
        public static final String TABLE_CHALLENGEPOOL = "challengepool";
        public static final String COLUMN_CHALLENGE_ID = "turf_id";
        public static final String COLUMN_CHALLENGE_P_ID = "p_id";
        public static final String COLUMN_CHALLENGE_TEAM_ID = "team_id";
        public static final String COLUMN_CHALLENGE_PREF_ID = "pref_id";

        //TABLE preference
        public static final String TABLE_PREFERENCE = "preference";
        public static final String COLUMN_PREF_ID = "pref_id";
        public static final String COLUMN_PREF_LOC = "pref_loc";
        public static final String COLUMN_PREF_RATING = "rating";
        public static final String COLUMN_PREF_STARTTIME = "starttime";
        public static final String COLUMN_PREF_ENDTIME = "endtime";
        public static final String COLUMN_PREF_LEVEL_AVERAGE = "Average";
        public static final String COLUMN_PREF_LEVEL_INTERMEDIATE = "Intermediate";
        public static final String COLUMN_PREF_LEVEL_PROFESSIONAL = "Professional";
        public static final String COLUMN_PREF_MONDAY = "monday";
        public static final String COLUMN_PREF_TUESDAY = "tuesday";
        public static final String COLUMN_PREF_WEDNESDAY = "wednesday";
        public static final String COLUMN_PREF_THURSDAY = "thursday";
        public static final String COLUMN_PREF_FRIDAY = "friday";
        public static final String COLUMN_PREF_SATURDAY = "saturday";
        public static final String COLUMN_PREF_SUNDAY = "sunday";

        //table team
        public static final String TABLE_TEAM = "team";
        public static final String COLUMN_TEAM_ID = "team_id";
        public static final String COLUMN_TEAM_NAME = "team_name";
        public static final String COLUMN_TEAM_DESCRIPTION = "description";
        public static final String COLUMN_TEAM_PREF_ID = "pref_id";
        public static final String COLUMN_TEAM_P_ID = "p_id";

        //table match
        public static final String TABLE_MATCH = "match";
        public static final String COLUMN_MATCH_ID = "match_id";
        public static final String COLUMN_CHALLENGERTEAM_ID = "challengerteam_id";
        public static final String COLUMN_CHALLENGEETEAM_ID = "challengeeteam_id";
        public static final String COLUMN_MATCH_LOC = "match_loc";
        public static final String COLUMN_MATCH_STARTTIME = "startime";
        public static final String COLUMN_MATCH_ENDTIME = "endtime";
        public static final String COLUMN_MATCH_TURF_ID = "turf_id";
        public static final String COLUMN_MATCH_BOOKING_ID = "booking_id";

        //table bookturf
        public static final String TABLE_BOOKTURF = "bookturf";
        public static final String COLUMN_BOOKING_ID = "booking_id";
        public static final String COLUMN_BOOKING_MATCHID = "match_id";
        public static final String COLUMN_BOOKING_AVAILIBILITY = "availibility";

        public  long insertQueryTurf(SQLiteDatabase db, String name, String location, String address, String phone)
        {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_TURF_NAME,name);
            contentValues.put(COLUMN_TURF_LOC,location);
            contentValues.put(COLUMN_TURF_ADDRESS,address);
            contentValues.put(COLUMN_TURF_PHONE,phone);
            long newRowId = db.insert(TABLE_TURF, null, contentValues);
            return newRowId;
        }
        public  String getAuthPassword(SQLiteDatabase db,String email)
        {
            String password;
            String select_query = "SELECT " + COLUMN_P_PASSWORD + " FROM ";//change
            Cursor cursor_password = db.rawQuery(select_query,null);
            password = cursor_password.getString(cursor_password.getColumnIndex(COLUMN_P_PASSWORD));
            return password;
        }
        public  HashMap<String,String> getAuthDetails(SQLiteDatabase db, String email, String password)
        {
            HashMap<String ,String > player_details = new HashMap<String ,String>();
            String select_query = "SELECT * ";//change

            Cursor cursor_details = db.rawQuery(select_query,null);
            player_details.put(COLUMN_P_LOCATION,cursor_details.getString(cursor_details.getColumnIndex(COLUMN_P_LOCATION)));
            player_details.put(COLUMN_P_NAME,cursor_details.getString(cursor_details.getColumnIndex(COLUMN_P_NAME)));

            return player_details;
        }
        public boolean checkEmail(SQLiteDatabase db, String email)
        {
            String select_query = "SELECT ";//change
            Cursor cursor_email = null;
            cursor_email = db.rawQuery(select_query,null);
            if(cursor_email!=null)
            {
                return true;
            }
            else return false;
        }
        public String getUserID(SQLiteDatabase db, String email)
        {
            String select_query = "SELECT ";//change
            Cursor cursor_id = db.rawQuery(select_query,null);
            return cursor_id.getString(cursor_id.getColumnIndex(COLUMN_P_ID));
        }
        public HashMap<String ,String > getPreferencesDB(SQLiteDatabase db,String ID)
        {
            HashMap<String ,String > prefDB = new HashMap<String,String >();
            String select_query = "SELECT * FROM";//change
            Cursor cursor_pref = db.rawQuery(select_query,null);
            prefDB.put(COLUMN_PREF_LOC,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_LOC)));
            prefDB.put(COLUMN_PREF_RATING,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_RATING)));
            prefDB.put(COLUMN_PREF_STARTTIME, String.valueOf(cursor_pref.getInt(cursor_pref.getColumnIndex(COLUMN_PREF_STARTTIME))));
            prefDB.put(COLUMN_PREF_ENDTIME, String.valueOf(cursor_pref.getInt(cursor_pref.getColumnIndex(COLUMN_PREF_ENDTIME))));
            prefDB.put(COLUMN_PREF_MONDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_MONDAY)));
            prefDB.put(COLUMN_PREF_TUESDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_TUESDAY)));
            prefDB.put(COLUMN_PREF_WEDNESDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_WEDNESDAY)));
            prefDB.put(COLUMN_PREF_THURSDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_THURSDAY)));
            prefDB.put(COLUMN_PREF_FRIDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_FRIDAY)));
            prefDB.put(COLUMN_PREF_SATURDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_SATURDAY)));
            prefDB.put(COLUMN_PREF_SUNDAY,cursor_pref.getString(cursor_pref.getColumnIndex(COLUMN_PREF_SUNDAY)));

            return prefDB;
        }

    }
}
