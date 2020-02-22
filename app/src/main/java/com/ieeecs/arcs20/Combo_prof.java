package com.ieeecs.arcs20;

public class Combo_prof {
    private String combotype;
    private String event1;
    private String event2;
    private float event1price;
    private float event2price;
    private float total=event1price+event2price;

    public Combo_prof() {
    }

    public Combo_prof(String combotype, String event1, String event2, float event1price, float event2price) {
        this.combotype = combotype;
        this.event1 = event1;
        this.event2 = event2;
        this.event1price = event1price;
        this.event2price = event2price;
        total=event1price+event2price;

    }

    public void setCombotype(String combotype) {
        this.combotype = combotype;
    }

    public void setEvent1(String event1) {
        this.event1 = event1;
    }

    public void setEvent2(String event2) {
        this.event2 = event2;
    }

    public void setEvent1price(float event1price) {
        this.event1price = event1price;
    }

    public void setEvent2price(float event2price) {
        this.event2price = event2price;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCombotype() {
        return combotype;
    }

    public String getEvent1() {
        return event1;
    }

    public String getEvent2() {
        return event2;
    }

    public float getEvent1price() {
        return event1price;
    }

    public float getEvent2price() {
        return event2price;
    }

    public float getTotal() {
        return total;
    }
}
