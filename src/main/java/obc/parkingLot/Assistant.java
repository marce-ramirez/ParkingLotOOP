package obc.parkingLot;

import java.util.*;

public class Assistant {

    private List<Parking> parkings;
    public Assistant(List<Parking> parkings) {
        this.parkings = parkings;
    }
    private static final double CAPACITY_RESTRICTION = 0.8;

    public boolean park(Car myCar) {
        Optional<Parking> parking = parkings.stream().filter(p -> p.canPark(CAPACITY_RESTRICTION)).findFirst();

        return parking.isPresent() && parking.get().park(myCar);
    }

    public Car retrieve(String plate) {
        Optional<Parking> parking = parkings.stream().filter(p -> p.containsCar(plate)).findFirst();

        if (parking.isPresent()){
            return parking.get().retrieveCar(plate);
        }

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assistant assistant = (Assistant) o;
        return Objects.equals(parkings, assistant.parkings);
    }

}
