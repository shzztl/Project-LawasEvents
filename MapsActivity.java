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
        setContentView(R.layout.activity_map);

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

        // BOTTOM NAVIGATION
        LinearLayout navHome = findViewById(R.id.navHome);
        LinearLayout navCalendar = findViewById(R.id.navCalendar);
        LinearLayout navPast = findViewById(R.id.navPast);
        LinearLayout navAbout = findViewById(R.id.navAbout);

        // HOME
        navHome.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MapActivity.this,
                    MainActivity.class
            );

            intent.putExtra("openHome", true);
            startActivity(intent);
            finish();
        });

        // CALENDAR
        navCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MapActivity.this,
                    MainActivity.class
            );

            intent.putExtra("openCalendar", true);
            startActivity(intent);
            finish();
        });

        // PAST
        navPast.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MapActivity.this,
                    MainActivity.class
            );

            intent.putExtra("openPast", true);
            startActivity(intent);
            finish();
        });

        // ABOUT
        navAbout.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MapActivity.this,
                    MainActivity.class
            );

            intent.putExtra("openAbout", true);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;

        // Lawas default location
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
