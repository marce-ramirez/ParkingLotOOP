package obc.parkingLot;

import com.google.common.base.Objects;

import java.util.HashSet;
import java.util.Set;

public class Parking {

    private int spots;
    private static final double MAX_CAPACITY_ALLOWED = 0.8;
    private Set<String> cars;

    public Parking(int spots) {
        this.spots = spots;
        this.cars = new HashSet<>();
    }

    public boolean canPark() {
        return cars.size() < spots * MAX_CAPACITY_ALLOWED;
    }

    public boolean park(Car car) {
        if (!cars.contains(car.plate) && canPark()) {
            cars.add(car.plate);
            return true;
        }
        return false;
    }

    public Car retrieveCar(String myPlate) {
        if (cars.contains(myPlate)) {
            cars.remove(myPlate);
            return new Car(myPlate);
        }
        throw new UnsupportedOperationException();
    }

    public int getAvailableSpots() {
        return spots - cars.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parking parking = (Parking) o;
        return spots == parking.spots && Objects.equal(cars, parking.cars);
    }
}
