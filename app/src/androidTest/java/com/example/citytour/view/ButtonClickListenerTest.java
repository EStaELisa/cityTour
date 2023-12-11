package com.example.citytour.view;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.R;
import com.example.citytour.controller.AttractionManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ButtonClickListenerTest {

    @Mock
    private InfoFragment mockInfoFragment;
    @Mock
    private GoToMapFragment mockGoToMapFragment;
    @Mock
    private NavController mockNavController;
    @Mock
    private AttractionManager mockAttractionManager;

    // Initializing mock of InfoFragment, goToMapFragment, NavControllers and AttractionManagers
    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        when(NavHostFragment.findNavController(mockInfoFragment)).thenReturn(mockNavController);
        when(NavHostFragment.findNavController(mockGoToMapFragment)).thenReturn(mockNavController);
        when(AttractionManager.getInstance()).thenReturn(mockAttractionManager);
    }

    // Test for navigation of InfoFragment
    @Test
    public void testInfoFragmentNavigation() {
        ButtonClickListener listener = new ButtonClickListener(mockInfoFragment);
        listener.onClick(null);
        verify(mockNavController).navigate(R.id.action_SecondFragment_to_FirstFragment);
    }

    // Test navigation of GoToMapFragment
    @Test
    public void testGoToMapFragmentNavigation() {
        ButtonClickListener listener = new ButtonClickListener(mockGoToMapFragment);
        listener.onClick(null);
        verify(mockNavController).navigate(R.id.action_FirstFragment_to_SecondFragment);
    }

    // Test navigation of other fragment
    @Test
    public void testNoNavigationForOtherFragment() {
        Fragment otherFragment = mock(Fragment.class);
        ButtonClickListener listener = new ButtonClickListener(otherFragment);
        listener.onClick(null);
        verify(mockNavController, never()).navigate(anyInt());
    }

    // assert that moveToNextAttraction will be called for InfoFragment
    @Test
    public void testMoveToNextAttractionCalledForInfoFragment() {
        ButtonClickListener listener = new ButtonClickListener(mockInfoFragment);
        listener.onClick(null);
        verify(mockAttractionManager).moveToNextAttraction();
    }

    // assert that moveToNextAttraction will not be called for an other fragment
    @Test
    public void testMoveToNextAttractionNotCalledForOtherFragment() {
        Fragment otherFragment = mock(Fragment.class);
        ButtonClickListener listener = new ButtonClickListener(otherFragment);
        listener.onClick(null);
        verify(mockAttractionManager, never()).moveToNextAttraction();
    }
}

