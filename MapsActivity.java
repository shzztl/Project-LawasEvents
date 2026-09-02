package com.example.lawaseventia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        // GOOGLE MAP
        SupportMapFragment mapFragment =
                (SupportMapFragment)
                        getSupportFragmentManager()
                                .findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;

        // Lawas default location
        LatLng lawas = new LatLng(4.861432, 115.406618);

        // Move camera to Lawas
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lawas, 15));


        LatLng event1 = new LatLng(4.8722, 115.4066);
        mMap.addMarker(new MarkerOptions()
                .position(event1)
                .title("Lawas Stadium Parking")
                .snippet("Pesta Orang Kampung 22.0"));


        LatLng event2 = new LatLng(4.856970, 115.407795);
        mMap.addMarker(new MarkerOptions()
                .position(event2)
                .title("Lawas Waterfront")
                .snippet("Pesta Lawas 2026"));
    }
}
