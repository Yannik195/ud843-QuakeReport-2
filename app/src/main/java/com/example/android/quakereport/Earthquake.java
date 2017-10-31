package com.example.android.quakereport;



public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMillis;

    public Earthquake(double magnitude, String location, long timeInMillis){

        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMillis = timeInMillis;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getTime(){
        return mTimeInMillis;
    }

    public String getSomeShit() {
        return "Some Shit.";
    }
}
