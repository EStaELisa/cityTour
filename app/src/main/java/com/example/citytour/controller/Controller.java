package com.example.citytour.controller;

import com.example.citytour.models.Attraction;

public class Controller {
    private static int pageNumber = 0;

    // creates the attractions that are appearing in the app
    public static void createAttractions() {
        Attraction brandenburgGate = new Attraction("@string/name_brandenburgGate", "@string/info_brandenburgGate");
        Attraction eastSideGallery = new Attraction("@string/name_eastSideGallery", "@string/info_eastSideGallery");
        Attraction tvTower = new Attraction("@string/name_tvTower", "@string/info_tvTower");
        Attraction holocaust = new Attraction("@string/holocaust", "@string/info_holocaust");
        Attraction parliament = new Attraction("@string/name_parliament", "@string/info_parliament");

    }
}
