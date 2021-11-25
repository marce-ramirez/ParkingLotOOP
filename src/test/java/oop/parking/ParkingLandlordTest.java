package oop.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingLandlordTest {

    @Test
    public void itShouldReceiveNotificationWhenParkingUsedMoreThan75Percent() {
        Parking parking = new Parking(10);
        ParkingLandlord parkingLandlord = new ParkingLandlord();

        parking.addPropertyChangeListener(parkingLandlord);
        parking.add("M1");
        parking.add("M2");
        parking.add("M3");
        parking.add("M4");
        parking.add("M5");
        parking.add("M6");
        parking.add("M7");
        parking.add("M8");

        assertEquals(0.8, parkingLandlord.getOcupacyPercentage(), 0.01);
    }
}