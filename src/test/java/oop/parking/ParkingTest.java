package oop.parking;

import org.junit.Test;

public class ParkingTest {

  @Test(expected = UnsupportedOperationException.class)
  public void itShouldNotAllowVehiclesWhenFull() {
    Parking parking = new Parking(0);
    parking.add();
  }
}