package oop.measure;

public class Celsius extends Unit {

    public Celsius(final double value) {
        super(value);
    }

    @Override
    public Unit add(final Unit celsiusOther) {
        return new Celsius(super.value + celsiusOther.value);
    }

    @Override
    public double to(UnitType unitType) {
        throw new UnsupportedOperationException("Forbidden operation");
    }

    @Override
    public String toString() {
        return value + " c";
    }
}
