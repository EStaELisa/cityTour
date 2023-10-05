package com.example.citytour.models;

import com.example.citytour.R;

import java.util.ArrayList;
import java.util.List;

public class AttractionHelper {

    public static List<Attraction> getDefaultAttractions() {
        List<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction("Brandenburg Gate", R.string.info_brandenburgGate, R.string.info_brandenburgGate));
        attractions.add(new Attraction("East Side Gallery", R.string.info_eastSideGallery, R.string.info_brandenburgGate));
        attractions.add(new Attraction("TV Tower", R.string.info_tvTower, R.string.info_brandenburgGate));
        attractions.add(new Attraction("Holocaust Memorial", R.string.info_holocaust, R.string.info_brandenburgGate));
        attractions.add(new Attraction("Berlin Parliament", R.string.info_parliament, R.string.info_brandenburgGate));
        // ... similarly add other attractions

        return attractions;
    }
}
