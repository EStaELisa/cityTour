package com.example.citytour.view;

import static androidx.core.content.MimeTypeFilter.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.location.LocationManager;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.citytour.R;
import com.example.citytour.controller.AttractionManager;
import com.example.citytour.models.Attraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.Location;

@RunWith(AndroidJUnit4.class)
public class GoToMapFragmentTest {

    @Before
    public void setUp() {
        // Mock AttractionManager before tests
        AttractionManager mockManager = mock(AttractionManager.class);
        Attraction testAttraction = new Attraction("Test Attraction", 123, 456, 789);
        when(mockManager.getCurrentAttraction()).thenReturn(testAttraction);

        // Set the mock manager to the AttractionManager instance
        AttractionManager.setInstance(mockManager);

    }

    // test if text is displayed correctly
    @Test
    public void attractionDetailsDisplayedCorrectly() {
        // Launch the fragment
        FragmentScenario.launchInContainer(GoToMapFragment.class);
        // Verify that the goToText is displayed correctly
        onView(withId(R.id.goTo_text)).check(ViewAssertions.matches(withText("Go to Test Attraction")));
    }

    @Test
    public void buttonNavigatesToInfoFragment() {
        // Set up mock NavController
        NavController mockNavController = mock(NavController.class);
        // Launch the fragment
        FragmentScenario<GoToMapFragment> scenario = FragmentScenario.launchInContainer(GoToMapFragment.class);
        scenario.onFragment(fragment ->
                Navigation.setViewNavController(fragment.requireView(), mockNavController)
        );

        // Perform a click on the button
        onView(withId(R.id.button_first)).perform(click());

        // Verify navigation has been called
        verify(mockNavController).navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

}
