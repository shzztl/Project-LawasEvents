package com.example.lawaseventia;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CalendarFragment extends Fragment {
    private TextView txtMonthYear;
    private TextView txtEventCount;
    private TextView txtSelectedDate;
    private GridLayout calendarGrid;
    private LinearLayout eventContainer;
    private Calendar currentMonth;
    private String calendarDate;
    private int selectedDay = -1;

    // Stores all event information
    private final Map<String, List<EventData>> events = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        return inflater.inflate(
                R.layout.fragment_calendar,
                container,
                false
        );
    }

    @Override
    public void onViewCreated(
            @NonNull View view,
            @Nullable Bundle savedInstanceState) {

        super.onViewCreated(
                view,
                savedInstanceState
        );

        // CONNECT TO XML
        txtMonthYear = view.findViewById(R.id.txtMonthYear);
        txtEventCount = view.findViewById(R.id.txtEventCount);
        txtSelectedDate = view.findViewById(R.id.txtSelectedDate);
        calendarGrid = view.findViewById(R.id.calendarGrid);
        eventContainer = view.findViewById(R.id.eventContainer);

        ImageButton previousMonth = view.findViewById(R.id.btnPreviousMonth);
        ImageButton nextMonth = view.findViewById(R.id.btnNextMonth);
        ImageButton btnBack = view.findViewById(R.id.btnBack);

        // INITIAL MONTH
        currentMonth = Calendar.getInstance();

        if (getArguments() != null) {
            calendarDate = getArguments().getString("calendarDate");
        }

        if (calendarDate != null && !calendarDate.isEmpty()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                        "yyyy-MM-dd",
                        Locale.ENGLISH
                );

                Calendar eventCalendar = Calendar.getInstance();

                eventCalendar.setTime(
                        dateFormat.parse(calendarDate)
                );

                currentMonth.set(
                        eventCalendar.get(Calendar.YEAR),
                        eventCalendar.get(Calendar.MONTH),
                        1
                );

                selectedDay = eventCalendar.get(
                        Calendar.DAY_OF_MONTH
                );
            } catch (Exception e) {
                currentMonth.set(
                        2026,
                        Calendar.AUGUST,
                        1
                );
            }
        } else {
            currentMonth.set(
                    2026,
                    Calendar.AUGUST,
                    1
            );
        }

        // LOAD EVENTS
        loadEvents();

        // DISPLAY CALENDAR
        displayCalendar();

        // PREVIOUS MONTH
        previousMonth.setOnClickListener(v -> {
            currentMonth.add(
                    Calendar.MONTH,
                    -1
            );
            displayCalendar();
        });

        // NEXT MONTH
        nextMonth.setOnClickListener(v -> {
            currentMonth.add(
                    Calendar.MONTH,
                    1
            );
            displayCalendar();
        });

        // BACK BUTTON
        btnBack.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .popBackStack();
        });
    }

    // LOAD EVENT INFORMATION
    private void loadEvents() {
        events.clear();

        addEvent(
                "2026-10-14",
                new EventData(
                        "Pesta Lawas 2026",
                        "14 October 2026",
                        "10.00 am - 10.00 pm",
                        "Lawas Waterfront",
                        "Festival",
                        "Enjoy cultural activities, local food, "
                                + "entertainment and the Floating Market."
                )
        );

        addEvent(
                "2026-10-15",
                new EventData(
                        "Pesta Lawas 2026",
                        "15 October 2026",
                        "10.00 am - 10.00 pm",
                        "Lawas Waterfront",
                        "Festival",
                        "Pesta Lawas 2026 features the "
                                + "Floating Market, Regatta boat "
                                + "activities, cultural performances "
                                + "and local food."
                )
        );

        addEvent(
                "2026-10-16",
                new EventData(
                        "Pesta Lawas 2026",
                        "16 October 2026",
                        "10.00 am - 10.00 pm",
                        "Lawas Waterfront",
                        "Festival",
                        "Enjoy cultural activities, local food, "
                                + "entertainment and the Floating Market."
                )
        );

        addEvent(
                "2026-10-17",
                new EventData(
                        "Pesta Lawas 2026",
                        "17 October 2026",
                        "10.00 am - 10.00 pm",
                        "Lawas Waterfront",
                        "Festival",
                        "Community activities, cultural "
                                + "performances and Regatta boat "
                                + "activities."
                )
        );

        addEvent(
                "2026-10-18",
                new EventData(
                        "Pesta Lawas 2026",
                        "18 October 2026",
                        "10.00 am - 10.00 pm",
                        "Lawas Waterfront",
                        "Festival",
                        "Closing activities and community "
                                + "celebration."
                )
        );

        addEvent(
                "2026-09-02",
                new EventData(
                        "Pesta Orang Kampung Lawas 2026",
                        "2 September 2026",
                        "3.00 pm - 11.00 pm",
                        "Lawas Stadium Parking Area",
                        "Festival",
                        "A community celebration showcasing "
                                + "local food, culture, traditions "
                                + "and entertainment."
                )
        );

        addEvent(
                "2026-09-03",
                new EventData(
                        "Pesta Orang Kampung Lawas 2026",
                        "3 September 2026",
                        "3.00 pm - 11.00 pm",
                        "Lawas Stadium Parking Area",
                        "Festival",
                        "A community celebration showcasing "
                                + "local food, culture, traditions "
                                + "and entertainment."
                )
        );

        addEvent(
                "2026-09-04",
                new EventData(
                        "Pesta Orang Kampung Lawas 2026",
                        "4 September 2026",
                        "3.00 pm - 11.00 pm",
                        "Lawas Stadium Parking Area",
                        "Festival",
                        "A community celebration showcasing "
                                + "local food, culture, traditions "
                                + "and entertainment."
                )
        );

        addEvent(
                "2026-09-05",
                new EventData(
                        "Pesta Orang Kampung Lawas 2026",
                        "5 September 2026",
                        "3.00 pm - 11.00 pm",
                        "Lawas Stadium Parking Area",
                        "Festival",
                        "A community celebration showcasing "
                                + "local food, culture, traditions "
                                + "and entertainment."
                )
        );

        addEvent(
                "2026-09-06",
                new EventData(
                        "Pesta Orang Kampung Lawas 2026",
                        "6 September 2026",
                        "3.00 pm - 11.00 pm",
                        "Lawas Stadium Parking Area",
                        "Festival",
                        "A community celebration showcasing "
                                + "local food, culture, traditions "
                                + "and entertainment."
                )
        );

    }

    // ADD EVENT TO MAP
    private void addEvent(String date, EventData event) {

        if (!events.containsKey(date)) {
            events.put(
                    date,
                    new ArrayList<>()
            );
        }
        events.get(date).add(event);
    }

    // DISPLAY CALENDAR
    private void displayCalendar() {
        calendarGrid.removeAllViews();

        SimpleDateFormat monthFormat = new SimpleDateFormat(
                "MMMM yyyy",
                Locale.ENGLISH
        );


        txtMonthYear.setText(
                monthFormat.format(
                        currentMonth.getTime()
                )
        );


        // NO EVENT SECTION
        txtSelectedDate.setText("");

        txtEventCount.setText(
                "Event (0)"
        );
        showNoEvent();

        // FIRST DAY OF MONTH
        Calendar firstDay = (Calendar) currentMonth.clone();

        firstDay.set(
                Calendar.DAY_OF_MONTH,
                1
        );

        int firstDayOfWeek = firstDay.get(Calendar.DAY_OF_WEEK);

        /*
         * Because Android Calendar starts on Sunday
         */

        int offset;

        if (firstDayOfWeek == Calendar.SUNDAY) {
            offset = 6;
        } else {
            offset = firstDayOfWeek - 2;
        }

        // NUMBER OF DAYS
        int daysInMonth = currentMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        // EMPTY CELLS
        for (int i = 0; i < offset; i++) {
            addEmptyDate();
        }

        // ADD DATES
        for (int day = 1; day <= daysInMonth; day++) {
            addDate(day);
        }

        // AUTOMATICALLY SELECT EVENT DATE
        if (selectedDay != -1) {
            String selectedKey = getDateKey(
                    currentMonth.get(Calendar.YEAR),
                    currentMonth.get(Calendar.MONTH),
                    selectedDay
            );

            selectDate(
                    selectedKey,
                    selectedDay
            );
        }
    }

    // EMPTY CALENDAR CELL
    private void addEmptyDate() {
        TextView empty = new TextView(requireContext());

        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

        params.width = 0;
        params.height = 0;

        params.columnSpec = GridLayout.spec(
                GridLayout.UNDEFINED,
                1f
        );

        params.rowSpec = GridLayout.spec(
                GridLayout.UNDEFINED,
                1f
        );

        empty.setLayoutParams(params);

        calendarGrid.addView(
                empty
        );
    }

    // ADD DATE
    private void addDate(int day) {
        TextView date = new TextView(requireContext());

        // DATE NUMBER
        date.setText(
                String.valueOf(day)
        );

        date.setTextSize(
                10
        );

        date.setGravity(
                Gravity.CENTER
        );

        date.setTextColor(
                Color.rgb(
                        70,
                        80,
                        95
                )
        );

        // GRID PARAMETERS
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();

        params.width = 0;
        params.height = 0;

        params.columnSpec = GridLayout.spec(
                GridLayout.UNDEFINED,
                1f
        );

        params.rowSpec = GridLayout.spec(
                GridLayout.UNDEFINED,
                1f
        );

        params.setMargins(
                5,
                5,
                5,
                5
        );
        date.setLayoutParams(params);

        // CREATE DATE KEY
        String key = getDateKey(
                currentMonth.get(Calendar.YEAR),
                currentMonth.get(Calendar.MONTH),
                day);

        // HIGHLIGHT EVENT DATE
        if (events.containsKey(key)) {

            date.setBackgroundResource(
                    R.drawable.calendar_event_date
            );

            date.setTextColor(
                    Color.WHITE
            );
        }

        // ALL DATES ARE CLICKABLE
        date.setOnClickListener(v -> {
            selectDate(key,day);
        });

        calendarGrid.addView(
                date
        );
    }

    // SELECT DATE
    private void selectDate(
            String key,
            int day) {

        // DISPLAY SELECTED DATE
        Calendar selectedDate = (Calendar) currentMonth.clone();

        selectedDate.set(
                Calendar.DAY_OF_MONTH,
                day
        );

        SimpleDateFormat selectedFormat = new SimpleDateFormat(
                "dd MMMM yyyy",
                Locale.ENGLISH
        );

        txtSelectedDate.setText(
                selectedFormat.format(
                        selectedDate.getTime()
                )
        );

        // CHECK EVENTS
        if (events.containsKey(key)) {

            List<EventData> selectedEvents = events.get(key);

            showSelectedEvents(
                    selectedEvents
            );
        } else {
            showNoEvent();
        }
    }

    // SHOW SELECTED EVENTS
    private void showSelectedEvents(List<EventData> selectedEvents) {
        eventContainer.removeAllViews();

        // AUTOMATIC EVENT COUNT
        int count = selectedEvents.size();

        txtEventCount.setText(
                "Event (" + count + ")"
        );

        // ADD EACH EVENT
        for (EventData event : selectedEvents) {
            addEventCard(event);
        }
    }

    // SHOW NO EVENT
    private void showNoEvent() {
        eventContainer.removeAllViews();

        // AUTOMATIC COUNT
        txtEventCount.setText(
                "Event (0)"
        );

        // EMPTY CARD
        LinearLayout emptyCard = new LinearLayout(requireContext());

        emptyCard.setOrientation(
                LinearLayout.VERTICAL
        );

        emptyCard.setGravity(
                Gravity.CENTER
        );

        emptyCard.setPadding(
                10,
                10,
                10,
                10
        );

        emptyCard.setBackgroundResource(
                R.drawable.calendar_event_card
        );

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        emptyCard.setLayoutParams(
                cardParams
        );

        // CALENDAR ICON
        ImageView icon = new ImageView(requireContext());

        icon.setImageResource(
                R.drawable.ic_no_event
        );

        LinearLayout.LayoutParams iconParams =
                new LinearLayout.LayoutParams(
                        105,
                        105
                );

        iconParams.gravity = Gravity.CENTER;

        icon.setLayoutParams(
                iconParams
        );

        // NO EVENT TEXT
        TextView message = new TextView(requireContext());

        message.setText(
                "No Events Available"
        );

        message.setTextColor(
                Color.BLACK
        );

        message.setTextSize(
                13
        );

        message.setGravity(
                Gravity.CENTER
        );

        LinearLayout.LayoutParams messageParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        messageParams.setMargins(
                0,
                20,
                0,
                20
        );

        message.setLayoutParams(
                messageParams
        );

        // ADD TO CARD
        emptyCard.addView(
                icon
        );

        emptyCard.addView(
                message
        );

        eventContainer.addView(
                emptyCard
        );
    }

    // EVENT CARD
    private void addEventCard(EventData event) {

        LinearLayout card = new LinearLayout(requireContext());

        card.setOrientation(
                LinearLayout.VERTICAL
        );

        card.setPadding(
                40,
                25,
                40,
                25
        );

        card.setBackgroundResource(
                R.drawable.calendar_event_card
        );

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        cardParams.setMargins(
                0,
                2,
                0,
                6
        );

        card.setLayoutParams(
                cardParams
        );

        // DATE
        TextView date = createEventText(
                event.date
        );

        // SEPARATOR
        TextView separator = createEventText("------------------------------------------------------------------------------------------");

        separator.setTextColor(
                Color.rgb(
                        120,
                        110,
                        130
                )
        );

        // EVENT DETAILS
        TextView title = createEventText(event.title);

        title.setTextSize(
                14
        );

        title.setTypeface(
                null,
                Typeface.BOLD
        );

        TextView time = createEventText(event.time);
        TextView location =createEventText(event.location);

        // ADD CONTENT
        card.addView(
                date
        );

        card.addView(
                separator
        );

        card.addView(
                title
        );

        card.addView(
                time
        );

        card.addView(
                location
        );

        eventContainer.addView(
                card
        );
    }

    // CREATE EVENT TEXT
    private TextView createEventText(String text) {
        TextView textView = new TextView(requireContext());

        textView.setText(
                text
        );

        textView.setTextColor(
                Color.BLACK
        );

        textView.setTextSize(
                12
        );

        textView.setPadding(
                0,
                2,
                0,
                2
        );
        return textView;
    }

    // CREATE DATE KEY
    private String getDateKey(int year, int month, int day) {

        return String.format(
                Locale.ENGLISH,
                "%04d-%02d-%02d",
                year,
                month + 1,
                day
        );
    }

    // EVENT DATA CLASS
    private static class EventData {
        String title;
        String date;
        String time;
        String location;
        String category;
        String description;

        EventData(
                String title,
                String date,
                String time,
                String location,
                String category,
                String description) {


            this.title = title;
            this.date = date;
            this.time = time;
            this.location = location;
            this.category = category;
            this.description = description;
        }
    }
}
