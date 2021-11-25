package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ParkingLandlord implements PropertyChangeListener {

    private boolean isPurchaseNeeded;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("There are more vehicles in the parking!!!");
        final var parking = (Parking) evt.getSource();
        evaluateStatus(parking);
        //this.setOcupacyPercentage((double) evt.getNewValue());
    }

    private void evaluateStatus(Parking parking) {
        if(parking.isOccupiedAt80Percentage()) {
            System.out.println("This parking is nearly full, I need to buy a new one!");
            isPurchaseNeeded=true;
        }
    }

    public boolean isPurchaseNeeded() {
        return isPurchaseNeeded;
    }

}
