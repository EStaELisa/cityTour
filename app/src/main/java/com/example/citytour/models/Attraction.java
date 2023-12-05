package com.example.citytour.models;

public class Attraction implements AttractionInterface {
    private String name;
    private int infoText;
    private double latitude;
    private double longitude;

    // Constructor
    public Attraction(String name, int infoText, double latitude, double longitude) {
        this.name = name;
        this.infoText = infoText;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getInfoText() {
        return infoText;
    }

    public double getLatitude() {return latitude;}

    public double getLongitude(){return longitude;}

}
