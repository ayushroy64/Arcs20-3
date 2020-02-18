package com.ieeecs.arcs20;

public class Event {

    private String event;
    private String venue;
    private int image;
    private int gradient;

    public Event() {
    }

    public Event(String event, String venue, int image, int gradient) {
        this.event = event;
        this.venue = venue;
        this.image = image;
        this.gradient = gradient;
    }

    public int getGradient() {
        return gradient;
    }

    public String getEvent() {
        return event;
    }

    public String getVenue() {
        return venue;
    }

    public int getImage() {
        return image;
    }

    public void setGradient(int gradient) {
        this.gradient = gradient;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
