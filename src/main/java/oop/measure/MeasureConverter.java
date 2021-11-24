package oop.measure;

public class MeasureConverter {

    private static final double FEET_IN_METERS = 0.3048;
    private static final double INCHES_IN_YARDS = 0.0278;
    private static final int METER_IN_CENTIMETERS = 100;
    private static final double GALLON_IN_LITERS = 3.7854;

    private static final String FEET = "FEET";
    private static final String METERS = "METERS";
    private static final String INCHES = "INCHES";
    private static final String YARDS = "YARDS";
    private static final String GALLONS = "GALLONS";
    private static final String LITERS = "LITERS";

    public static double convert(final String from, final String to, final double value) {
        if (INCHES.equals(to)) {
            return value / INCHES_IN_YARDS;
        } else if (GALLONS.equals(from) && LITERS.equals(to)) {
            return value * GALLON_IN_LITERS;
        } else if (LITERS.equals(from) && GALLONS.equals(to)) {
            return value / GALLON_IN_LITERS;
        } else if (YARDS.equals(to)) {
            return value * INCHES_IN_YARDS;
        } else {
            return METERS == from ? value * METER_IN_CENTIMETERS : value / METER_IN_CENTIMETERS;
        }
    }
}

