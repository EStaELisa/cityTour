package com.example.citytour.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.R;
import com.example.citytour.databinding.FragmentSecondBinding;
import com.example.citytour.models.Attraction;
import com.example.citytour.controller.AttractionManager;

public class InfoFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get Name Attraction
        TextView goToText = view.findViewById(R.id.info_heading);
        Attraction currentAttraction = AttractionManager.getInstance().getCurrentAttraction();
        goToText.setText(currentAttraction.getName());

        // Get Info Attraction
        TextView infoText = view.findViewById(R.id.info);
        infoText.setText(currentAttraction.getInfoText());

        // Button, to get to the next attraction
        binding.buttonSecond.setOnClickListener(new ButtonClickListener(this));    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}