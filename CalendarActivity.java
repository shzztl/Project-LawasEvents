package com.example.lawaseventia;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        String calendarDate = getIntent().getStringExtra("calendarDate");
        boolean fromEventDetails =getIntent().getBooleanExtra("FROM_EVENT_DETAILS", false);

        CalendarFragment fragment = new CalendarFragment();
        Bundle bundle = new Bundle();

        bundle.putString(
                "calendarDate",
                calendarDate
        );

        bundle.putBoolean(
                "FROM_EVENT_DETAILS",
                fromEventDetails
        );

        fragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        R.id.calendarContainer,
                        fragment
                )
                .commit();
    }
}
