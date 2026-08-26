package com.example.lawaseventia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public MapFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // Back button
        ImageButton btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .popBackStack();

        });

        // Get Google Map
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager()
                        .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Lawas, Sarawak
        LatLng lawas = new LatLng(4.861432, 115.406618);

        // Move camera to Lawas
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lawas, 13));

      
        LatLng event1 = new LatLng(4.8560, 115.4070);

        mMap.addMarker(new MarkerOptions()
                .position(event1)
                .title("Lawas Stadium Parking")
                .snippet("Pesta Orang Kampung 22.0""));

       
        LatLng event2 = new LatLng(4.8525, 115.4085);

        mMap.addMarker(new MarkerOptions()
                .position(event2)
                .title("Lawas Waterfront")
                .snippet("Pesta Lawas 2026"));
    }
}
