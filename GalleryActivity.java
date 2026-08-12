package com.example.lawasevents;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private TextView txtGalleryTitle;

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // Find views
        txtGalleryTitle = findViewById(
                R.id.txtGalleryTitle
        );

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);

        // Get category from previous page
        String category =
                getIntent().getStringExtra("category");

        // Change title according to category
        if (category != null) {
            txtGalleryTitle.setText(
                    category + " Events"
            );
        }

        // Load gallery images
        loadGalleryImages();
    }

    private void loadGalleryImages() {
        image1.setImageResource(
                R.drawable.past_event1
        );

        image2.setImageResource(
                R.drawable.past_event2
        );

        image3.setImageResource(
                R.drawable.past_event3
        );

        image4.setImageResource(
                R.drawable.past_event4
        );

        image5.setImageResource(
                R.drawable.past_event5
        );

        image6.setImageResource(
                R.drawable.past_event6
        );
    }
}
