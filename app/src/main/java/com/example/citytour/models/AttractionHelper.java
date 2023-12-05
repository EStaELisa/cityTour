package com.example.citytour.models;

import com.example.citytour.R;

import java.util.ArrayList;
import java.util.List;

/**
 * attractionHelper creates list of attractions
 */
public class AttractionHelper {

    /**
     * creates list of attractions
     * @return list of attractions
     */
    public static List<Attraction> getDefaultAttractions() {
        List<Attraction> attractions = new ArrayList<>();

        attractions.add(new Attraction("Brandenburg Gate", R.string.info_brandenburgGate, 52.516181,13.376935));
        attractions.add(new Attraction("East Side Gallery", R.string.info_eastSideGallery, 52.50444793701172,13.440881729125977));
        attractions.add(new Attraction("TV Tower", R.string.info_tvTower, 52.52082824707031,13.409351348876953));
        attractions.add(new Attraction("Holocaust Memorial", R.string.info_holocaust, 52.5138484,13.3787399));
        attractions.add(new Attraction("Berlin Parliament", R.string.info_parliament, 52.5201123,13.3729545));
        // ... similarly add other attractions

        return attractions;
    }
}
