package com.example.citytour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.databinding.FragmentFirstBinding;
import com.example.citytour.models.Attraction;
import com.example.citytour.models.AttractionManager;

// Imports for osm
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private MapView map;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Configuration.getInstance().setUserAgentValue(requireContext().getPackageName());

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        // Initialize MapView
        map = binding.map;
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Changes go to to desired attraction
        TextView goToText = view.findViewById(R.id.goTo_text);
        Attraction currentAttraction = AttractionManager.getInstance().getCurrentAttraction();
        goToText.setText("Go to " + currentAttraction.getName());

        // move the map on a default view point

        IMapController mapController = map.getController();
        mapController.setZoom(14);
        GeoPoint startPoint = new GeoPoint(52.52437, 13.41053);
        mapController.setCenter(startPoint);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map != null) {
            map.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (map != null) {
            map.onPause();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}