package com.information.app.dao;

import com.information.app.dao.jdbc.*;

public class DaoFactory {
    private DaoFactory(){}

    public static JdbcTripDao getTripDao(){
        return new JdbcTripDao();
    }

    public static JdbcPlaceDao getPlaceDao(){
        return new JdbcPlaceDao();
    }
}
