package com.example.asus.quakereport;


public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMillisseconds;
    private String mURL;

    public Earthquake(double magnitude, String loacion, long timeInMillisseconds, String url) {
        mMagnitude=magnitude;
        mLocation=loacion;
        mTimeInMillisseconds=timeInMillisseconds;
        mURL = url;
    }



    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMillisseconds() {
        return mTimeInMillisseconds;
    }

    public String getURL() {
        return mURL;
    }
}
