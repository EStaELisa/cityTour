package com.example.citytour.models;

public class Attraction {
    private static int numberAttractions = 0;

    private int id;
    private String name;
    private String description;

    // attraction constructor, generates id for each attraction
    public Attraction(String name, String description){
        this.id = numberAttractions;
        numberAttractions +=1;
        this.name = name;
        this.description = description;
    }


}
