package oop.measure;

public class Inches extends Unit {

    private static final double INCHES_IN_YARDS = 0.0278;

    public Inches(double value) {
        super(value);
    }

    @Override
    public double to(UnitType unitType) {
        return value * INCHES_IN_YARDS;
    }

    @Override
    public Unit add(Unit unitOther) {
        throw new UnsupportedOperationException("Forbidden operation");
    }
}
