package obc.parkingLot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AssistantTest {

    @Test
    public void shouldParkWithAssistant(){

        Parking parking = new Parking(4);
        Assistant assistant = new Assistant(Arrays.asList(parking));
        Car myCar = new Car("abc");

        assertEquals(true,  assistant.park(myCar));
    }

    @Test
    public void shouldNotParkWithAssistant(){

        Parking parking = new Parking(0);
        Assistant assistant = new Assistant(Arrays.asList(parking));
        Car myCar = new Car("abc");

        assertEquals(false,  assistant.park(myCar));
    }

    @Test
    public void shouldParkFirstAvailableParking(){
        Parking parking1 = new Parking(0);
        Parking parking2 = new Parking(4);
        Car myCar = new Car("abc");

        Assistant assistant = new Assistant(Arrays.asList(parking1,parking2));
        assertEquals(true, assistant.park(myCar));
    }

    @Test
    public void shouldNotParkWhenNotAvailableSlots(){
        Parking parking1 = new Parking(0);
        Parking parking2 = new Parking(0);
        Car myCar = new Car("abc");

        Assistant assistant = new Assistant(Arrays.asList(parking1,parking2));
        assertEquals(false, assistant.park(myCar));
    }

    @Test
    public void shouldNotParkWhenCapacityRestrictionIsFull(){
        Parking parking = new Parking(10);
        Assistant assistant = new Assistant(Arrays.asList(parking));

        assistant.park(new Car("1"));
        assistant.park(new Car("2"));
        assistant.park(new Car("3"));
        assistant.park(new Car("4"));
        assistant.park(new Car("5"));
        assistant.park(new Car("6"));
        assistant.park(new Car("7"));
        assistant.park(new Car("8"));

        assertFalse(assistant.park(new Car("9")));

    }
    @Test
    public void shouldRetrieveCar(){
        Parking parking = new Parking(4);
        Assistant assistant = new Assistant(Arrays.asList(parking));

        String myPlate = "ABC12";
        Car myCar = new Car(myPlate);
        assistant.park(myCar);

        assertEquals(myCar, assistant.retrieve(myPlate));
    }
    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowAnExceptionWhenRetrievingNotExistingCar(){
        Parking parking = new Parking(4);
        Assistant assistant = new Assistant(Arrays.asList(parking));
        String myPlate = "abc";
        assistant.retrieve(myPlate);
    }

}
