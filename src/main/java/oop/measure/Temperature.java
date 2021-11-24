package oop.measure;

public interface Temperature {
    void increase(int amount);
    Temperature to(UnitType unitType);
}
