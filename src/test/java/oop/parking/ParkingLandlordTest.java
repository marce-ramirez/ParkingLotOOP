package oop.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParkingLandlordTest {

    @Test
    public void itShouldReceiveNotificationWhenParkingUsedMoreThan80Percent() {
        Parking parking = new Parking(10);
        ParkingLandlord parkingLandlord = new ParkingLandlord();

        parking.addPropertyChangeListener(parkingLandlord);
        parking.addVehicle(new Car("M-1", false));
        parking.addVehicle(new Car("M-2", false));
        parking.addVehicle(new Car("M-3", false));
        parking.addVehicle(new Car("M-4", false));
        parking.addVehicle(new Car("M-5", false));
        parking.addVehicle(new Car("M-6", false));
        parking.addVehicle(new Car("M-7", false));
        parking.addVehicle(new Car("M-8", false));

        assertTrue(parkingLandlord.isPurchaseNeeded());
    }

    @Test
    public void itShouldNotReceiveNotificationWhenParkingUsedMoreThan80Percent() {
        Parking parking = new Parking(10);
        ParkingLandlord parkingLandlord = new ParkingLandlord();

        parking.addPropertyChangeListener(parkingLandlord);
        parking.addVehicle(new Car("M-1", false));
        assertFalse(parkingLandlord.isPurchaseNeeded());
    }

    @Test
    public void itShouldCloseParkingIfUsageLessThan20Percent() {
        final var parking = new Parking(6);
        final var parkingLandlord = new ParkingLandlord();
        parking.addPropertyChangeListener(parkingLandlord);

        parking.addVehicle(new Car("M-1", false));
        assertTrue(parkingLandlord.isToBeClosed());
    }

    @Test
    public void itShouldNotCloseParkingIfUsageGreaterThan20Percent() {
        final var parking = new Parking(3);
        final var parkingLandlord = new ParkingLandlord();
        parking.addPropertyChangeListener(parkingLandlord);

        parking.addVehicle(new Car("M-1", false));
        assertFalse(parkingLandlord.isToBeClosed());
    }

    @Test
    public void itShouldReopenIfUsageIncreases20Percent() {
        final var parking = new Parking(6);
        final var parkingLandlord = new ParkingLandlord();
        parking.addPropertyChangeListener(parkingLandlord);

        parking.addVehicle(new Car("M-1", false));
        assertTrue(parkingLandlord.isToBeClosed());
        parking.addVehicle(new Car("M-2", false));
        assertFalse(parkingLandlord.isToBeClosed());
    }
}