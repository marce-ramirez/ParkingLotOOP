package oop.measure;

public class Meters extends Unit {

    private static final double FEET_IN_METERS = 0.3048;

    public Meters(double value) {
        super(value);
    }

    @Override
    public double to(UnitType unitType) {
        return super.value / FEET_IN_METERS;
    }

    @Override
    public Unit add(Unit unitOther) {
        throw new UnsupportedOperationException("Forbidden operation");
    }
}