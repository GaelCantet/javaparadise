package com.information.app.dao.jdbc;

import com.information.app.dao.PlaceDao;
import com.information.app.model.Place;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao {
    public JdbcPlaceDao(){
        super();
    }


    @Override
    public Long createPlace(Place place) throws SQLException {
        Long id;
        // requête insertion
        ResultSet resultSet = connection.createStatement().executeQuery("INSERT INTO place (name) VALUES ('"+place.getName()+"')");
        // id = id du dernier place inséré {MAX(id)}
        // place.setId(id);
        while (resultSet.next()) {
            id = resultSet.getLong("id");
        }
        return place.getId();
    }

    @Override
    public Place findPlaceById(Long id) {
        return null;
    }

    @Override
    public boolean updatePlace(Place place) {
        return false;
    }

    @Override
    public boolean removePlace(Place place) {
        return false;
    }

    @Override
    public List<Place> findAllPlace() {
        return null;
    }
}
