package oop.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParkingTest {

    private static final String LICENSE_PLATE = "MAT-001";

    @Test
    public void itShouldNotAllowVehiclesIfNoAvailableSpace() {
        assertFalse(new Parking(0).addVehicle(new Car(LICENSE_PLATE, false)));
    }

    @Test
    public void itShouldAllowVehiclesIfAvailableSpace() {
        final var parking = new Parking(5);
        assertEquals(5, parking.getAvailableSpace());
        assertTrue(parking.addVehicle(new Car(LICENSE_PLATE, false)));
        assertTrue(parking.isPresent(new Car(LICENSE_PLATE, false)));
        assertEquals(4, parking.getAvailableSpace());
    }

    @Test
    public void itShouldNotAllowDuplicateVehicles() {
        final var parking = new Parking(5);
        assertTrue(parking.addVehicle(new Car(LICENSE_PLATE, false)));
        assertFalse(parking.addVehicle(new Car(LICENSE_PLATE, false)));
    }

    @Test
    public void itShouldAllowCarRetrieval() {
        final var parking = new Parking(5);
        assertFalse(parking.retrieveVehicle(new Car(LICENSE_PLATE, false)));
        assertTrue(parking.addVehicle(new Car(LICENSE_PLATE, false)));
        assertTrue(parking.isPresent(new Car(LICENSE_PLATE, false)));
        assertTrue(parking.retrieveVehicle(new Car(LICENSE_PLATE, false)));
    }
}