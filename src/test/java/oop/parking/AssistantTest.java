package oop.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.checkerframework.checker.units.qual.A;
import org.junit.Before;
import org.junit.Test;

public class AssistantTest {

    private static final String LICENSE_PLATE = "MAT-001";
    private Assistant assistant;

    @Before
    public void setUp() {
        this.assistant = new Assistant(new Parking(5));
    }

    @Test
    public void itShouldParkVehicle() {
        assertTrue(assistant.parkVehicle(LICENSE_PLATE));
        assertFalse(assistant.parkVehicle(LICENSE_PLATE));
    }

    @Test
    public void itShouldRetrieveVehicle() {
        assertTrue(assistant.parkVehicle(LICENSE_PLATE));
        assertTrue(assistant.retrieveVehicle(LICENSE_PLATE));
        assertFalse(assistant.retrieveVehicle(LICENSE_PLATE));
    }
}