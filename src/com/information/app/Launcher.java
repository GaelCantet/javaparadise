package com.information.app;

import com.information.app.dao.jdbc.JdbcPlaceDao;
import com.information.app.model.Place;

import java.sql.SQLException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) throws SQLException {

        boolean start = true;
        while(start){
            System.out.println("1 - Add a place");
            System.out.println("2 - Find a place");
            System.out.println("3 - Edit a place");
            System.out.println("4 - Remove a place");
            System.out.println("5 - Add a trip");
            System.out.println("6 - Find a trip");
            System.out.println("7 - Remove a trip");
            System.out.println("8 - Quit\n");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();

            if(choice == 1){
                System.out.print("Name : ");
                String name = scanner.next();
                Long id = new JdbcPlaceDao().createPlace(new Place(name));
                System.out.println("Place added with the ID = "+id+"\n");

            }else if(choice == 2){
                // find place
                System.out.print("ID : ");
                Long id = scanner.nextLong();
                Place place = new JdbcPlaceDao().findPlaceById(id);
                System.out.println("Place with id : "+id+" is "+place.getName()+"\n");

            }else if(choice == 3){
                // edit place
                System.out.print("ID : ");
                Long id = scanner.nextLong();
                String name = new JdbcPlaceDao().findPlaceById(id).getName();
                System.out.println("Original name : "+name);
                System.out.print("New name : ");
                String newName = scanner.next();
                boolean success = new JdbcPlaceDao().updatePlace(new Place(id, newName));
                System.out.println("name : "+name+" -> "+newName+" for id = "+id+"\n");

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
                start = false;
            }else{
                System.out.println("erreur saisie");
            }
        }

    }
}
