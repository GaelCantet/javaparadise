package com.information.app;

import com.information.app.dao.jdbc.JdbcPlaceDao;
import com.information.app.model.Place;

import java.sql.SQLException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws SQLException {
        System.out.println("1 - Add a place");
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        if(choix == 1){
            String name = scanner.next();
            Long id = new JdbcPlaceDao().createPlace(new Place(name));
            System.out.println("id = "+id);
        }
    }
}
