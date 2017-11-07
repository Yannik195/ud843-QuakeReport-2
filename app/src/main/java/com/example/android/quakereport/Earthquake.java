package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMillis;
    private String mUrl;

    public Earthquake(double magnitude, String location, long timeInMillis, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMillis = timeInMillis;
        mUrl = url;
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

    public String getUrl() {
        return mUrl;
    }

}
