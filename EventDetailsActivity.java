package com.example.lawaseventia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        ImageView image = findViewById(R.id.imgEvent);
        TextView title = findViewById(R.id.txtTitle);
        TextView date = findViewById(R.id.txtDate);
        TextView time = findViewById(R.id.txtTime);
        TextView entrance1 = findViewById(R.id.txtEntrance1);
        TextView entrance2 = findViewById(R.id.txtEntrance2);
        TextView location = findViewById(R.id.txtLocation);
        TextView category = findViewById(R.id.txtCategory);
        TextView description = findViewById(R.id.txtDescription);
        TextView attractions = findViewById(R.id.txtAttractions);
        TextView organizer = findViewById(R.id.txtOrganizer);

        image.setImageResource(
                getIntent().getIntExtra(
                        "image",
                        R.drawable.lawas1
                )
        );

        title.setText(
                getIntent().getStringExtra("title")
        );

        date.setText(
                getIntent().getStringExtra("date")
        );

        time.setText(
                getIntent().getStringExtra("time")
        );

        entrance1.setText(
                getIntent().getStringExtra("entrance1")
        );

        entrance2.setText(
                getIntent().getStringExtra("entrance2")
        );

        location.setText(
                getIntent().getStringExtra("location")
        );

        category.setText(
                getIntent().getStringExtra("category")
        );

        description.setText(
                getIntent().getStringExtra("description")
        );

        attractions.setText(
                getIntent().getStringExtra("attractions")
        );

        organizer.setText(
                getIntent().getStringExtra("organizer")
        );
    }
}
