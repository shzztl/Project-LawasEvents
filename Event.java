package com.example.lawasevents;

public class Event {

    private String title;
    private String date;
    private String venue;
    private String category;
    private String description;
    private int imageResource;

    public Event(
            String title,
            String date,
            String venue,
            String category,
            String description,
            int imageResource) {

        this.title = title;
        this.date = date;
        this.venue = venue;
        this.category = category;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
