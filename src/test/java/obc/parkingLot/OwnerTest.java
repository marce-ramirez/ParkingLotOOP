package obc.parkingLot;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OwnerTest{

    @Test
    public void AssistantParkingSizeShouldIncreaseAsOwnerAddsParkings(){
        Owner owner = new Owner();
        Assistant assistant = owner.hireAssistant();

        owner.openParking(1);
        owner.openParking(2);
        owner.openParking(3);

        Assistant expectedAssistant = new Assistant(Arrays.asList(
                new Parking(1),
                new Parking(2),
                new Parking(3)
        ));

        assertEquals(assistant, expectedAssistant);
    }

    @Test
    public void shouldBeNotifiedWhenMaxCapacityIsHigherThank75Percent(){
        Owner newOwner = new Owner();
        newOwner.openParking(4);
        Assistant newAssistant = newOwner.hireAssistant();

        newAssistant.park(new Car("CAB-121"));
        newAssistant.park(new Car("CAB-122"));
        newAssistant.park(new Car("CAB-123"));

        assertEquals(newOwner.notificationRecieved, "Max capacity reached");

    }
    @Test
    public void shouldCloseParkingLotWhenHasLessThan20Percent(){
        Owner newOwner = new Owner();
        newOwner.openParking(4);
        Assistant newAssistant = newOwner.hireAssistant();

        newAssistant.park(new Car("CAB-121"));
        newAssistant.retrieve("CAB-121");

        assertEquals(newOwner.notificationRecieved, "Close parking");

    }

}