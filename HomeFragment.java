package com.example.lawasevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ViewPager2 viewPagerEvents;

    ArrayList<Event> upcomingEvents;

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

        viewPagerEvents = view.findViewById(
                R.id.viewPagerEvents
        );

        loadUpcomingEvents();

        EventAdapter adapter =
                new EventAdapter(
                        requireContext(),
                        upcomingEvents
                );

        viewPagerEvents.setAdapter(adapter);

        return view;
    }

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
}
