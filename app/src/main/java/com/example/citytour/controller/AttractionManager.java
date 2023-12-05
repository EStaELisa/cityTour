package com.example.citytour.controller;

import com.example.citytour.models.Attraction;
import com.example.citytour.models.AttractionHelper;

import java.util.List;

/**
 * manages attractions (controller)
 */
public class AttractionManager implements AttractionManagerInterface {

    /**
     * instance of AttractionManager
     */
    private static AttractionManager instance;

    /**
     * list with all attractions to be visited
     */
    private List<Attraction> attractions;

    /**
     * index of current attraction
     */
    private int currentIndex = 0;

    /**
     * private constructor to ensure that only one instance of AttractionManager exists
     */
    private AttractionManager() {
        attractions = AttractionHelper.getDefaultAttractions();
    }

    /**
     * returns current attraction
     * @return current attraction
     */
    public Attraction getCurrentAttraction() {
        return attractions.get(currentIndex);
    }

    /**
     * moves to next attraction
     */
    public void moveToNextAttraction() {
        if (currentIndex < attractions.size() - 1) {
            currentIndex++;
        } else {
            instance = null;
        }
    }

    /**
     * returns current AttractionManager, if one exists
     * if no AttractionManager exists, it creates a new one
     *
     * @return current instance of AttractionManager
     */
    public static AttractionManager getInstance() {
        if (instance == null) {
            instance = new AttractionManager();
        }
        return instance;
    }

    /**
     * for testing purposes only, resets the singleton instance
     */
    public static void resetInstance() {
        instance = null;
    }

    /**
     * for testing purposes only, returns mocked AttractionManager
     * @param mockInstance mocked AttractionManager
     */
    public static void setInstance(AttractionManager mockInstance) {
        instance = mockInstance;
    }
}

