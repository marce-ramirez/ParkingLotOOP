package obc.parkingLot;

public interface Observer {
    void update(int totalPlaces, int usedPlaces);
}