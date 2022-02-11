package com.information.app.model;

public class Trip {
    private long id;
    private String departure;
    private String arrival;
    private float price;

    public Trip(Place departure, Place arrival, float price) {
        this.departure = departure.getName();
        this.arrival = arrival.getName();
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public float getPrice() {
        return price;
    }

    public void setDeparture(Place departure) {
        this.departure = departure.getName();
    }

    public void setArrival(Place arrival) {
        this.arrival = arrival.getName();
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
