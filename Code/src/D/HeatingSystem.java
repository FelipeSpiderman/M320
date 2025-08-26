package D;

import java.util.HashMap;
import java.util.Map;

class Heater {
    private double temperature;
    public Heater(double initialTemp) {
        this.temperature = initialTemp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double newTemp) {
        if (newTemp >= 10.0 && newTemp <= 30.0) {
            temperature = newTemp;
            System.out.println("Temperature set to " + newTemp);
        } else {
            System.out.println("Invalid temperature range.");
        }
    }
}

class House {
    private Map<String, Heater> rooms;
    public House() {
        rooms = new HashMap<>();
    }

    public void addRoom(String roomName, Heater heater) {
        rooms.put(roomName, heater);
    }

    public void setTemperatureForRoom(String roomName, double newTemp) {
        Heater heater = rooms.get(roomName);
        if (heater != null) {
            heater.setTemperature(newTemp);
        } else {
            System.out.println("Room not found.");
        }
    }

    public double getTemperatureForRoom(String roomName) {
        Heater heater = rooms.get(roomName);
        if (heater != null) {
            return heater.getTemperature();
        }
        return -1;
    }
}

public class HeatingSystem {
    public static void main(String[] args) {
        House house = new House();


        Heater livingRoomHeater = new Heater(20.0);
        Heater bedroomHeater = new Heater(18.0);

        house.addRoom("Living Room", livingRoomHeater);
        house.addRoom("Bedroom", bedroomHeater);

        System.out.println("Initial temperatures:");
        System.out.println("Living Room: " + house.getTemperatureForRoom("Living Room"));
        System.out.println("Bedroom: " + house.getTemperatureForRoom("Bedroom"));

        house.setTemperatureForRoom("Living Room", 22.0);
        house.setTemperatureForRoom("Bedroom", 19.5);

        System.out.println("Updated temperatures:");
        System.out.println("Living Room: " + house.getTemperatureForRoom("Living Room"));
        System.out.println("Bedroom: " + house.getTemperatureForRoom("Bedroom"));
    }
}