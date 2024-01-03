package com.example.citytour.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AttractionTest {

    private Attraction attraction1;
    private Attraction attraction2;
    private Attraction attraction3;

    @BeforeEach
    public void setUp() {
        attraction1 = new Attraction("Brandenburg Gate", 12345, 52.516181, 13.376935);
        attraction2 = new Attraction("Attraction", 999, 94.5, 10.2);
        attraction3 = new Attraction("Other attraction", 17, 120, 14.99999999);
    }

    @Test
    public void testGetName() {

        assertEquals("Brandenburg Gate", attraction1.getName());
        assertEquals("Attraction", attraction2.getName());
        assertEquals("Other attraction", attraction3.getName());
    }

    @Test
    public void testGetInfoText() {
        assertEquals(12345, attraction1.getInfoText());
        assertEquals(999, attraction2.getInfoText());
        assertEquals(17, attraction3.getInfoText());
    }

    @Test
    public void testGetLatitude() {
        assertEquals(52.516181, attraction1.getLatitude(), 0.0001);
        assertEquals(94.5, attraction2.getLatitude(), 0.0001);
        assertEquals(120, attraction3.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        assertEquals(13.376935, attraction1.getLongitude(), 0.0001);
        assertEquals(10.2, attraction2.getLongitude(), 0.0001);
        assertEquals(14.99999999, attraction3.getLongitude(), 0.0001);
    }

}
