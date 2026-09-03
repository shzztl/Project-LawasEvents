package com.example.lawaseventia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageButton;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

public class AboutFragment extends Fragment {

    private ViewPager2 viewPagerAttractions;
    private LinearLayout attractionIndicators;
    private Handler handler;
    private Runnable autoSlideRunnable;
    private ArrayList<Integer> attractionImages;
    private ArrayList<String> attractionNames;
    private int currentPage = 0;


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_about,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        viewPagerAttractions = view.findViewById(R.id.viewPagerAttractions);
        attractionIndicators = view.findViewById(R.id.attractionIndicators);

        ImageButton btnContact = view.findViewById(R.id.btnContact);

        btnContact.setOnClickListener(v -> {
            Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://talikhidmat.sarawak.gov.my/talikhidmat/web/home/agency_view/393")
            );
            startActivity(intent);
        });
        
        //ATTRACTION IMAGES
        attractionImages = new ArrayList<>();

        attractionImages.add(R.drawable.lawas_punang);
        attractionImages.add(R.drawable.lawas_waterfront);
        attractionImages.add(R.drawable.lawas_hotspring);
        attractionImages.add(R.drawable.lawas_nature);

        //ATTRACTION NAMES
        attractionNames = new ArrayList<>();

        attractionNames.add("Punang Nature Walk");
        attractionNames.add("Lawas Waterfront");
        attractionNames.add("Lawas Hot Springs");
        attractionNames.add("Lawas Natural Attractions");

        //ADAPTER
        AttractionAdapter adapter = new AttractionAdapter(
                attractionImages,
                attractionNames
        );

        viewPagerAttractions.setAdapter(adapter);

        //INDICATOR
        createIndicators();

        //PAGE CHANGE
        viewPagerAttractions.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                updateIndicators(position);
            }
        });

        //AUTO SLIDE
        handler = new Handler(Looper.getMainLooper());

        autoSlideRunnable = new Runnable() {
            @Override
            public void run() {
                if (attractionImages.size() > 0) {
                    currentPage++;

                    if (currentPage >= attractionImages.size()) {
                        currentPage = 0;
                    }
                    viewPagerAttractions.setCurrentItem(
                            currentPage,
                            true
                    );
                    handler.postDelayed(
                            this,
                            3000
                    );
                }
            }
        };
    }

    private void createIndicators() {
        attractionIndicators.removeAllViews();

        for (int i = 0; i < attractionImages.size(); i++) {

            TextView indicator = new TextView(requireContext());

            indicator.setText("●");
            indicator.setTextSize(9);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(5, 0, 5, 0);

            attractionIndicators.addView(
                    indicator,
                    params
            );
        }
        updateIndicators(0);
    }

    private void updateIndicators(int position) {
        for (int i = 0; i < attractionIndicators.getChildCount(); i++) {

            TextView indicator = (TextView)attractionIndicators.getChildAt(i);

            if (i == position) {
                indicator.setTextColor(
                        requireContext().getColor(
                                android.R.color.white
                        )
                );
            } else {
                indicator.setTextColor(
                        requireContext().getColor(
                                android.R.color.darker_gray
                        )
                );
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (handler != null) {
            handler.removeCallbacks(
                    autoSlideRunnable
            );
        }
    }


    @Override
    public void onResume() {
        super.onResume();

        if (handler != null) {

            handler.removeCallbacks(
                    autoSlideRunnable
            );

            handler.postDelayed(
                    autoSlideRunnable,
                    3000
            );
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (handler != null) {
            handler.removeCallbacks(
                    autoSlideRunnable
            );
        }
    }
}
