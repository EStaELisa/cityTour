package com.example.citytour.view;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.R;
import com.example.citytour.controller.AttractionManager;

public class ButtonClickListener implements View.OnClickListener {
    private final Fragment fragment;

    public ButtonClickListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onClick(View view) {
        int navigationActionId = getNavigationActionId();
        if (navigationActionId != 0) {
            NavHostFragment.findNavController(fragment).navigate(navigationActionId);
        }

        if (fragment instanceof InfoFragment) {
            AttractionManager.getInstance().moveToNextAttraction();
        }
    }

    private int getNavigationActionId() {
        if (fragment instanceof InfoFragment) {
            return R.id.action_SecondFragment_to_FirstFragment;
        } else if (fragment instanceof GoToMapFragment) {
            return R.id.action_FirstFragment_to_SecondFragment;
        }
        // no fitting case, no navigation
        return 0;
    }
}

