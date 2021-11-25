package obc.parkingLot;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void shouldNOTFindAFreeLot(){

        Parking parking = new Parking(0);

        assertEquals(false, parking.canPark());

    }

    @Test
    public void shouldFindAFreeLot(){

        Parking parking = new Parking(5);

        assertEquals(true, parking.canPark());

    }

    @Test
    public void shouldParkACar(){

        Parking parking = new Parking(4);
        Car myCar = new Car("ABC12");

        assertEquals(true, parking.park(myCar));
        assertEquals(3, parking.getAvailableSpots());


    }

    @Test
    public void shouldRetrieveACar(){

        Parking parking = new Parking(4);

        String myPlate = "ABC12";
        Car myCar = new Car(myPlate);
        parking.park(myCar);

        assertEquals(myCar, parking.retrieveCar(myPlate));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowAnExceptionWhenRetrievingNotExistingCar(){

        Parking parking = new Parking(4);
        String plate = "123";
        String myPlate = "abc";

        parking.park(new Car(plate));
        parking.retrieveCar(myPlate);
    }

    @Test
    public void shouldReturnFalseWhenCapacityIsMoreThan80Percent(){
        Parking parking = new Parking(10);

        parking.park(new Car("CAB-120"));
        parking.park(new Car("CAB-121"));
        parking.park(new Car("CAB-122"));
        parking.park(new Car("CAB-123"));
        parking.park(new Car("CAB-124"));
        parking.park(new Car("CAB-125"));
        parking.park(new Car("CAB-126"));
        assertTrue(parking.park(new Car("CAB-127")));

        assertTrue(parking.canPark());
        assertFalse(parking.canPark(.8));
    }
}
