package obc.parkingLot;

import java.util.List;
import java.util.Optional;

public class Assistant {

    private List<Parking> parkings;
    public Assistant(List<Parking> parkings) {
        this.parkings = parkings;
    }
    private static double CAPACITY_RESTRICTION = 0.8;

    public boolean park(Car myCar) {
        Optional<Parking> parking = parkings.stream().filter(p -> p.canPark(CAPACITY_RESTRICTION)).findFirst();

        return parking.isPresent() && parking.get().park(myCar);
    }
}
