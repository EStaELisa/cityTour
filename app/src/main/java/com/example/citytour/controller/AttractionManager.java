package com.example.citytour.controller;

import com.example.citytour.models.Attraction;
import com.example.citytour.models.AttractionHelper;

import java.util.List;

public class AttractionManager {

    private static AttractionManager instance;

    private List<Attraction> attractions;
    private int currentIndex = 0;

    private AttractionManager() {
        attractions = AttractionHelper.getDefaultAttractions();
    }

    public Attraction getCurrentAttraction() {
        return attractions.get(currentIndex);
    }

    public void moveToNextAttraction() {
        if (currentIndex < attractions.size() - 1) {
            currentIndex++;
        } else {
            instance = null;
        }
    }

    public static AttractionManager getInstance() {
        if (instance == null) {
            instance = new AttractionManager();
        }
        return instance;
    }

    // This method is for testing purposes only and resets the singleton instance.
    public static void resetInstance() {
        instance = null;
    }

    // Für Testzwecke
    public static void setInstance(AttractionManager mockInstance) {
        instance = mockInstance;
    }
}

