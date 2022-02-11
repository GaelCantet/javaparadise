package com.information.app.dao;

import com.information.app.model.Place;
import java.util.List;

public interface PlaceDao {
    public Long createPlace(Place place); //retournera un Long
    public Place findPlaceById(Long id); //retournera une Place
    public boolean updatePlace(Place place); //retourne un booléen
    public boolean removePlace(Place place); //retournera un booléen
    public List<Place> findAllPlace(); //retournera une liste de Place
}
