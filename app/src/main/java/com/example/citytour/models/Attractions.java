package com.example.citytour.models;

import java.lang.reflect.Array;

public class Attractions {

    private static int currentAttraction = 0;

    // 2D-Array displaying the attraction names + info
    // First dimension represents the attraction
    // Second dimension represent either name or info
    private static String[][] attractionArray = {
            {"Brandenburg Gate", "info_brandenburgGate"},
            {"East Side Gallery", "info_eastSideGallery"},
            {"TV Tower", "info_tvTower"},
            {"Holocaust Memorial", "info_holocaust"},
            {"Berlin Parliament", "info_parliament"},
    };

    public static void goToNextAttraction() {
        currentAttraction += 1;
        if (currentAttraction >= attractionArray.length) {
            currentAttraction = 0;
        }
    }

    public static int getCurrentAttraction(){
        return currentAttraction;
    }

    public static String getAttractionName(int attractionNumber){
        String name = attractionArray[attractionNumber][0];
        return name;
    }

    public static String getAttractionInfo(int attractionNumber){
        String info = attractionArray[attractionNumber][1];
        return info;
    }
}
