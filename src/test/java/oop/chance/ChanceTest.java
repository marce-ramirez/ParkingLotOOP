package oop.chance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChanceTest {

    private Chance chanceOne = new Chance(0.1);
    private Chance chanceTwo = new Chance(0.2);

    @Test
    public void itShouldCalculateChanceForSixFaces() {
        assertEquals(0.16,
                Chance.calculateChanceOfEvent(6), 0.00);
    }

    @Test
    public void itShouldCalculateChanceForTenFaces() {
        assertEquals(0.1,
                Chance.calculateChanceOfEvent(10), 0.00);
    }

    @Test
    public void itShouldCalculateChanceOfEventNotHappeningForSixFaces() {
        assertEquals(0.84,
                Chance.calculateChanceOfEventNotHappening(6), 0.00);
    }

    @Test
    public void itShouldCalculateChanceOfEventNotHappeningForTenFaces() {
        assertEquals(0.9,
                Chance.calculateChanceOfEventNotHappening(10), 0.00);
    }

    @Test
    public void itShouldCalculateProductOfTwoChances() {
        final var expectedChance = new Chance(0.02);
        assertTrue(chanceOne.calculateProduct(chanceTwo).equals(expectedChance));
    }

    @Test
    public void itShouldCalculateLogicalOrOfTwoChances() {
        final var expectedChance = new Chance(0.28);
        assertTrue(chanceOne.calculateLogicalOr(chanceTwo).equals(expectedChance));
    }
}
