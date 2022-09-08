package com.example.aniket.derby;

import java.util.ArrayList;

/**
 * Created by Aniket on 15/04/17.
 */

public class PreferenceComparison {
    public static final String LOCATION_ANDHERI = "Andheri";
    public static final String LOCATION_GOREGAON = "Goregaon";
    public static final String LOCATION_BANDRA = "Bandra";
    public static final String LOCATION_MATUNGA = "Matunga";
    public static final String LOCATION_THANE = "Thane";
    public static final String LOCATION_SANTACRUZ = "Santacruz";
    public static final String LOCATION_KANDIVALI = "Kandivali";
    public static final String LOCATION_MULUND = "Mulund";
    public static final String LOCATION_WORLI = "Worli";
    public static final String LOCATION_CHEMBUR = "Chembur";
    public static final String LOCATION_POWAI = "Powai";

    private static ArrayList<String > listLocations = new ArrayList<String>();
    private static int[][] locationDistanceMatrix = new int[11][11];

    public PreferenceComparison() {
        setListLocations();
        setLocationDistanceMatrix();
    }

    private void setListLocations()
    {
        listLocations.add(LOCATION_ANDHERI);
        listLocations.add(LOCATION_GOREGAON);
        listLocations.add(LOCATION_BANDRA);
        listLocations.add(LOCATION_MATUNGA);
        listLocations.add(LOCATION_THANE);
        listLocations.add(LOCATION_SANTACRUZ);
        listLocations.add(LOCATION_KANDIVALI);
        listLocations.add(LOCATION_MULUND);
        listLocations.add(LOCATION_WORLI);
        listLocations.add(LOCATION_CHEMBUR);
        listLocations.add(LOCATION_POWAI);
    }

    private void setLocationDistanceMatrix()
    {
        for(int i = 0 ;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if(i==j)
                    locationDistanceMatrix[i][j] = 0;
                else
                locationDistanceMatrix[i][j] = -1;
            }
        }

        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_GOREGAON)] = 11;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_BANDRA)] = 13;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_MATUNGA)] = 16;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_THANE)] = 24;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_SANTACRUZ)] = 7;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_KANDIVALI)] = 16;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_MULUND)] = 18;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_WORLI)] = 21;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_CHEMBUR)] = 26;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_ANDHERI)][listLocations.indexOf(LOCATION_POWAI)] = 6;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_BANDRA)] = 15;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_MATUNGA)] = 21;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_THANE)] = 27;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_SANTACRUZ)] = 12;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_KANDIVALI)] = 9;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_MULUND)] = 22;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_WORLI)] = 26;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_CHEMBUR)] = 28;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_GOREGAON)][listLocations.indexOf(LOCATION_POWAI)] = 8;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_MATUNGA)] = 6;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_THANE)] = 31;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_SANTACRUZ)] = 3;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_KANDIVALI)] = 23;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_MULUND)] = 26;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_WORLI)] = 14;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_CHEMBUR)] = 13;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_BANDRA)][listLocations.indexOf(LOCATION_POWAI)] = 19;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_THANE)] = 26;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_SANTACRUZ)] = 9;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_KANDIVALI)] = 25;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_MULUND)] = 21;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_WORLI)] = 9;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_CHEMBUR)] = 8;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MATUNGA)][listLocations.indexOf(LOCATION_POWAI)] = 18;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_SANTACRUZ)] = 32;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_KANDIVALI)] = 29;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_MULUND)] = 10;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_WORLI)] = 36;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_CHEMBUR)] = 29;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_THANE)][listLocations.indexOf(LOCATION_POWAI)] = 18;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_SANTACRUZ)][listLocations.indexOf(LOCATION_KANDIVALI)] = 19;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_SANTACRUZ)][listLocations.indexOf(LOCATION_MULUND)] = 27;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_SANTACRUZ)][listLocations.indexOf(LOCATION_WORLI)] = 13;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_SANTACRUZ)][listLocations.indexOf(LOCATION_CHEMBUR)] = 14;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_SANTACRUZ)][listLocations.indexOf(LOCATION_POWAI)] = 15;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_KANDIVALI)][listLocations.indexOf(LOCATION_MULUND)] = 38;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_KANDIVALI)][listLocations.indexOf(LOCATION_WORLI)] = 31;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_KANDIVALI)][listLocations.indexOf(LOCATION_CHEMBUR)] = 29;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_KANDIVALI)][listLocations.indexOf(LOCATION_POWAI)] = 16;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_MULUND)][listLocations.indexOf(LOCATION_WORLI)] = 29;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MULUND)][listLocations.indexOf(LOCATION_CHEMBUR)] = 21;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_MULUND)][listLocations.indexOf(LOCATION_POWAI)] = 9;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_WORLI)][listLocations.indexOf(LOCATION_CHEMBUR)] = 12;
        locationDistanceMatrix[listLocations.indexOf(LOCATION_WORLI)][listLocations.indexOf(LOCATION_POWAI)] = 24;

        locationDistanceMatrix[listLocations.indexOf(LOCATION_CHEMBUR)][listLocations.indexOf(LOCATION_POWAI)] = 20;

        //keep row constant

    }

    public static int[][] getLocationDistanceMatrix() {
        return locationDistanceMatrix;
    }

    public static ArrayList<String> getListLocations() {
        return listLocations;
    }
}
