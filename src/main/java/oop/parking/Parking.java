package oop.parking;

public class Parking {

  private int availableSpace;

  public Parking(final int availableSpace) {
    this.availableSpace = availableSpace;
  }

  public boolean add(final String licensePlate) {
    if (availableSpace <= 0) {
      return false;
    } else {
      availableSpace--;
      return true;
    }
  }

  public int getAvailableSpace() {
    return this.availableSpace;
  }

  public boolean retrieveVehicle(String licensePlate) {
    return false;
  }

  public boolean isPresent(String licensePlate) {
    return false;
  }
}
