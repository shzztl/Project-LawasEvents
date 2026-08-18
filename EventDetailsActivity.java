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
        TextView entrance = findViewById(R.id.txtEntrance);
        TextView venue = findViewById(R.id.txtVenue);
        TextView category = findViewById(R.id.txtCategory);
        TextView description = findViewById(R.id.txtDescription);

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

        date.setText(
                getIntent().getStringExtra("time")
        );

        date.setText(
                getIntent().getStringExtra("entrance")
        );

        venue.setText(
                getIntent().getStringExtra("venue")
        );

        category.setText(
                getIntent().getStringExtra("category")
        );

        description.setText(
                getIntent().getStringExtra("description")
        );
    }
}
