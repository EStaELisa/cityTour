package com.example.citytour.controller;

import com.example.citytour.models.Attraction;

import java.util.List;

public interface AttractionManagerInterface {

    Attraction getCurrentAttraction();

    void moveToNextAttraction();

    static AttractionManagerInterface getInstance() {
        return (AttractionManagerInterface) AttractionManager.getInstance();
    }

}
