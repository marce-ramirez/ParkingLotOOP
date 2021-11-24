package oop.measure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MeasureConverterTest {

    private static final double DELTA_ERROR_MARGIN = 0.01;
    private static final String CENTIMETERS = "CENTIMETERS";
    private static final String METERS = "METERS";
    private static final String FEET = "FEET";
    private static final String YARDS = "YARDS";
    private static final String INCHES = "INCHES";
    private static final String GALLONS = "GALLONS";
    private static final String LITERS = "LITERS";

    @Test
    public void itShouldAllowConversionBetweenMetersAndFeet() {
        assertMetersCanBeConvertedToFeet();
        assertFeetCanBeConvertedToMeters();
    }

    private void assertFeetCanBeConvertedToMeters() {
        final Unit feet = new Feet(3.0);
        assertEquals(0.9144, feet.to(UnitType.METER), DELTA_ERROR_MARGIN);
        final Unit feetOther = new Feet(6.3);
        assertEquals(1.92024, feetOther.to(UnitType.METER), DELTA_ERROR_MARGIN);
    }

    private void assertMetersCanBeConvertedToFeet() {
        final Unit meters = new Meters(2.0);
        assertEquals(6.56168, meters.to(UnitType.FEET), DELTA_ERROR_MARGIN);
        final Unit metersOther = new Meters(1.5);
        assertEquals(4.92126, metersOther.to(UnitType.FEET), DELTA_ERROR_MARGIN);
    }
//interfaces distintas
    @Test
    public void itShouldAllowSumBetweenCelsius() {
        final Unit celsius = new Celsius(20);
        assertEquals(new Celsius(35.5).toString(), celsius.add(new Celsius(15.5)).toString());

        final Unit celsiusOther = new Celsius(12);
        assertEquals(new Celsius(18).toString(), celsiusOther.add(new Celsius(6)).toString());
    }

    @Test
    public void itShouldAllowConversionBetweenInchesAndYards() {
        final Unit inches = new Inches(7.0);
        assertEquals(0.194444, inches.to(UnitType.YARD), DELTA_ERROR_MARGIN);

        final Unit inchesOther = new Inches(10.2);
        assertEquals(0.2833333, inchesOther.to(UnitType.YARD), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertInchesToYards(){
        assertEquals(0.0278, MeasureConverter.convert(INCHES, YARDS,1), DELTA_ERROR_MARGIN);
        assertEquals(0.1389, MeasureConverter.convert(INCHES, YARDS,5), DELTA_ERROR_MARGIN);
        assertEquals(0.08, MeasureConverter.convert(INCHES, YARDS,3.2), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertYardsToInches(){
        assertEquals(1, MeasureConverter.convert(YARDS, INCHES,0.0278), DELTA_ERROR_MARGIN);
        assertEquals(5, MeasureConverter.convert(YARDS, INCHES,0.1389), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertMetersToCentimeters() {
        assertEquals(200, MeasureConverter.convert(METERS, CENTIMETERS, 2), DELTA_ERROR_MARGIN);
        assertEquals(100, MeasureConverter.convert(METERS, CENTIMETERS, 1), DELTA_ERROR_MARGIN);
        assertEquals(150, MeasureConverter.convert(METERS, CENTIMETERS, 1.5), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertCentimetersToMeters() {
        assertEquals(2, MeasureConverter.convert(CENTIMETERS, METERS, 200), DELTA_ERROR_MARGIN);
        assertEquals(1, MeasureConverter.convert(CENTIMETERS, METERS, 100), DELTA_ERROR_MARGIN);
        assertEquals(0.015, MeasureConverter.convert(CENTIMETERS, METERS, 1.5), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertGallonsToLiters() {
        assertEquals(3.7854, MeasureConverter.convert(GALLONS, LITERS, 1), DELTA_ERROR_MARGIN);
        assertEquals(15.1416, MeasureConverter.convert(GALLONS, LITERS, 4), DELTA_ERROR_MARGIN);
    }

    @Test
    public void itShouldConvertLitersToGallons() {
        assertEquals(1, MeasureConverter.convert(LITERS, GALLONS, 3.7854), DELTA_ERROR_MARGIN);
        assertEquals(4, MeasureConverter.convert(LITERS, GALLONS, 15.1416), DELTA_ERROR_MARGIN);
    }

    //“I want to compare celsius with fahrenheit, like 80 fh = 26.6667 c”
    //(0°C × 9/5) + 32 = 32°F
}

