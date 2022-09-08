package com.example.aniket.derby;

import java.util.ArrayList;

/**
 * Created by Aniket on 16/03/17.
 */

public class PreferenceConversion {

    public static final String YES = "y";
    public static final String NO = "n";
    public static final String START_FLAG = "s";
    public static final String END_FLAG = "e";
    public static final String[] WEEKDAYS = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private String[] string_time = new String[17];

    public String[] convert12to24(String start_time,String end_time )
    {
        int start_time_int = convert12to24int(start_time);
        int end_time_int = convert12to24int(end_time);


        for(int i = 0; i<17; i++)
        {
            string_time[i] = "x";
        }
        string_time[start_time_int-6]=START_FLAG;
        string_time[end_time_int-7]=END_FLAG;
        return string_time;
    }
    public int convert12to24int(String time)
    {
        String[] time_distributed  = time.split(":");
        int time_initial =  Integer.parseInt(time_distributed[0]);
        if(time.contains("PM"))
        {
            return time_initial+12;
        }
        else return time_initial;
    }
    public String convert24to12(int time_24h)
    {   String time_12h;
        if(time_24h>12)
        {   time_24h = time_24h -12;
            if (time_24h<10)
                time_12h = "0" + time_24h + ":00 PM";
            else time_12h =  time_24h + ":00 PM";
        }
        else {
            if (time_24h<10)
                time_12h = "0" + time_24h + ":00 AM";
            else time_12h =  time_24h + ":00 AM";
        }
        return time_12h;
    }
    public StringBuilder getDays(ArrayList<String> daysArray)
    {
        StringBuilder string_weekdays = new StringBuilder();
        if(daysArray.get(0).equals(YES)) {
                    string_weekdays.append(WEEKDAYS[0]+"\n");
        }
        if(daysArray.get(1).equals(YES)) {
            string_weekdays.append(WEEKDAYS[1]+"\n");

        }
        if(daysArray.get(2).equals(YES)) {
            string_weekdays.append(WEEKDAYS[2]+"\n");
        }
        if(daysArray.get(3).equals(YES)) {
            string_weekdays.append(WEEKDAYS[3]+"\n");

        }
        if(daysArray.get(4).equals(YES)) {
            string_weekdays.append(WEEKDAYS[4]+"\n");

        }
        if(daysArray.get(5).equals(YES)) {
            string_weekdays.append(WEEKDAYS[5]+"\n");

        }
        if(daysArray.get(6).equals(YES)) {
            string_weekdays.append(WEEKDAYS[6]);

        }

        return string_weekdays;
    }
}
