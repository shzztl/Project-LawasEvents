package com.example.lawaseventia;

public class Event {
    private String title;
    private String date;
    private String time;
    private String entrance;
    private String venue;
    private String category;
    private String description;
    private int imageResource;

    public Event(
            String title,
            String date,
            String time,
            String entrance,
            String venue,
            String category,
            String description,
            int imageResource ){

        this.title = title;
        this.date = date;
        this.entrance = entrance;
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

    public String getTime() {
        return time;
    }

    public String getEntrance() {
        return entrance;
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
