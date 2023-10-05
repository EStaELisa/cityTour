package com.example.citytour.models;

import java.lang.reflect.Array;
import java.util.List;

public class Attractions {

    private static int currentAttraction = 0;
    private static Attraction[] attractions = {
            new Attraction("Brandenburg Gate", "infoBrandenburgGate"),
            new Attraction("East Side Gallery", "infoEastSideGallery"),
            new Attraction("TV Tower", "infoTvTower"),
            new Attraction("Holocaust Memorial", "infoHolocaust"),
            new Attraction("Berlin Parliament", "infoParliament"),
    };



    public static void goToNextAttraction() {
        currentAttraction += 1;
        if (currentAttraction >= attractions.length) {
            currentAttraction = 0;
        }
    }


    public static Attraction getAttraction(){
        return attractions[currentAttraction];
    }
}

