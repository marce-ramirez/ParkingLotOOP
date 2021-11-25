package oop.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AssistantTest {

    private static final String LICENSE_PLATE = "MAT-001";
    public static final String LICENSE_PLATE_TEST = "M-1";
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

    @Test
    public void itShouldNotParkIfParkingUsageBiggerThan80Percent() {
        final var parking = new Parking(5);
        final var assistant = new Assistant(List.of(parking));
        assistant.parkVehicle(LICENSE_PLATE_TEST);
        assistant.parkVehicle("M-2");
        assistant.parkVehicle("M-3");
        assistant.parkVehicle("M-4");
        assertFalse(assistant.parkVehicle("M-5"));
    }

    @Test
    public void itShouldUpdateCapacityForOneParking() {
        final var parking = new Parking(5);
        final var assistant = new Assistant(List.of(parking));
        parking.addPropertyChangeListener(assistant);
        assistant.parkVehicle(LICENSE_PLATE_TEST);

        assertEquals(20, assistant.getCapacity(parking), 0.01);
    }

    @Test
    public void itShouldUpdateCapacityForMoreThanOneParking() {
        final var parking = new Parking(0);
        final var parkingOther = new Parking(4);
        final var assistant = new Assistant(List.of(parking, parkingOther));
        parking.addPropertyChangeListener(assistant);
        parkingOther.addPropertyChangeListener(assistant);

        assistant.parkVehicle(LICENSE_PLATE_TEST);

        assertFalse(parking.retrieveVehicle(LICENSE_PLATE_TEST));
        assertEquals(0, assistant.getCapacity(parking), 0.01);

        assertEquals(25, assistant.getCapacity(parkingOther), 0.01);
        assertTrue(parkingOther.retrieveVehicle(LICENSE_PLATE_TEST));
    }
}