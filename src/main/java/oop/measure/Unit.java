package oop.measure;

public abstract class Unit {

    double value;

    public Unit(final double value) {
        this.value = value;
    }

//    public abstract double to(UnitType unitType);

    public abstract Unit add(Unit unitOther);
}
