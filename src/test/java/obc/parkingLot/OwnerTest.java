package obc.parkingLot;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OwnerTest{

    @Test
    public void shouldBeNotifiedWhenMaxCapacityIsHigherThank75Percent(){
        Owner newOwner = new Owner();
        Parking newParking = newOwner.openParking(4);
        Assistant newAssistant = newOwner.hireAssitant(newParking, restriction);

        newParking.park(new Car("CAB-121"));
        newParking.park(new Car("CAB-122"));
        newParking.park(new Car("CAB-123"));

        assertTrue(parking.park(new Car("CAB-127")));

        // We need to refactor in order to be the Assistant the one th PARK

        // owner creates the asssistant
        // owner creates parking
        // owner has a list of parking + assistant (YAGNI)

        // max capacity, boolean

    }

}