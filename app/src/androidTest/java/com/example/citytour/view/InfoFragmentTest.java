package com.example.citytour.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.citytour.R;
import com.example.citytour.controller.AttractionManager;
import com.example.citytour.models.Attraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InfoFragmentTest {

    @Before
    public void setUp() {
        // Mock AttractionManager before tests
        AttractionManager mockManager = mock(AttractionManager.class);
        Attraction testAttraction = new Attraction("Test Name", 123, 456, 789);
        when(mockManager.getCurrentAttraction()).thenReturn(testAttraction);

        // Set the mock manager to the AttractionManager instance
        AttractionManager.setInstance(mockManager);
    }
    @Test
    public void attractionDetailsDisplayedCorrectly() {
        // Launch the fragment
        FragmentScenario.launchInContainer(InfoFragment.class);

        // Verify that the name and info text are displayed
        onView(withId(R.id.info_heading)).check(matches(withText("Test Name")));
        onView(withId(R.id.info)).check(matches(withText(123)));
    }

    @Test
    public void buttonNavigatesToGoToMapFragment() {
        // Set up mock NavController
        NavController mockNavController = mock(NavController.class);
        // Launch the fragment
        FragmentScenario<InfoFragment> scenario = FragmentScenario.launchInContainer(InfoFragment.class);
        scenario.onFragment(fragment ->
                Navigation.setViewNavController(fragment.requireView(), mockNavController)
        );

        // Perform a click on the button
        onView(withId(R.id.button_second)).perform(click());

        // Verify navigation has been called
        verify(mockNavController).navigate(R.id.action_SecondFragment_to_FirstFragment);
    }
}



