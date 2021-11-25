package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assistant implements PropertyChangeListener {

    private List<Parking> parkingList;
    private Map<Parking, Double> parkingOccupancies = new HashMap<>();

    public Assistant(final List<Parking> parkingList) {
        this.parkingList = parkingList;

        for (Parking parking : parkingList) {
            parkingOccupancies.put(parking, 0.0);
        }
    }

    public boolean parkVehicle(final String licensePlate) {
        boolean success = false;
        int i = 0;
        while (!success && i < parkingList.size() && isOccupiedAt80Percent(i)) {
            success = parkingList.get(i).add(licensePlate);
            i++;
        }
        return success;
    }

    private boolean isOccupiedAt80Percent(int i) {
        final var occupancy = this.parkingOccupancies.get(parkingList.get(i));
        return occupancy < 80;
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
        this.parkingOccupancies.put(parking, parkingCapacityChangeEvent.getPercentageOfOccupancy());
    }

    public double getCapacity(final Parking parking) {
        return this.parkingOccupancies.get(parking);
    }
}
