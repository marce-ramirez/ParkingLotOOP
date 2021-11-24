package oop.parking;

import java.util.HashSet;
import java.util.Set;

public class Parking {

    private int availableSpace;
    private Set<String> parkingCollection;

    public Parking(final int availableSpace) {
        this.availableSpace = availableSpace;
        this.parkingCollection = new HashSet<>();
    }

    public boolean add(final String licensePlate) {
        if (!isParkable(licensePlate)) {
            return false;
        } else return addVehicle(licensePlate);
    }

    private boolean isParkable(final String licensePlate) {
        return !isFullParking() && !isPresent(licensePlate);
    }

    private boolean addVehicle(final String licensePlate) {
        parkingCollection.add(licensePlate);
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
            parkingCollection.remove(licensePlate);
            availableSpace++;
            return true;
        }
    }

    public boolean isPresent(String licensePlate) {
        return parkingCollection.contains(licensePlate);
    }
}
