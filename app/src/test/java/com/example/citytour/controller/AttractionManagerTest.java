package com.example.citytour.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.citytour.models.Attraction;
import com.example.citytour.models.AttractionHelper;

class AttractionManagerTest {

    @BeforeEach
    public void setUp() {
        // Since AttractionManager is a singleton, it needs to be restarted to a known state before each test.
        AttractionManager.resetInstance();
    }

    @Test
    public void getInstance_ShouldAlwaysReturnSameInstance() {
        AttractionManager firstInstance = AttractionManager.getInstance();
        AttractionManager secondInstance = AttractionManager.getInstance();
        assertSame(firstInstance, secondInstance, "Both instances should be the same.");
    }

    @Test
    public void getCurrentAttraction_ShouldNotBeNull() {
        AttractionManager manager = AttractionManager.getInstance();
        Attraction currentAttraction = manager.getCurrentAttraction();
        assertNotNull(currentAttraction, "Current attraction should not be null.");
    }

    @Test
    public void moveToNextAttraction_ShouldAdvanceTheCurrentAttraction() {
        AttractionManager manager = AttractionManager.getInstance();
        Attraction firstAttraction = manager.getCurrentAttraction();

        manager.moveToNextAttraction();
        Attraction secondAttraction = manager.getCurrentAttraction();

        assertNotSame(firstAttraction, secondAttraction, "After moving, the current attraction should be different.");
    }
}
