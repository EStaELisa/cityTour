package com.example.citytour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.databinding.FragmentSecondBinding;
import com.example.citytour.models.Attraction;
import com.example.citytour.models.Attractions;

public class SecondFragment extends Fragment {

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

        // Get current Attraction
        Attraction currentAttraction = Attractions.getAttraction();

        // Changes name to desired attraction
        TextView info_heading = view.findViewById(R.id.info_heading);
        info_heading.setText(currentAttraction.getName());

        // Changes info text to desired attraction
        TextView info = view.findViewById(R.id.info);
        info.setText(currentAttraction.getInfo());

        // Sets counter to new attraction
        Attractions.goToNextAttraction();

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}