package oop.parking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssistantTest {
  @Test
  public void itShouldParkVehicle() {
    Parking parking = new Parking(5);
    Assistant assistant = new Assistant(parking);
    assertTrue(assistant.parkVehicle("MAT-001"));
    assertFalse(assistant.parkVehicle("MAT-001"));
  }
}