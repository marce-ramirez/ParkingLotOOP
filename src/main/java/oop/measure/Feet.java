package oop.measure;

public class Feet extends Unit {

    private static final double FEET_IN_METERS = 0.3048;

    public Feet(double value) {
        super(value);
    }

    @Override
    public double to(UnitType unitType) {
        return super.value * FEET_IN_METERS;
    }

    @Override
    public Unit add(Unit unitOther) {
        throw new UnsupportedOperationException("Forbidden operation");
    }
}
