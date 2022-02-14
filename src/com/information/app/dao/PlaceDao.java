package com.information.app.dao;

import com.information.app.model.Place;

import java.sql.SQLException;
import java.util.List;

public interface PlaceDao {
    public Long createPlace(Place place) throws SQLException; //retournera un Long
    public Place findPlaceById(Long id) throws SQLException; //retournera une Place
    public boolean updatePlace(Place place) throws SQLException; //retourne un booléen
    public boolean removePlace(Place place); //retournera un booléen
    public List<Place> findAllPlace() throws SQLException; //retournera une liste de Place
}
