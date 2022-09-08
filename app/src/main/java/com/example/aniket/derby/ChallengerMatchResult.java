package com.example.aniket.derby;

/**
 * Created by Aniket on 10/04/17.
 */

public class ChallengerMatchResult {

    private String name;
    private String start_time;
    private String end_time;
    private String days;
    private String location;
    private String level;
    private String turf1;
    private String turf2;
    private String turf3;
    private String turf4;
    private String turf5;
    private String ID;

    public ChallengerMatchResult() {
    }

    public ChallengerMatchResult(String name,String ID, String start_time,
                                 String end_time,String location,String level, String days,
                                 String turf1, String turf2, String turf3, String turf4, String turf5) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.days = days;
        this.location = location;
        this.level = level;
        this.turf1 = turf1;
        this.turf2 = turf2;
        this.turf3 = turf3;
        this.turf4 = turf4;
        this.turf5 = turf5;
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDays() {
        return days;
    }

    public String getTurf1() {
        return turf1;
    }

    public String getTurf2() {
        return turf2;
    }

    public String getTurf3() {
        return turf3;
    }

    public String getTurf4() {
        return turf4;
    }

    public String getTurf5() {
        return turf5;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setTurf1(String turf1) {
        this.turf1 = turf1;
    }

    public void setTurf2(String turf2) {
        this.turf2 = turf2;
    }

    public void setTurf3(String turf3) {
        this.turf3 = turf3;
    }

    public void setTurf4(String turf4) {
        this.turf4 = turf4;
    }

    public void setTurf5(String turf5) {
        this.turf5 = turf5;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
