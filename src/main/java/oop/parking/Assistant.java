package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assistant implements PropertyChangeListener {

    private List<Parking> parkingList;
    private Map<Parking, Double> parkingCapacities = new HashMap<>();

    public Assistant(final List<Parking> parkingList) {
        this.parkingList = parkingList;

        for (Parking parking : parkingList) {
            parkingCapacities.put(parking, 0.0);
        }
    }

    public boolean parkVehicle(final String licensePlate) {
        boolean success = false;
        int i = 0;
        while (!success && i < parkingList.size() && !parkingList.get(i).isOccupiedAt80Percentage()) {
            success = parkingList.get(i).add(licensePlate);
            i++;
        }
        return success;
    }

    public boolean retrieveVehicle(final String licensePlate) {
        boolean success = false;
        for (Parking parking : parkingList) {
            if (parking.isPresent(licensePlate)) {
                success = parking.retrieveVehicle(licensePlate);
            }
        }
        return success;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final var parkingCapacityChangeEvent = (ParkingCapacityChangeEvent) evt.getNewValue();
        final var parking = (Parking) evt.getSource();
        this.parkingCapacities.put(parking, parkingCapacityChangeEvent.getPercentageOfOccupancy());
    }

    public double getCapacity(final Parking parking) {
        return this.parkingCapacities.get(parking);
    }
}
