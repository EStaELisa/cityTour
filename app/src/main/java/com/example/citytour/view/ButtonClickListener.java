package com.example.citytour.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.controller.AttractionManager;

public class ButtonClickListener implements View.OnClickListener {
    private final Fragment fragment;
    private final int navigationActionId;

    public ButtonClickListener(Fragment fragment, int navigationActionId) {
        this.fragment = fragment;
        this.navigationActionId = navigationActionId;
    }

    @Override
    public void onClick(View view) {
        NavHostFragment.findNavController(fragment).navigate(navigationActionId);
        if (fragment instanceof InfoFragment) {
            AttractionManager.getInstance().moveToNextAttraction();
        }
    }
}
