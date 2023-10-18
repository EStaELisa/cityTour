package com.example.citytour.models;

public class Attraction {
    private String name;
    private int infoText;
    private int imageResourceId;

    // Constructor
    public Attraction(String name, int infoText, int imageResourceId) {
        this.name = name;
        this.infoText = infoText;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getInfoText() {
        return infoText;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setters (if necessary)
    public void setName(String name) {
        this.name = name;
    }

    public void setInfoText(int infoText) {
        this.infoText = infoText;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "name='" + name + '\'' +
                ", infoText='" + infoText + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}
