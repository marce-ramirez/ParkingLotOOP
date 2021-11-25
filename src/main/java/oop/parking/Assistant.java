package oop.parking;

import java.util.List;

public class Assistant {

    private List<Parking> parkingList;

    public Assistant(final List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

    public boolean parkVehicle(String licensePlate) {
        boolean success = false;
        int i = 0;
        while (!success && i < parkingList.size()) {
            success = parkingList.get(i).add(licensePlate);
            i++;
        }
        return success;
    }

    public boolean retrieveVehicle(String licensePlate) {
        boolean success = false;
        for (Parking parking : parkingList) {
            if (parking.isPresent(licensePlate)) {
                success = parking.retrieveVehicle(licensePlate);
            }
        }
        return success;
    }
}
