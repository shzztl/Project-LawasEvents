package com.example.lawaseventia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ViewPager2 viewPagerLawas;
    private LawasImageAdapter lawasImageAdapter;
    private ViewPager2 viewPagerEvents;
    private EventAdapter eventAdapter;
    private LinearLayout lawasIndicators;
    private LinearLayout eventIndicators;
    private ImageButton btnEventPrevious;
    private ImageButton btnEventNext;
    private TextView txtHomeEventTitle;
    private TextView txtHomeEventDate;
    private Handler sliderHandler;
    private Runnable sliderRunnable;
    private static final long SLIDE_DELAY = 3000;
    private ArrayList<Integer> lawasImages;
    private ArrayList<Event> upcomingEvents;

    // ON CREATE VIEW
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
        // FIND VIEWS
        // Lawas image carousel
        viewPagerLawas = view.findViewById(
                R.id.viewPagerLawas
        );
        // Upcoming event carousel
        viewPagerEvents = view.findViewById(
                R.id.viewPagerEvents
        );
        // Lawas indicators
        lawasIndicators = view.findViewById(
                R.id.lawasIndicators
        );
        // Event indicators
        eventIndicators = view.findViewById(
                R.id.eventIndicators
        );
        // Event previous button
        btnEventPrevious = view.findViewById(
                R.id.btnEventPrevious
        );
        // Event next button
        btnEventNext = view.findViewById(
                R.id.btnEventNext
        );
        //Event title
        txtHomeEventTitle = view.findViewById(
                R.id.txtHomeEventTitle
        );
        //Event date
        txtHomeEventDate = view.findViewById(
                R.id.txtHomeEventDate
        );

        // LOAD LAWAS IMAGES
        loadLawasImages();

        // SET LAWAS IMAGE ADAPTER
        lawasImageAdapter = new LawasImageAdapter(lawasImages);

        viewPagerLawas.setAdapter(
                lawasImageAdapter
        );

        // CREATE LAWAS IMAGE INDICATORS
        setupIndicators();

        // UPDATE LAWAS INDICATOR WHEN USER SWIPES
        viewPagerLawas.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateIndicators(position);
            }
        });

        // AUTOMATIC LAWAS IMAGE SLIDESHOW
        sliderHandler = new Handler(
                Looper.getMainLooper()
        );

        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                if (lawasImages != null && !lawasImages.isEmpty()) {
                    int nextPosition = viewPagerLawas.getCurrentItem() + 1;

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

        // LOAD UPCOMING EVENTS
        loadUpcomingEvents();

        // SET UPCOMING EVENT ADAPTER
        eventAdapter = new EventAdapter(
                requireContext(),
                upcomingEvents
        );

        viewPagerEvents.setAdapter(
                eventAdapter
        );

        updateHomeEventInfo(0);

        // CREATE EVENT INDICATORS
        setupEventIndicators();

        // UPDATE EVENT INDICATOR WHEN USER SWIPES
        viewPagerEvents.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateEventIndicators(position);
                updateHomeEventInfo(position);
            }
        });

        // PREVIOUS EVENT BUTTON
        btnEventPrevious.setOnClickListener(v -> {
            int currentPosition = viewPagerEvents.getCurrentItem();

            if (currentPosition > 0) {
                viewPagerEvents.setCurrentItem(
                        currentPosition - 1,
                        true
                );
            }
        });

        // NEXT EVENT BUTTON
        btnEventNext.setOnClickListener(v -> {
            int currentPosition = viewPagerEvents.getCurrentItem();

            if (currentPosition < upcomingEvents.size() - 1) {
                viewPagerEvents.setCurrentItem(
                        currentPosition + 1,
                        true
                );
            }
        });
        return view;
    }

    // LAWAS IMAGES
    private void loadLawasImages() {
        lawasImages = new ArrayList<>();

        lawasImages.add(
                R.drawable.lawas1
        );
        lawasImages.add(
                R.drawable.lawas2
        );
        lawasImages.add(
                R.drawable.lawas3
        );
        lawasImages.add(
                R.drawable.lawas4
        );
        lawasImages.add(
                R.drawable.lawas5
        );
    }

    // LAWAS IMAGE INDICATORS
    private void setupIndicators() {
        lawasIndicators.removeAllViews();

        for (int i = 0; i < lawasImages.size(); i++) {
            TextView indicator = new TextView(requireContext());

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

    // UPDATE LAWAS IMAGE INDICATORS
    private void updateIndicators(int selectedPosition) {
        if (lawasIndicators == null) {
            return;
        }

        for (int i = 0; i < lawasIndicators.getChildCount(); i++) {
            TextView indicator = (TextView) lawasIndicators.getChildAt(i);

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

    // UPCOMING EVENTS
    private void loadUpcomingEvents() {
        upcomingEvents = new ArrayList<>();

        //EVENT 1
        upcomingEvents.add(
                new Event(
                        "Pesta Orang Kampung",
                        "2 - 6 September 2026, Rabu - Ahad",
                        "3.00 petang - 11.00 malam",
                        "PERCUMA",
                        "Terbuka kepada orang awam",
                        "Stadium Lawas",
                        "Pesta",
                        "Pesta Orang Kampung (POK) Lawas 2026 menghimpunkan masyarakat dalam sebuah sambutan meriah yang mengetengahkan budaya, tradisi, makanan dan hiburan tempatan. Nikmati pelbagai makanan tempatan, persembahan kebudayaan, aktiviti tradisional dan pertandingan komuniti yang menarik sambil merasai keunikan semangat kampung di Lawas.",
                        " ● Permainan dan pertandingan tradisional\n" +
                                " ● Persembahan kebudayaan\n" +
                                " ● Makanan tempatan dan hidangan tradisional\n" +
                                " ● Pameran kraftangan dan produk tempatan\n" +
                                " ● Aktiviti kemasyarakatan\n" +
                                " ● Hiburan mesra keluarga",
                        "RS Food Sdn Bhd",
                        "Peniaga yang berminat atau mereka yang ingin mendapatkan ruang gerai boleh menghubungi 019-530 1248 secara terus.",
                        "https://www.facebook.com/p/Pesta-Orang-Kampung-100093304011179/",
                        "2026-09-02",
                        R.drawable.pesta_org_kpg,

                        //LOCATION
                        4.873043723482146,
                        115.40664788164086
                )
        );

        // EVENT 2
        upcomingEvents.add(
                new Event(
                        "Pesta Lawas 2026",
                        "14 - 18 Oktober 2026, Rabu - Ahad",
                        "9.00 pagi - 11.00 malam",
                        "PERCUMA",
                        "Terbuka kepada orang awam",
                        "Waterfront Lawas",
                        "Pesta",
                        "Pesta Lawas 2026 meraikan kekayaan budaya dan semangat kemasyarakatan Lawas dengan pelbagai aktiviti, termasuk Pasar Terapung yang meriah dengan makanan dan produk tempatan, serta pertandingan Perahu Regata yang menarik bagi mengetengahkan warisan sungai di bandar ini. Sertai kami untuk menikmati sambutan yang penuh dengan budaya, makanan, hiburan dan aktiviti kemasyarakatan.",
                        " ● Perlumbaan perahu regata\n" +
                                " ● Pasar terapung\n" +
                                " ● Makanan tempatan dan juadah tradisional\n" +
                                " ● Persembahan kebudayaan\n" +
                                " ● Kraftangan tempatan dan produk PKS\n" +
                                " ● Hiburan di tebingan\n" +
                                " ● Aktiviti komuniti dan keluarga",
                        "Pejabat Daerah Lawas",
                        "Peniaga yang berminat atau mereka yang ingin mendapatkan ruang gerai boleh menghubungi 082 - 283 105 secara terus.",
                        "https://talikhidmat.sarawak.gov.my/talikhidmat/web/home/agency_view/393",
                        "2026-10-14",
                        R.drawable.pesta_lawas,

                        //LOCATION
                        4.85685785797304,
                        115.40784333558247
                )
        );
    }

    // EVENT INDICATORS
    private void setupEventIndicators() {
        eventIndicators.removeAllViews();

        for (int i = 0; i < upcomingEvents.size(); i++) {

            TextView indicator = new TextView(requireContext());

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

            eventIndicators.addView(
                    indicator
            );
        }
        updateEventIndicators(0);
    }

    // UPDATE EVENT INDICATORS
    private void updateEventIndicators(int selectedPosition) {
        if (eventIndicators == null) {
            return;
        }

        for (int i = 0; i < eventIndicators.getChildCount(); i++) {
            TextView indicator = (TextView) eventIndicators.getChildAt(i);

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

    //UPDATE HOME EVENT INFO
    private void updateHomeEventInfo(int position) {
        if (upcomingEvents == null || upcomingEvents.isEmpty()) {
            return;
        }

        if (position < 0 || position >= upcomingEvents.size()) {
            return;
        }

        Event event = upcomingEvents.get(position);

        txtHomeEventTitle.setText(
                event.getTitle()
        );

        txtHomeEventDate.setText(
                event.getDate()
        );
    }

    // START AUTOMATIC LAWAS SLIDESHOW
    @Override
    public void onResume() {
        super.onResume();

        if (sliderHandler != null && sliderRunnable != null) {
            sliderHandler.postDelayed(
                    sliderRunnable,
                    SLIDE_DELAY
            );
        }
    }

    // STOP AUTOMATIC LAWAS SLIDESHOW
    @Override
    public void onPause() {
        super.onPause();

        if (sliderHandler != null && sliderRunnable != null) {
            sliderHandler.removeCallbacks(
                    sliderRunnable
            );
        }
    }
}
