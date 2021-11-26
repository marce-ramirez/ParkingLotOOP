package oop.parking;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

public class Parking {

    private int availableSpace;
    private final int maxCapacity;
    private Set<Car> slots;
    private PropertyChangeSupport support;

    public Parking(final int availableSpace) {
        support = new PropertyChangeSupport(this);
        this.maxCapacity = availableSpace;
        this.availableSpace = availableSpace;
        this.slots = new HashSet<>();
    }

    public boolean addVehicle(final Car car) {
        final var eventPrevious = new ParkingCapacityChangeEvent(maxCapacity, availableSpace);
        slots.add(car);
        availableSpace--;
        final var eventAfter = new ParkingCapacityChangeEvent(maxCapacity, availableSpace);
        support.firePropertyChange("parkingCapacityChangeEvent", eventPrevious, eventAfter);
        return true;
    }

    private boolean isFullParking() {
        return availableSpace <= 0;
    }

    public int getAvailableSpace() {
        return this.availableSpace;
    }

    public boolean retrieveVehicle(Car car) {
        if (!isPresent(car)) {
            return false;
        } else {
            slots.remove(car);
            availableSpace++;
            return true;
        }
    }

    public boolean isPresent(Car car) {
        return slots.contains(car);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
}
