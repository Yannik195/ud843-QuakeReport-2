package com.example.android.quakereport;

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private long mTimeInMillis;
    private String mUrl;
    private int mTsunami;

    public Earthquake(double magnitude, String location, long timeInMillis, String url, int tsunami) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMillis = timeInMillis;
        mUrl = url;
        mTsunami = tsunami;
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

    public int getTsunami() {
        return mTsunami;
    }

}
