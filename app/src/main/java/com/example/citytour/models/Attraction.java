package com.example.citytour.models;
import com.example.citytour.AssetHelper;

public class Attraction {
    private static String pathnameInfo = "app/assets/attractions.json";
    private String name;
    private String info;

    public Attraction(String name, String jsonKey) {
        this.name = name;
        this.info = String.valueOf(AssetHelper.getTextByKey(pathnameInfo, jsonKey));
    }


    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
