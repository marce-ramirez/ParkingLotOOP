package obc.parkingLot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

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

}
