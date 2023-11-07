package com.example.citytour.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AttractionTest {

    private Attraction attraction;

    @BeforeEach
    public void setUp() {
        attraction = new Attraction("Brandenburg Gate", 12345, 52.516181, 13.376935);
    }

    @Test
    public void testGetName() {
        assertEquals("Brandenburg Gate", attraction.getName());
    }

    @Test
    public void testGetInfoText() {
        assertEquals(12345, attraction.getInfoText());
    }

    @Test
    public void testGetLatitude() {
        assertEquals(52.516181, attraction.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        assertEquals(13.376935, attraction.getLongitude(), 0.0001);
    }

}
