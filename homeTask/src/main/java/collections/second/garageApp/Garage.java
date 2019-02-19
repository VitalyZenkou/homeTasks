package collections.second.garageApp;

import collections.second.garageApp.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    private static final int DEFAULT = 1;
    private Map<Vehicle, Integer> autoPark;

    public Garage() {
        autoPark = new HashMap<>();
    }

    public Map<Vehicle, Integer> getAutoPark() {
        return autoPark;
    }

    public boolean park(Vehicle vehicle) {
        if (autoPark.isEmpty()) {
            autoPark.put(vehicle, DEFAULT);
            return true;
        } else {
            if (autoPark.containsKey(vehicle)) {
                int amount = autoPark.get(vehicle);
                amount++;
                autoPark.put(vehicle, amount);
            } else {
                autoPark.put(vehicle, DEFAULT);
            }
            return true;
        }
    }

    public boolean moveOut(Vehicle vehicle) {
        if (!autoPark.isEmpty()) {
            if (autoPark.containsKey(vehicle) && autoPark.get(vehicle) > DEFAULT) {
                int amount = autoPark.get(vehicle);
                amount--;
                autoPark.put(vehicle, amount);
            } else {
                autoPark.remove(vehicle);
            }
            return true;
        } else {
            return false;
        }
    }

    private int getAmountOfVehicle(Vehicle vehicle) {
        if (autoPark.containsKey(vehicle)) {
            return autoPark.get(vehicle);
        }
        return 0;
    }
}
