package com.example.lawasevents;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // Lawas image carousel
    private ViewPager2 viewPagerLawas;
    private LawasImageAdapter lawasImageAdapter;

    // Upcoming event carousel
    private ViewPager2 viewPagerEvents;

    // Image indicators
    private LinearLayout lawasIndicators;

    // Automatic slideshow
    private Handler sliderHandler;
    private Runnable sliderRunnable;

    // Change image every 3 seconds
    private static final long SLIDE_DELAY = 3000;

    // Store Lawas images
    private ArrayList<Integer> lawasImages;

    // Store upcoming events
    private ArrayList<Event> upcomingEvents;


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home,
                container,
                false
        );

        // ==========================================
        // FIND VIEWS
        // ==========================================

        viewPagerLawas = view.findViewById(
                R.id.viewPagerLawas
        );

        viewPagerEvents = view.findViewById(
                R.id.viewPagerEvents
        );

        lawasIndicators = view.findViewById(
                R.id.lawasIndicators
        );


        // ==========================================
        // LOAD LAWAS IMAGES
        // ==========================================

        loadLawasImages();


        // ==========================================
        // SET LAWAS IMAGE ADAPTER
        // ==========================================

        lawasImageAdapter =
                new LawasImageAdapter(lawasImages);

        viewPagerLawas.setAdapter(
                lawasImageAdapter
        );


        // ==========================================
        // CREATE IMAGE INDICATORS
        // ==========================================

        setupIndicators();


        // ==========================================
        // UPDATE INDICATOR WHEN USER SWIPES
        // ==========================================

        viewPagerLawas.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {

                    @Override
                    public void onPageSelected(int position) {

                        super.onPageSelected(position);

                        updateIndicators(position);
                    }
                }
        );


        // ==========================================
        // AUTOMATIC SLIDESHOW
        // ==========================================

        sliderHandler = new Handler(
                Looper.getMainLooper()
        );

        sliderRunnable = new Runnable() {

            @Override
            public void run() {

                if (lawasImages != null
                        && !lawasImages.isEmpty()) {

                    int nextPosition =
                            viewPagerLawas.getCurrentItem() + 1;

                    if (nextPosition >= lawasImages.size()) {

                        nextPosition = 0;
                    }

                    viewPagerLawas.setCurrentItem(
                            nextPosition,
                            true
                    );
                }

                sliderHandler.postDelayed(
                        this,
                        SLIDE_DELAY
                );
            }
        };


        // ==========================================
        // LOAD UPCOMING EVENTS
        // ==========================================

        loadUpcomingEvents();


        EventAdapter eventAdapter =
                new EventAdapter(
                        requireContext(),
                        upcomingEvents
                );

        viewPagerEvents.setAdapter(
                eventAdapter
        );


        return view;
    }


    // =================================================
    // LAWAS IMAGES
    // =================================================

    private void loadLawasImages() {

        lawasImages = new ArrayList<>();

        lawasImages.add(
                R.drawable.lawas_1
        );

        lawasImages.add(
                R.drawable.lawas_2
        );

        lawasImages.add(
                R.drawable.lawas_3
        );

        lawasImages.add(
                R.drawable.lawas_4
        );
    }


    // =================================================
    // IMAGE INDICATORS
    // =================================================

    private void setupIndicators() {

        lawasIndicators.removeAllViews();

        for (int i = 0; i < lawasImages.size(); i++) {

            TextView indicator =
                    new TextView(requireContext());

            indicator.setText("●");
            indicator.setTextSize(10);

            indicator.setTextColor(
                    ContextCompat.getColor(
                            requireContext(),
                            android.R.color.darker_gray
                    )
            );

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            params.setMargins(
                    5,
                    0,
                    5,
                    0
            );

            indicator.setLayoutParams(params);

            lawasIndicators.addView(
                    indicator
            );
        }

        updateIndicators(0);
    }


    private void updateIndicators(int selectedPosition) {

        if (lawasIndicators == null) {
            return;
        }

        for (int i = 0;
             i < lawasIndicators.getChildCount();
             i++) {

            TextView indicator =
                    (TextView) lawasIndicators.getChildAt(i);

            if (i == selectedPosition) {

                indicator.setTextColor(
                        ContextCompat.getColor(
                                requireContext(),
                                android.R.color.white
                        )
                );

            } else {

                indicator.setTextColor(
                        ContextCompat.getColor(
                                requireContext(),
                                android.R.color.darker_gray
                        )
                );
            }
        }
    }


    // =================================================
    // UPCOMING EVENTS
    // =================================================

    private void loadUpcomingEvents() {

        upcomingEvents = new ArrayList<>();


        upcomingEvents.add(
                new Event(
                        "Pesta Lawas 2026",
                        "15 October 2026",
                        "Waterfront Lawas",
                        "Festival",
                        "Pesta Lawas is a community celebration featuring cultural performances, local food and community activities.",
                        R.drawable.pesta_lawas
                )
        );


        upcomingEvents.add(
                new Event(
                        "Lawas Community Fun Run",
                        "22 October 2026",
                        "Lawas Town Centre",
                        "Sports",
                        "A community fun run encouraging healthy activities and community participation.",
                        R.drawable.fun_run
                )
        );


        upcomingEvents.add(
                new Event(
                        "Lawas Cultural Night",
                        "5 November 2026",
                        "Lawas Community Hall",
                        "Cultural",
                        "An evening celebrating the diverse cultures and traditions of the Lawas community.",
                        R.drawable.cultural_night
                )
        );
    }


    // =================================================
    // START AUTOMATIC SLIDESHOW
    // =================================================

    @Override
    public void onResume() {

        super.onResume();

        if (sliderHandler != null
                && sliderRunnable != null) {

            sliderHandler.postDelayed(
                    sliderRunnable,
                    SLIDE_DELAY
            );
        }
    }


    // =================================================
    // STOP AUTOMATIC SLIDESHOW
    // =================================================

    @Override
    public void onPause() {

        super.onPause();

        if (sliderHandler != null
                && sliderRunnable != null) {

            sliderHandler.removeCallbacks(
                    sliderRunnable
            );
        }
    }
}
