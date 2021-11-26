package oop.parking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AssistantTest {

    private static final String LICENSE_PLATE = "MAT-001";

    @Test
    public void itShouldParkVehicleInFirstParkingWithSpace() {
        final var parkingFull = new Parking(0);
        final var parkingAvailable = new Parking(2);
        final var parkingList = List.of(parkingFull, parkingAvailable);
        final var assistant = new Assistant(parkingList);
        assertTrue(assistant.parkVehicle(new Car(LICENSE_PLATE, false)));
    }

    @Test
    public void itShouldRetrieveVehicle() {
        Car car = new Car(LICENSE_PLATE, false);
        List<Parking> parkingList = new ArrayList<>();
        Parking parking = new Parking(1);
        Parking parkingOther = new Parking(10);
        parkingList.add(parking);
        parkingList.add(parkingOther);
        Assistant assistant = new Assistant(parkingList);
        assistant.parkVehicle(car);
        assertTrue(assistant.retrieveVehicle(car));
        assertFalse(assistant.retrieveVehicle(car));
    }

    @Test
    public void itShouldNotParkIfParkingUsageBiggerThan80Percent() {
        final var parking = new Parking(5);
        final var assistant = new Assistant(List.of(parking));
        parking.addPropertyChangeListener(assistant);
        assistant.parkVehicle(new Car("M-1", false));
        assistant.parkVehicle(new Car("M-2", false));
        assistant.parkVehicle(new Car("M-3", false));
        assistant.parkVehicle(new Car("M-4", false));
        assertFalse(assistant.parkVehicle(new Car("M-5", false)));
    }

    @Test
    public void itShouldUpdateCapacityForOneParking() {
        final var parking = new Parking(5);
        final var assistant = new Assistant(List.of(parking));
        parking.addPropertyChangeListener(assistant);
        assistant.parkVehicle(new Car(LICENSE_PLATE, false));

        assertEquals(20, assistant.getCapacity(parking), 0.01);
    }

    @Test
    public void itShouldUpdateCapacityForMoreThanOneParking() {
        final var parking = new Parking(0);
        final var parkingOther = new Parking(4);
        final var assistant = new Assistant(List.of(parking, parkingOther));
        Car car = new Car(LICENSE_PLATE, false);

        parking.addPropertyChangeListener(assistant);
        parkingOther.addPropertyChangeListener(assistant);

        assistant.parkVehicle(car);

        assertFalse(parking.retrieveVehicle(car));
        assertEquals(0, assistant.getCapacity(parking), 0.01);

        assertEquals(25, assistant.getCapacity(parkingOther), 0.01);
        assertTrue(parkingOther.retrieveVehicle(car));
    }
}