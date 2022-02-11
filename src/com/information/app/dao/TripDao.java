package com.information.app.dao;

import com.information.app.model.Trip;

import java.util.List;

public interface TripDao {
    public Long createTrip(Trip trip); //retournera un Long
    public Trip findTripById(Long id); //retournera un Trip
    public boolean updateTrip(Trip trip); //retourne un booléen
    public boolean removeTrip(Trip trip); //retournera un booléen
    public List<Trip> findAllTrip(); //retournera une liste de Trip
}
