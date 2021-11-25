package oop.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssistantTest {

    private static final String LICENSE_PLATE = "MAT-001";
    private Assistant assistant;
    private Parking parking;
    private Parking parkingOther;
    private List<Parking> parkingList;

    @Before
    public void setUp() {
        this.parking = new Parking(1);
        this.parkingOther = new Parking(10);
        this.parkingList = new ArrayList<>();
        this.parkingList.add(parking);
        this.parkingList.add(parkingOther);
        this.assistant = new Assistant(parkingList);
    }

    @Test
    public void itShouldParkVehicleInFirstParkingWithSpace() {
        final var parkingFull = new Parking(0);
        final var parkingAvailable = new Parking(2);
        final var parkingList = List.of(parkingFull, parkingAvailable);
        final var assistant = new Assistant(parkingList);
        assertTrue(assistant.parkVehicle(LICENSE_PLATE));
    }

    @Test
    public void itShouldRetrieveVehicle() {
        assistant.parkVehicle(LICENSE_PLATE);
        assertTrue(assistant.retrieveVehicle(LICENSE_PLATE));
        assertFalse(assistant.retrieveVehicle(LICENSE_PLATE));
    }
}