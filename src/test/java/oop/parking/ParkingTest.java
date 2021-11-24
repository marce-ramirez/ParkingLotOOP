package oop.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingTest {

  @Test
  public void itShouldNotAllowVehiclesIfNoAvailableSpace() {
    assertFalse(new Parking(0).add("MAT-001"));
  }

  @Test
  public void itShouldAllowVehiclesIfAvailableSpace() {
    final var parking = new Parking(5);
    assertEquals(5, parking.getAvailableSpace());
    assertTrue(parking.add("MAT-001"));
    assertEquals(4, parking.getAvailableSpace());
  }

  @Test
  public void itShouldAllowCarRetrieval() {
      final var parking = new Parking(5);
      assertFalse(parking.retrieveVehicle("MAT-001"));
      assertTrue(parking.add("MAT-001"));
      assertTrue(parking.isPresent("MAT-001"));
      assertTrue(parking.retrieveVehicle("MAT-001"));
      assertFalse(parking.isPresent("MAT-001"));
  }
}