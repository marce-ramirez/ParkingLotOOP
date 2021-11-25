package obc.parkingLot;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parking {

    private int spots;
    private Set<String> cars;
    private List<Observer> observers = new ArrayList<Observer>();

    public Parking(int spots) {
        this.spots = spots;
        this.cars = new HashSet<>();
    }

    public boolean canPark() {
        return cars.size() < spots;
    }

    public boolean canPark(double restriction) {
        return cars.size() < spots * restriction;
    }

    public boolean park(Car car) {
        if (!cars.contains(car.plate) && canPark()) {
            cars.add(car.plate);
            notifyObservers();
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

    private void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(spots, cars.size());
        }
    }
    public void addObserver(Observer observer){
        observers.add(observer);
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
