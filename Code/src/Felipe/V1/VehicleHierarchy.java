package Felipe.V1;

import java.util.ArrayList;
import java.util.Collections;

abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public abstract void displayInfo();
}

class Car extends Vehicle implements Comparable<Car> {
    private int doors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + ", Year: " + year + ", Doors: " + doors);
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.year, other.year);
    }
}

class Truck extends Vehicle {
    private double payload;

    public Truck(String brand, int year, double payload) {
        super(brand, year);
        this.payload = payload;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck: " + brand + ", Year: " + year + ", Payload: " + payload + " tons");
    }
}

class VehicleList extends ArrayList<Vehicle> {
    public void displayAll() {
        for (Vehicle v : this) {
            v.displayInfo();
        }
    }
}

public class VehicleHierarchy {
    public static void main(String[] args) {
        VehicleList vehicles = new VehicleList();
        vehicles.add(new Car("Toyota", 2020, 4));
        vehicles.add(new Car("BMW", 2018, 2));
        vehicles.add(new Truck("Volvo", 2019, 5.5));

        vehicles.displayAll();

        ArrayList<Car> cars = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars.add((Car) v);
        }

        Collections.sort(cars);
        System.out.println("\nSorted Cars:");
        for (Car car : cars) {
            car.displayInfo();
        }
    }
}
