package Felipe.D2;

import java.util.ArrayList;
import java.util.List;

class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Flight {
    private String flightNumber;
    private List<Passenger> passengers;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Passenger p) {
        passengers.add(p);
    }

    public void removePassenger(Passenger p) {
        passengers.remove(p);
    }

    public void printPassengers() {
        for (Passenger p : passengers) {
            System.out.println("Passenger: " + p.getName());
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}

class Schedule {
    private List<Flight> flights;

    public Schedule() {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight f) {
        flights.add(f);
    }

    public void registerPassenger(String flightNumber, Passenger p) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                f.addPassenger(p);
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }

    public void searchFlight(String flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                System.out.println("Flight " + flightNumber + " found.");
                f.printPassengers();
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }

    public void removePassengerFromFlight(String flightNumber, Passenger p) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightNumber)) {
                f.removePassenger(p);
                return;
            }
        }
        System.out.println("Flight " + flightNumber + " not found.");
    }
}

public class Main {
    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        Flight flight1 = new Flight("FL123");
        Flight flight2 = new Flight("FL456");

        schedule.addFlight(flight1);
        schedule.addFlight(flight2);

        Passenger p1 = new Passenger("Anna");
        Passenger p2 = new Passenger("Ben");

        schedule.registerPassenger("FL123", p1);
        schedule.registerPassenger("FL123", p2);

        schedule.searchFlight("FL123");
        schedule.removePassengerFromFlight("FL123", p1);
        schedule.searchFlight("FL123");
    }
}