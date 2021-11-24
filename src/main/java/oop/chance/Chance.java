package oop.chance;

import java.util.Objects;

public class Chance {

    public static final int SURE_EVENT_PROBABILITY = 1;

    private double value;

    public Chance(double value) {
        this.value = value;
    }

    public static double calculateChanceOfEvent(final int numberOfEvents) {
        return roundDown(1.0 / numberOfEvents);
    }

    public static double calculateChanceOfEventNotHappening(final int numberOfEvents) {
        return SURE_EVENT_PROBABILITY - calculateChanceOfEvent(numberOfEvents);
    }

    public Chance calculateProduct(final Chance chanceOther) {
        return new Chance(roundDown(this.getValue() * chanceOther.getValue()));
    }

    public Chance calculateLogicalOr(final Chance chanceOther) {
        return new Chance(this.getValue() + chanceOther.getValue() - this.calculateProduct(chanceOther).getValue());
    }

    private static double roundDown(final double value) {
        return Math.floor(value * 100) / 100.0d;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return Double.compare(chance.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
