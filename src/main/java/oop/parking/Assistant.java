package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assistant implements PropertyChangeListener {

    private Map<Parking, Double> parkingOccupancies = new LinkedHashMap<>();

    public Assistant(final List<Parking> parkingList) {
        for (Parking parking : parkingList) {
            parkingOccupancies.put(parking, 0.0);
        }
    }

    public boolean parkVehicle(final Car car) {
        boolean success = false;
        final var parkingList = parkingOccupancies.keySet().stream().collect(Collectors.toList());
        int i = 0;
        while (!success && i < parkingList.size() && isOccupiedAt80Percent(i)) {
            success = parkingList.get(i).addVehicle(car);
            i++;
        }
        return success;
    }

    private boolean isOccupiedAt80Percent(int i) {
        final var parkingList = parkingOccupancies.keySet().stream().collect(Collectors.toList());
        final var occupancy = this.parkingOccupancies.get(parkingList.get(i));
        return occupancy < 80;
    }

    public boolean retrieveVehicle(final Car car) {
        final var parkingList = parkingOccupancies.keySet().stream().collect(Collectors.toList());
        boolean success = false;
        for (Parking parking : parkingList) {
            if (parking.isPresent(car)) {
                success = parking.retrieveVehicle(car);
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
