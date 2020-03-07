package com.ieeecs.arcs20;

public class WorkshopClass {

//    StorageReference image, sImage;
    String name,price,icon,des, date, loc, speakerDetails ;

    public WorkshopClass(String name, String price, String icon, String des, String date, String loc, String speaker) {
        this.name = name;
        this.price = price;
        this.icon = icon;
        this.des = des;
        this.date = date;
        this.loc = loc;
        this.speakerDetails = speakerDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getSpeakerDetails() {
        return speakerDetails;
    }

    public void setSpeakerDetails(String speakerDetails) {
        this.speakerDetails = speakerDetails;
    }
}
