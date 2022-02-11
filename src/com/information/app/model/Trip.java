package com.information.app.model;

public class Trip {
    private long id;
    private Place departure;
    private Place arrival;
    private float price;

    public Trip(Place departure, Place arrival, float price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public Place getDeparture() {
        return departure;
    }

    public Place getArrival() {
        return arrival;
    }

    public float getPrice() {
        return price;
    }

    public void setDeparture(Place departure) {
        this.departure = departure;
    }

    public void setArrival(Place arrival) {
        this.arrival = arrival;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
