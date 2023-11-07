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

    public static AttractionManager getInstance() {
        if (instance == null) {
            instance = new AttractionManager();
        }
        return instance;
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

    // Add any other methods you need...
}

