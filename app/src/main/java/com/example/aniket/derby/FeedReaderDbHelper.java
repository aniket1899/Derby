package com.example.aniket.derby;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.aniket.derby.FeedReaderContract.FeedEntry;

/**
 * Created by Aniket on 02/04/17.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Derby.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //table Create Statements
//create table player
    private static final String CREATE_TABLE_PLAYER = "CREATE TABLE "
            + FeedEntry.TABLE_PLAYER + "(" + FeedEntry.COLUMN_P_ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_P_NAME
            + " TEXT," + FeedEntry.COLUMN_P_EMAILID + " TEXT," + FeedEntry.COLUMN_P_DOB
            + " DATETIME" + FeedEntry.COLUMN_P_PHONE + " INTEGER," + FeedEntry.COLUMN_P_ADDRESS + " TEXT,"
            + FeedEntry.COLUMN_P_PASSWORD + " TEXT," + FeedEntry.COLUMN_CAPTAIN + " BOOLEAN," + FeedEntry.COLUMN_P_PREF_ID + " INTEGER,"
            + FeedEntry.COLUMN_P_TEAM_ID + " INTEGER,"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_P_PREF_ID + ") REFERENCES " + FeedEntry.TABLE_PREFERENCE +
            " (" + FeedEntry.COLUMN_PREF_ID + " ),"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_P_TEAM_ID + ") REFERENCES " + FeedEntry.TABLE_TEAM +
            " (" + FeedEntry.COLUMN_TEAM_ID + " )"
            +")";


    //create table turf
    private static final String CREATE_TABLE_TURF = "CREATE TABLE "
            + FeedEntry.TABLE_TURF + "(" + FeedEntry.COLUMN_TURF_ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_TURF_NAME
            + " TEXT," + FeedEntry.COLUMN_TURF_LOC + " TEXT," + FeedEntry.COLUMN_TURF_ADDRESS + " TEXT,"
            + FeedEntry.COLUMN_TURF_PHONE + " INTEGER" + ")";

    //create table turfslots
    private static final String CREATE_TABLE_TURFSLOTS = "CREATE TABLE "
            + FeedEntry.TABLE_TURFSLOTS + "(" + FeedEntry.COLUMN_TURFSLOTS_ID + " INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_TURFSLOTS_SLOTS + " TEXT,"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_TURFSLOTS_ID + ") REFERENCES " + FeedEntry.TABLE_TURF +
            " (" + FeedEntry.COLUMN_TURF_ID + " )"
            + ")";


    //create table challenge pool
    private static final String CREATE_TABLE_CHALLENGEPOOL = "CREATE TABLE "
            + FeedEntry.TABLE_CHALLENGEPOOL + "(" + FeedEntry.COLUMN_CHALLENGE_ID + " INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_CHALLENGE_TEAM_ID + " INTEGER," + FeedEntry.COLUMN_CHALLENGE_P_ID + " INTEGER,"
            + FeedEntry.COLUMN_CHALLENGE_PREF_ID + " INTEGER,"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_CHALLENGE_TEAM_ID + ") REFERENCES " + FeedEntry.TABLE_TEAM +
            " (" + FeedEntry.COLUMN_TEAM_ID + " ),"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_CHALLENGE_P_ID + ") REFERENCES " + FeedEntry.TABLE_PLAYER +
            " (" + FeedEntry.COLUMN_P_ID + " ),"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_CHALLENGE_PREF_ID + ") REFERENCES " + FeedEntry.TABLE_PREFERENCE +
            " (" + FeedEntry.COLUMN_PREF_ID + " )"
            + ")";

    private static final String CREATE_TABLE_PREFERENCE = "CREATE TABLE "
            + FeedEntry.TABLE_PREFERENCE + "(" + FeedEntry.COLUMN_PREF_ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_PREF_LOC
            + " TEXT," + FeedEntry.COLUMN_PREF_RATING + " INTEGER," + FeedEntry.COLUMN_PREF_STARTTIME
            + " TIME," + FeedEntry.COLUMN_PREF_ENDTIME + " TIME," + FeedEntry.COLUMN_PREF_MONDAY + " BOOLEAN,"
            + FeedEntry.COLUMN_PREF_TUESDAY + " BOOLEAN," + FeedEntry.COLUMN_PREF_WEDNESDAY + " BOOLEAN,"
            + FeedEntry.COLUMN_PREF_THURSDAY + " BOOLEAN," + FeedEntry.COLUMN_PREF_FRIDAY + " BOOLEAN,"
            + FeedEntry.COLUMN_PREF_SATURDAY + " BOOLEAN," + FeedEntry.COLUMN_PREF_SUNDAY + " BOOLEAN"
            + ")";

    //create table team
    private static final String CREATE_TABLE_TEAM = "CREATE TABLE "
            + FeedEntry.TABLE_TEAM + "(" + FeedEntry.COLUMN_TEAM_ID + " INTEGER PRIMARY KEY," + FeedEntry.COLUMN_TEAM_NAME
            + " TEXT," + FeedEntry.COLUMN_TEAM_DESCRIPTION + " TEXT," + FeedEntry.COLUMN_TEAM_PREF_ID + " INTEGER,"
            + FeedEntry.COLUMN_TEAM_P_ID + " INTEGER,"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_TEAM_PREF_ID + ") REFERENCES " + FeedEntry.TABLE_PREFERENCE +
            " (" + FeedEntry.COLUMN_PREF_ID + " ),"
            + "FOREIGN KEY (" + FeedEntry.COLUMN_TEAM_P_ID + ") REFERENCES " + FeedEntry.TABLE_PLAYER +
            " (" + FeedEntry.COLUMN_P_ID + " )"
            + ")";

    //create table match
    private static final String CREATE_TABLE_MATCH = "CREATE TABLE "
            + FeedEntry.TABLE_MATCH + "(" + FeedEntry.COLUMN_MATCH_ID + " INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_CHALLENGERTEAM_ID + " INTEGER" +  FeedEntry.COLUMN_CHALLENGEETEAM_ID + " INTEGER,"
            + FeedEntry.COLUMN_MATCH_LOC + " TEXT," + FeedEntry.COLUMN_MATCH_STARTTIME
            + " TIME," + FeedEntry.COLUMN_MATCH_ENDTIME + " TIME," + FeedEntry.COLUMN_MATCH_TURF_ID + " INTEGER,"
            + FeedEntry.COLUMN_MATCH_BOOKING_ID + " INTEGER"+ ")";

    //CREATE TABLE BOOKTURF
    private static final String CREATE_TABLE_BOOKTURF = "CREATE TABLE "
            + FeedEntry.TABLE_BOOKTURF + "(" + FeedEntry.COLUMN_BOOKING_ID + " INTEGER PRIMARY KEY,"
            + FeedEntry.COLUMN_BOOKING_MATCHID + " INTEGER,"
            + FeedEntry.COLUMN_BOOKING_AVAILIBILITY + " BOOLEAN" + ")";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PLAYER);
        db.execSQL(CREATE_TABLE_TURF);
        db.execSQL(CREATE_TABLE_TURFSLOTS);
        db.execSQL(CREATE_TABLE_CHALLENGEPOOL);
        db.execSQL(CREATE_TABLE_PREFERENCE);
        db.execSQL(CREATE_TABLE_TEAM);
        db.execSQL(CREATE_TABLE_MATCH);
        db.execSQL(CREATE_TABLE_BOOKTURF);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

}
