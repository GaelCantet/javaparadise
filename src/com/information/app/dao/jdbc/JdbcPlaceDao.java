package com.information.app.dao.jdbc;

import com.information.app.dao.PlaceDao;
import com.information.app.model.Place;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao {
    public JdbcPlaceDao(){
        super();
    }


    @Override
    public Long createPlace(Place place) throws SQLException {
        Long id;
        // requête insertion
        connection.createStatement().executeUpdate("INSERT INTO place (name) VALUES ('"+place.getName()+"')");
        // id = id du dernier place inséré {MAX(id)}
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT MAX(id) as 'id' from Place");
        while (resultSet.next()) {
            id = resultSet.getLong("id");
            place.setId(id);
        }
        return place.getId();
    }

    @Override
    public Place findPlaceById(Long id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT name from place WHERE id=" + id + "");
        String name = null;
        while (resultSet.next()) {
            name = resultSet.getString("name");
        }
        return new Place(id, name);
    }

    @Override
    public boolean updatePlace(Place place) {
        try{
            connection.createStatement().execute("UPDATE place SET name = '"+place.getName()+"' WHERE id="+place.getId()+"");
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    @Override
    public boolean removePlace(Place place) {
        try{
            connection.createStatement().execute("DELETE FROM trip\n" +
                    "WHERE departure = "+place.getId()+"\n" +
                    "OR arrival = "+place.getId()+"");
            connection.createStatement().execute("DELETE FROM place\n" +
                    "WHERE id = "+place.getId()+"");
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    @Override
    public List<Place> findAllPlace() throws SQLException {
        List<Place> places = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT id, name from place");
        Long id = null;
        String name = null;
        while (resultSet.next()) {
            id = resultSet.getLong("id");
            name = resultSet.getString("name");
            places.add(new Place(id, name));
        }
        return places;
    }
}