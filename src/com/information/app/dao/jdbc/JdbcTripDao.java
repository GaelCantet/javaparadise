package com.information.app.dao.jdbc;

import com.information.app.dao.TripDao;
import com.information.app.model.Place;
import com.information.app.model.Trip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao {
    public JdbcTripDao(){
        super();
    }

    @Override
    public Long createTrip(Trip trip) {
        try {
            Statement st = connection.createStatement();
            String query = "INSERT INTO trip (departure, arrival, price) VALUES ('"+
                    trip.getDeparture().getId() + "', '" +
                    trip.getArrival().getId() + "', '" +
                    trip.getPrice() + "')";
            st.executeUpdate(query);
            query = "SELECT max(id) AS id FROM trip";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                trip.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trip.getId();
    }

    @Override
    public Trip findTripById(Long id) {
        Trip trip = null;
        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM trip WHERE id = " + id;
            ResultSet resultSet = st.executeQuery(query);

            long departureId = 0;
            long arrivalId = 0;
            float price = 0;
            while (resultSet.next()) {
                departureId = resultSet.getLong("departure");
                arrivalId = resultSet.getLong("arrival");
                price = resultSet.getFloat("price");
            }

            JdbcPlaceDao placeDao = new JdbcPlaceDao();
            Place placeDeparture = placeDao.findPlaceById(departureId);
            Place placeArrival = placeDao.findPlaceById(arrivalId);

            trip = new Trip(id, placeDeparture, placeArrival, price);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trip;
    }

    @Override
    public boolean removeTrip(Trip trip) {
        try {
            Statement st = connection.createStatement();
            String query = "DELETE FROM trip WHERE id = " + trip.getId();
            st.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Trip> findAllTrip() {
        List<Trip> listTrip = new ArrayList<Trip>();
        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM trip";
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                JdbcPlaceDao placeDao = new JdbcPlaceDao();
                long id = resultSet.getLong("id");
                Place departure = placeDao.findPlaceById(resultSet.getLong("departure"));
                Place arrival = placeDao.findPlaceById(resultSet.getLong("arrival"));
                float price = resultSet.getFloat("price");
                Trip trip = new Trip(id, departure, arrival, price);
                listTrip.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTrip;
    }
}
