package obc.parkingLot;

import java.util.ArrayList;
import java.util.List;

public class Owner implements Observer{
    public boolean hasBeenNotified = false;
    private final List<Parking> parkings = new ArrayList<Parking>();
    private Assistant assistant;

    public void openParking(int totalPlaces) {
        Parking newParking = new Parking(totalPlaces);
        newParking.addObserver(this);
        parkings.add(newParking);
    }

    public Assistant hireAssistant(){
        assistant = new Assistant(parkings);
        return assistant;
    }


    @Override
    public void update(int totalPlaces, int usedPlaces) {
        double percentageUsed = usedPlaces * 100 / totalPlaces;
        if (percentageUsed >= 75){
            hasBeenNotified = true;
        }

    }
}
