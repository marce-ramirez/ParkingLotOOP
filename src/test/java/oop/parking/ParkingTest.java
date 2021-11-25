package oop.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ParkingTest {

    private static final String LICENSE_PLATE = "MAT-001";

    @Test
    public void itShouldNotAllowVehiclesIfNoAvailableSpace() {
        assertFalse(new Parking(0).add(LICENSE_PLATE));
    }

    @Test
    public void itShouldAllowVehiclesIfAvailableSpace() {
        final var parking = new Parking(5);
        assertEquals(5, parking.getAvailableSpace());
        assertTrue(parking.add(LICENSE_PLATE));
        assertTrue(parking.isPresent(LICENSE_PLATE));
        assertEquals(4, parking.getAvailableSpace());
    }

    @Test
    public void itShouldNotAllowDuplicateVehicles() {
        final var parking = new Parking(5);
        assertTrue(parking.add(LICENSE_PLATE));
        assertFalse(parking.add(LICENSE_PLATE));
    }

    @Test
    public void itShouldAllowCarRetrieval() {
        final var parking = new Parking(5);
        assertFalse(parking.retrieveVehicle(LICENSE_PLATE));
        assertTrue(parking.add(LICENSE_PLATE));
        assertTrue(parking.isPresent(LICENSE_PLATE));
        assertTrue(parking.retrieveVehicle(LICENSE_PLATE));
    }

    @Test
    public void itShouldNotifyIfUsageBiggerThan80Percent() {
        final var parking = new Parking(5);
        parking.add("M-1");
        parking.add("M-2");
        parking.add("M-3");
        parking.add("M-4");
        assertTrue(parking.isOccupiedAt80Percentage());
    }

    @Test
    public void itShouldNotifyFalseIfUsageIs0() {
        final var parking = new Parking(0);
        assertFalse(parking.isOccupiedAt80Percentage());
    }
}