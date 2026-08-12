package com.example.lawaseventia;

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

        // ==========================================
        // FIND VIEWS
        // ==========================================

        txtGalleryTitle = findViewById(
                R.id.txtGalleryTitle
        );

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);


        // ==========================================
        // GET EVENT ID
        // ==========================================

        String eventId =
                getIntent().getStringExtra("eventId");


        // ==========================================
        // LOAD GALLERY
        // ==========================================

        loadGallery(eventId);
    }


    // ==============================================
    // LOAD THE CORRECT EVENT GALLERY
    // ==============================================

    private void loadGallery(String eventId) {
        if (eventId == null) {

            txtGalleryTitle.setText("Event Gallery");

            return;
        }


        // ==========================================
        // PESTA LAWAS 2025
        // ==========================================

        if (eventId.equals("pesta_lawas_2025")) {
            txtGalleryTitle.setText(
                    "Pesta Lawas 2025"
            );

            image1.setImageResource(
                    R.drawable.pesta_lawas_2025_1
            );

            image2.setImageResource(
                    R.drawable.pesta_lawas_2025_2
            );

            image3.setImageResource(
                    R.drawable.pesta_lawas_2025_3
            );

            image4.setImageResource(
                    R.drawable.pesta_lawas_2025_4
            );

            image5.setImageResource(
                    R.drawable.pesta_lawas_2025_5
            );

            image6.setImageResource(
                    R.drawable.pesta_lawas_2025_6
            );
        }


        // ==========================================
        // LAWAS FOOD FESTIVAL 2025
        // ==========================================

        else if (eventId.equals("food_festival_2025")) {
            txtGalleryTitle.setText(
                    "Lawas Food Festival 2025"
            );

            image1.setImageResource(
                    R.drawable.food_festival_2025_1
            );

            image2.setImageResource(
                    R.drawable.food_festival_2025_2
            );

            image3.setImageResource(
                    R.drawable.food_festival_2025_3
            );

            image4.setImageResource(
                    R.drawable.food_festival_2025_4
            );

            image5.setImageResource(
                    R.drawable.food_festival_2025_5
            );

            image6.setImageResource(
                    R.drawable.food_festival_2025_6
            );
        }


        // ==========================================
        // CULTURAL NIGHT 2025
        // ==========================================

        else if (eventId.equals("cultural_night_2025")) {
            txtGalleryTitle.setText(
                    "Lawas Cultural Night 2025"
            );

            image1.setImageResource(
                    R.drawable.cultural_night_2025_1
            );

            image2.setImageResource(
                    R.drawable.cultural_night_2025_2
            );

            image3.setImageResource(
                    R.drawable.cultural_night_2025_3
            );

            image4.setImageResource(
                    R.drawable.cultural_night_2025_4
            );

            image5.setImageResource(
                    R.drawable.cultural_night_2025_5
            );

            image6.setImageResource(
                    R.drawable.cultural_night_2025_6
            );
        }
    }
}
