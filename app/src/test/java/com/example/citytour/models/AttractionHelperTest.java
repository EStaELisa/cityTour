package com.example.citytour.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AttractionHelperTest {

    @Test
    public void getDefaultAttractions_ShouldReturnNonEmptyList() {
        List<Attraction> attractions = AttractionHelper.getDefaultAttractions();

        assertNotNull(attractions, "The list of attractions should not be null.");
        assertFalse(attractions.isEmpty(), "The list of attractions should not be empty.");
    }

    @Test
    public void getDefaultAttractions_EachAttractionShouldHaveNameAndCoordinates() {
        List<Attraction> attractions = AttractionHelper.getDefaultAttractions();

        for (Attraction attraction : attractions) {
            assertNotNull(attraction.getName(), "Every attraction should have a name.");
            assertNotEquals(0, attraction.getLatitude(), "Every attraction should have a latitude.");
            assertNotEquals(0, attraction.getLongitude(), "Every attraction should have a longitude.");
        }
    }
}

