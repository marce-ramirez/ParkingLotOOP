package obc.parkingLot;

import com.google.common.base.Objects;

public class Car {
    String plate;

    public Car(String plate) {
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equal(plate, car.plate);
    }

}
