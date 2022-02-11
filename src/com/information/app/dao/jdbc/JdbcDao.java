package com.information.app.dao.jdbc;

import com.information.app.util.ConnectionManager;

import java.sql.Connection;

public abstract class JdbcDao {
    protected Connection connection;

    protected JdbcDao(){
        connection = ConnectionManager.getInstance().getConnection();
    }

}
