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

        //Find Views
        ImageView image = findViewById(R.id.imgEvent);
        TextView title = findViewById(R.id.txtTitle);
        TextView date = findViewById(R.id.txtDate);
        TextView time = findViewById(R.id.txtTime);
        TextView entrance = findViewById(R.id.txtEntrance);
        TextView category = findViewById(R.id.txtCategory);
        TextView location = findViewById(R.id.txtLocation);
        TextView description = findViewById(R.id.txtDescription);
        TextView attractions = findViewById(R.id.txtAttractions);
        TextView organizer = findViewById(R.id.txtOrganizer);

        ImageButton btnBack = findViewById(R.id.btnBack);
        Button btnViewCalendar = findViewById(R.id.btnViewCalendar);

        //Get Event Info
        String eventTitle = getIntent().getStringExtra("title");
        String eventDate = getIntent().getStringExtra("date");
        String eventTime = getIntent().getStringExtra("time");
        String eventEntrance = getIntent().getStringExtra("entrance");
        String eventCategory = getIntent().getStringExtra("category");
        String eventLocation = getIntent().getStringExtra("location");
        String eventDescription = getIntent().getStringExtra("description");
        String eventAttractions = getIntent().getStringExtra("attractions");
        String eventOrganizer = getIntent().getStringExtra("organizer");

        //Display Image
        image.setImageResource(
                getIntent().getIntExtra(
                        "image",
                        R.drawable.lawas1
                )
        );
        image.setImageResource(imageResource);

        //Display Event Info
        if (eventTitle != null) {
            title.setText(eventTitle);
        }

        if (eventDate != null) {
            date.setText("📅 " + eventDate);
        }

        if (eventTime != null) {
            time.setText("🕒 " + eventTime);
        }

        if (eventEntrance != null) {
            entrance.setText("🎟 " + eventEntrance);
        }

        if (eventCategory != null) {
            category.setText("🏷 " + eventCategory);
        }

        if (eventLocation != null) {
            location.setText("📍 " + eventLocation);
        }

        if (eventDescription != null) {
            description.setText(eventDescription);
        }

        if (eventAttractions != null) {
            attractions.setText(eventAttractions);
        }

        if (eventOrganizer != null) {
            organizer.setText(eventOrganizer);
        }

        btnBack.setOnClickListener(v -> {
            finish();
        });

        // [View on Calendar]
        btnViewCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(
                    EventDetailsActivity.this,
                    MainActivity.class
            );

            // Tell MainActivity to open Calendar
            intent.putExtra(
                    "openCalendar",
                    true
            );

            // Send selected event date
            intent.putExtra(
                    "eventDate",
                    eventDate
            );

            // Send selected event title
            intent.putExtra(
                    "eventTitle",
                    eventTitle
            );

            // Return to existing MainActivity
            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });
    }
}
