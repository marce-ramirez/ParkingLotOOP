package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ParkingLandlord implements PropertyChangeListener {

    private double ocupacyPercentage;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("There are more vehicles in the parking!!!");
        this.setOcupacyPercentage((double) evt.getNewValue());
        System.out.println("ocupacyPercentage: " + this.getOcupacyPercentage());
    }

    public double getOcupacyPercentage() {
        return ocupacyPercentage;
    }

    public void setOcupacyPercentage(double ocupacyPercentage) {
        this.ocupacyPercentage = ocupacyPercentage;
    }
}
