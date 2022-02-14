package com.information.app;

import com.information.app.dao.jdbc.JdbcPlaceDao;
import com.information.app.dao.jdbc.JdbcTripDao;
import com.information.app.model.Place;
import com.information.app.model.Trip;

import java.sql.SQLException;
import java.util.ArrayList;
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
                // add place
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
                if (success){
                    System.out.println("name : "+name+" -> "+newName+" for id = "+id+"\n");
                }else{
                    System.out.println("erreur d'update\n");
                }

            }else if(choice == 4){
                // remove place


            }else if(choice == 5){
                // add trip
                System.out.println("Departure ID : ");
                long departureId = scanner.nextLong();
                Place departure = new JdbcPlaceDao().findPlaceById(departureId);
                System.out.println("Departure : " + departure.getName());
                System.out.println("Arrival ID : ");
                long arrivalId = scanner.nextLong();
                Place arrival = new JdbcPlaceDao().findPlaceById(arrivalId);
                System.out.println("Arrival : " + arrival.getName());
                System.out.println("Price : ");
                float price = scanner.nextFloat();
                long id = new JdbcTripDao().createTrip(new Trip(0, departure, arrival, price));
                System.out.println("Trip added with id : "+id);
            }else if(choice == 6){
                // find trip
                System.out.println("Trip ID : ");
                long tripId = scanner.nextLong();
                Trip trip = new JdbcTripDao().findTripById(tripId);
                System.out.println("Trip ID : " + trip.getId());
                System.out.println("Trip departure : " + trip.getDeparture().getName());
                System.out.println("Trip arrival : " + trip.getArrival().getName());
                System.out.println("Trip price : " + trip.getPrice());
            }else if(choice == 7){
                // remove trip
                System.out.println("Trip ID : ");
                long id = scanner.nextLong();
                Trip trip = new JdbcTripDao().findTripById(id);
                System.out.println(trip.getDeparture().getName() + " - " + trip.getArrival().getName() + ", " + trip.getPrice());
                System.out.println("Are you sure tou want to delete this trip ? [yes/no]");
                if (scanner.next().equals("yes")) {
                    new JdbcTripDao().removeTrip(trip);
                    System.out.println("Trip succesfully deleted");
                } else {
                    System.out.println("Deletion cancelled");
                }
            }else if(choice == 8){
                // quit
                start = false;
            }else{
                System.out.println("erreur saisie");
            }
        }
    }
}