package oop.parking;

import java.util.HashMap;
import java.util.Map;

public class Parking {

    private int availableSpace;
    private Map<String, Integer> parkingMap;

    public Parking(final int availableSpace) {
        this.availableSpace = availableSpace;
        this.parkingMap = new HashMap<>();
    }

    public boolean add(final String licensePlate) {
        if (isFullParking()) {
            return false;
        } else {
            return addVehicle(licensePlate);
        }
    }

    private boolean addVehicle(final String licensePlate) {
        parkingMap.put(licensePlate, 1);
        availableSpace--;
        return true;
    }

    private boolean isFullParking() {
        return availableSpace <= 0;
    }

    public int getAvailableSpace() {
        return this.availableSpace;
    }

    public boolean retrieveVehicle(String licensePlate) {
        if (!isPresent(licensePlate)) {
            return false;
        } else {
          parkingMap.put(licensePlate, 0);
          availableSpace++;
          return true;
        }
    }

    public boolean isPresent(String licensePlate) {
      return parkingMap.get(licensePlate) != null;
    }
}
