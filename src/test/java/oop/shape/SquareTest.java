package oop.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {

    private Shape shape = new Square(5);
    private Shape shapeOther = new Square(10);

    @Test
    public void itShouldCalculatePerimeter() {
        assertEquals(20, shape.calculatePerimeter());
        assertEquals(40, shapeOther.calculatePerimeter());
    }

    @Test
    public void itShouldCalculateArea() {
        assertEquals(25, shape.calculateArea());
        assertEquals(100, shapeOther.calculateArea());
    }
}