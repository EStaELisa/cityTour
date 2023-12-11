package com.example.citytour;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.citytour.controller.AttractionManager;
import com.example.citytour.models.Attraction;
import com.example.citytour.view.GoToMapFragment;
import com.example.citytour.view.InfoFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class IntegrationTest {
    @Before
    public void setUp() {
    // initializing AttractionManager with real data
        AttractionManager.getInstance();
    }

    // is name + info text of attraction displayed correctly in InfoFragment with real data
    @Test
    public void attractionTextDisplayedCorrectlyWithRealDataInfoFragment() {
        // start InfoFragment
        FragmentScenario.launchInContainer(InfoFragment.class);

        // current attraction
        Attraction currentAttraction = AttractionManager.getInstance().getCurrentAttraction();

        // checks if displayed text matches with text from attractionManager
        onView(withId(R.id.info_heading)).check(matches(withText(currentAttraction.getName())));
        onView(withId(R.id.info)).check(matches(withText(currentAttraction.getInfoText())));
    }

    // is name of attraction displayed correctly in GoToMapFragment with real data
    @Test
    public void attractionTextDisplayedCorrectlyWithRealDataGoToMapFragment() {
        // start GoToMapFragment
        FragmentScenario.launchInContainer(GoToMapFragment.class);

        // current attraction
        Attraction currentAttraction = AttractionManager.getInstance().getCurrentAttraction();

        // checks if displayed text matches with text from attractionManager
        onView(withId(R.id.goTo_text)).check(matches(withText("Go to " + currentAttraction.getName())));
    }
}
