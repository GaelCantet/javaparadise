package com.information.app.model;

public class Trip {
    private long id = 0;
    private Place departure;
    private Place arrival;
    private float price;

    public Trip(long id, Place departure, Place arrival, float price) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
