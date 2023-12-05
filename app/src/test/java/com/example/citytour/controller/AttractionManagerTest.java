package com.example.citytour.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.citytour.models.Attraction;
import com.example.citytour.models.AttractionHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class AttractionManagerTest {

    AttractionManager attractionManager;
    List<Attraction> mockAttractions;
    Attraction attraction1;
    Attraction attraction2;

    @BeforeEach
    public void setUp() throws Exception{
        AttractionManager.resetInstance();

        // Instance of AttractionManager
        attractionManager = AttractionManager.getInstance();

        // Mock-List
        mockAttractions = new ArrayList<>();
        attraction1 = new Attraction("Brandenburg Gate", 12345, 52.516181, 13.376935);
        attraction2 = new Attraction("Golden Gate Bridge", 12345, 52.516181, 13.376935);
        mockAttractions.add(attraction1);
        mockAttractions.add(attraction2);

        // Reflection,to mock private attribute "attractions"
        Field field = AttractionManager.class.getDeclaredField("attractions");
        field.setAccessible(true);
        field.set(attractionManager, mockAttractions);
    }

    // Singleton-Pattern test: tests, if getInstance() is called twice, the same instance will be returned
    @Test
    public void getInstance_ShouldReturnSameInstance() {
        AttractionManager.resetInstance();
        AttractionManager firstInstance = AttractionManager.getInstance();
        AttractionManager secondInstance = AttractionManager.getInstance();
        assertSame(firstInstance, secondInstance, "Both instances should be the same.");
    }

    // Test of getCurrentAttraction() with mocked attraction list
    @Test
    public void getCurrentAttractionTest() throws Exception {
        // Test function
        assertEquals(attractionManager.getCurrentAttraction(), attraction1);
    }


    // Test of moveToNextAttraction() with mocked attraction list
    @Test
    public void moveToNextAttractionTest() throws Exception {
        // Test function
        attractionManager.moveToNextAttraction();
        assertEquals(attractionManager.getCurrentAttraction(), attraction2);
    }
}
