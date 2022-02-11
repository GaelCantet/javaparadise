package com.information.app;

import com.information.app.dao.jdbc.JdbcPlaceDao;
import com.information.app.model.Place;

import java.sql.SQLException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws SQLException {
        System.out.println("1 - Add a place");
        System.out.println("2 - Find a place");
        System.out.println("3 - Edit a place");
        System.out.println("4 - Remove a place");
        System.out.println("5 - Add a trip");
        System.out.println("6 - Find a trip");
        System.out.println("7 - Remove a trip");
        System.out.println("8 - Quit");

        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.print("Name : ");
            String name = scanner.next();
            Long id = new JdbcPlaceDao().createPlace(new Place(name));
            System.out.println("id = "+id);
        }else if(choice == 2){
            // find place
        }else if(choice == 3){
            // edit place
        }else if(choice == 4){
            // remove place
        }else if(choice == 5){
            // add trip
        }else if(choice == 6){
            // find trip
        }else if(choice == 7){
            // remove trip
        }else if(choice == 8){
            // quit
        }else{
            System.out.println("erreur saisie");
        }
    }
}
