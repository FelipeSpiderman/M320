package Felipe.D2;

import java.util.Scanner;
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

class FlightManager {
    private Schedule schedule;
    private Scanner scanner;

    public FlightManager() {
        this.schedule = new Schedule();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Flight\n2. Register Passenger\n3. Search Flight\n4. Remove Passenger\n5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    schedule.addFlight(new Flight(flightNumber));
                    System.out.println("Flight " + flightNumber + " added.");
                    break;
                case "2":
                    System.out.print("Enter flight number: ");
                    String regFlight = scanner.nextLine();
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    schedule.registerPassenger(regFlight, new Passenger(passengerName));
                    break;
                case "3":
                    System.out.print("Enter flight number to search: ");
                    String searchFlight = scanner.nextLine();
                    schedule.searchFlight(searchFlight);
                    break;
                case "4":
                    System.out.print("Enter flight number: ");
                    String remFlight = scanner.nextLine();
                    System.out.print("Enter passenger name to remove: ");
                    String remPassenger = scanner.nextLine();
                    schedule.removePassengerFromFlight(remFlight, new Passenger(remPassenger));
                    break;
                case "5":
                     System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new FlightManager().run();
    }
}