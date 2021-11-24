package oop.parking;

public class Assistant {

    private Parking parking;

    public Assistant(Parking parking) {
        this.parking = parking;
    }

    public boolean parkVehicle(String licensePlate) {
        return parking.add(licensePlate);
    }

    public boolean retrieveVehicle(String licensePlate) {
        return parking.retrieveVehicle(licensePlate);
    }
}
