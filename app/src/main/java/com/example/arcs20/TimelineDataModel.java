package com.example.arcs20;

public class TimelineDataModel {

    int image;
    String event,eta,venue;

    public TimelineDataModel(int image, String eta, String event, String venue){
        this.image = image;
        this.eta = eta;
        this.event = event;
        this.venue = venue;
    }

    public int getImage() {
        return image;
    }

    public String getEvent() {
        return event;
    }

    public String getEta() {
        return eta;
    }

    public String getVenue() {
        return venue;
    }
}
