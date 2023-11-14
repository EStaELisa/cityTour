package com.example.citytour.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.citytour.R;
import com.example.citytour.databinding.FragmentFirstBinding;
import com.example.citytour.models.Attraction;
import com.example.citytour.controller.AttractionManager;

// Imports for osm
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import android.Manifest;


public class GoToMapFragment extends Fragment {

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
        GeoPoint startPoint = new GeoPoint(currentAttraction.getLatitude(), currentAttraction.getLongitude());
        mapController.setCenter(startPoint);

        // Adds marker for the current attraction
        addMarker(currentAttraction.getLatitude(), currentAttraction.getLongitude(), "attraction");

        // Try getting the current location
        getLastKnownLocationAndAddMarker();

        // Button to get to the InfoFragment
        binding.buttonFirst.setOnClickListener(new ButtonClickListener(this, R.id.action_FirstFragment_to_SecondFragment));
    }

    private void addMarker(double lat, double lon, String type) {
        GeoPoint point = new GeoPoint(lat, lon);
        Marker marker = new Marker(map);
        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);

        // Set icon based on type
        if ("location".equals(type)) {
            marker.setIcon(resizeDrawable(R.drawable.fireworks, 24, 24));
        }

        map.getOverlays().add(marker);
    }

    private Drawable resizeDrawable(int drawableId, int width, int height) {
        Drawable image = getResources().getDrawable(drawableId);
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, width, height, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }



    private void getLastKnownLocationAndAddMarker() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        String locationProvider = LocationManager.GPS_PROVIDER;
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            return;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
        if (lastKnownLocation != null) {
            double latitude = lastKnownLocation.getLatitude();
            double longitude = lastKnownLocation.getLongitude();
            addMarker(latitude, longitude, "location");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastKnownLocationAndAddMarker();
            } else {
                Toast.makeText(getContext(), "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
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
