package obc.parkingLot;

import java.util.List;
import java.util.Optional;

public class Assistant {

    private List<Parking> parkings;
    public Assistant(List<Parking> parkings) {
        this.parkings = parkings;
    }

    public boolean park(Car myCar) {
        Optional<Parking> parking = parkings.stream().filter(Parking::canPark).findFirst();

        return parking.isPresent() && parking.get().park(myCar);
    }
}
