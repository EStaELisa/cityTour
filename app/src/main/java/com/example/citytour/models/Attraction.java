package com.example.citytour.models;

/**
 * attraction
 */
public class Attraction implements AttractionInterface {
    /**
     * name of attraction
     */
    private String name;

    /**
     * info text for attraction
     */
    private int infoText;

    /**
     * latitude of attraction
     */
    private double latitude;

    /**
     * longitude of attraction
     */
    private double longitude;

    /**
     * constructor for attraction
     *
     * @param name attraction name
     * @param infoText info text for attraction
     * @param latitude latitude of attraction
     * @param longitude longitude of attraction
     */
    public Attraction(String name, int infoText, double latitude, double longitude) {
        this.name = name;
        this.infoText = infoText;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * getter for name
     * @return name of attraction
     */
    public String getName() {
        return name;
    }

    /**
     * getter for info text
     * @return info text of attraction
     */
    public int getInfoText() {
        return infoText;
    }

    /**
     * getter for latitude
     * @return latitude of attraction
     */
    public double getLatitude() {return latitude;}

    /**
     * getter for longitude
     * @return longitude of attraction
     */
    public double getLongitude(){return longitude;}

}
