package Felipe.V1;

abstract class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public abstract void displayInfo();

    public String getBrand() {
        return brand;
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + ", Year: " + year + ", Doors: " + doors);
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

public class VehicleHierarchy {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2020, 4);
        Truck truck = new Truck("Volvo", 2019, 5.5);
        car.displayInfo();
        truck.displayInfo();
    }
}