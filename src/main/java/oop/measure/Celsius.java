package oop.measure;

public class Celsius extends Unit implements Temperature {

    public Celsius(final double value) {
        super(value);
    }

    @Override
    public Unit add(final Unit celsiusOther) {
        return new Celsius(super.value + celsiusOther.value);
    }

    @Override
    public void increase(int amount) {

    }

    @Override
    public Temperature to(UnitType unitType) {
        return null;
    }

//    @Override
//    public Temperature to(UnitType unitType) {
//        throw new UnsupportedOperationException("Forbidden operation");
//    }

    @Override
    public String toString() {
        return value + " c";
    }
}
