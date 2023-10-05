package com.example.citytour.models;

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
        }
    }

    // Add any other methods you need...
}

