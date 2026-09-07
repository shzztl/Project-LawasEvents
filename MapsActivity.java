package com.example.lawaseventia;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

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

    // Event data
    private double latitude;
    private double longitude;

    private String title;
    private String location;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // BACK BUTTON
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        // GET EVENT DATA
        latitude = getIntent().getDoubleExtra("latitude", 0.0);
        longitude = getIntent().getDoubleExtra("longitude", 0.0);

        title = getIntent().getStringExtra("title");
        location = getIntent().getStringExtra("location");
        date = getIntent().getStringExtra("date");

        // DISPLAY EVENT NAME AND DATE
        TextView txtMapEventName = findViewById(R.id.txtMapEventName);
        TextView txtMapEventDate = findViewById(R.id.txtMapEventDate);

        if (title != null && !title.isEmpty()) {
            txtMapEventName.setText(title);
        }

        if (date != null && !date.isEmpty()) {
            txtMapEventDate.setText("📅 " + date);
        }

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

        // EVENT LOCATION FROM HOME FRAGMENT
        LatLng eventLocation = new LatLng(latitude, longitude);

        // MOVE CAMERA TO EVENT LOCATION
        mMap.moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                        eventLocation,
                        15f
                )
        );

        // ADD EVENT MARKER
        mMap.addMarker(
                new MarkerOptions()
                        .position(eventLocation)
                        .title(location)
                        .snippet(title)
        );
    }
}
