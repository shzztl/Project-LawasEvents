package com.example.lawaseventia;

public class Event {
    private String title;
    private String date;
    private String time;
    private String entrance1;
    private String entrance2;
    private String location;
    private String category;
    private String description;
    private String attractions;
    private String organizer;
    private String organizerInfo;
    private String clicklink;
    private String calendarDate;
    private int imageResource;
    private double latitude;
    private double longitude;

    public Event(
            String title,
            String date,
            String time,
            String entrance1,
            String entrance2,
            String location,
            String category,
            String description,
            String attractions,
            String organizer,
            String organizerInfo,
            String clicklink,
            String calendarDate,
            int imageResource,
            double latitude,
            double longitude){

        this.title = title;
        this.date = date;
        this.time = time;
        this.entrance1 = entrance1;
        this.entrance2 = entrance2;
        this.location = location;
        this.category = category;
        this.description = description;
        this.attractions = attractions;
        this.organizer = organizer;
        this.organizerInfo = organizerInfo;
        this.clicklink = clicklink;
        this.calendarDate = calendarDate;
        this.imageResource = imageResource;
        this.latitude = latitude;
        this.latitude = latitude;
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

    public String getEntrance1() {
        return entrance1;
    }

    public String getEntrance2(){
        return entrance2;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getAttractions() {
        return attractions;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getOrganizerInfo() {
        return organizerInfo;
    }

    public String getClicklink(){
        return clicklink;
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public int getImageResource() {
        return imageResource;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }
}
