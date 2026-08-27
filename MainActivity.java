package com.example.lawaseventia;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Navigation containers
    LinearLayout navHome;
    LinearLayout navCalendar;
    LinearLayout navPast;
    LinearLayout navAbout;

    // Navigation icons
    ImageView iconHome;
    ImageView iconCalendar;
    ImageView iconPast;
    ImageView iconAbout;

    // Icon sizes
    private static final int SELECTED_SIZE = 30;
    private static final int UNSELECTED_SIZE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Find navigation views
        navHome = findViewById(R.id.navHome);
        navCalendar = findViewById(R.id.navCalendar);
        navPast = findViewById(R.id.navPast);
        navAbout = findViewById(R.id.navAbout);

        // Find icons
        iconHome = findViewById(R.id.iconHome);
        iconCalendar = findViewById(R.id.iconCalendar);
        iconPast = findViewById(R.id.iconPast);
        iconAbout = findViewById(R.id.iconAbout);

        // Open Home by default
        if (savedInstanceState == null) {
            showFragment(new HomeFragment());

            setSelectedIcon(iconHome);
            setUnselectedIcon(iconCalendar);
            setUnselectedIcon(iconPast);
            setUnselectedIcon(iconAbout);
        }

        // Home button
        navHome.setOnClickListener(v -> {
            showFragment(new HomeFragment());

            setSelectedIcon(iconHome);
            setUnselectedIcon(iconCalendar);
            setUnselectedIcon(iconPast);
            setUnselectedIcon(iconAbout);
        });

        // Calendar button
        navCalendar.setOnClickListener(v -> {
            showFragment(new CalendarFragment());

            setSelectedIcon(iconCalendar);
            setUnselectedIcon(iconHome);
            setUnselectedIcon(iconPast);
            setUnselectedIcon(iconAbout);
        });

        // Past Event button
        navPast.setOnClickListener(v -> {
            showFragment(new PastEventsFragment());

            setSelectedIcon(iconPast);
            setUnselectedIcon(iconHome);
            setUnselectedIcon(iconCalendar);
            setUnselectedIcon(iconAbout);
        });

        //About button
        navAbout.setOnClickListener(v -> {
            showFragment(new AboutFragment());

            setSelectedIcon(iconAbout);
            setUnselectedIcon(iconHome);
            setUnselectedIcon(iconCalendar);
            setUnselectedIcon(iconPast);
        });
    }

    private void showFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    //Bigger selected icon
    private void setSelectedIcon(ImageView icon) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) icon.getLayoutParams();

        params.width = dpToPx(SELECTED_SIZE);
        params.height = dpToPx(SELECTED_SIZE);

        icon.setLayoutParams(params);
    }

    //Smaller unselected icon
    private void setUnselectedIcon(ImageView icon) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) icon.getLayoutParams();

        params.width = dpToPx(UNSELECTED_SIZE);
        params.height = dpToPx(UNSELECTED_SIZE);

        icon.setLayoutParams(params);
    }

    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
