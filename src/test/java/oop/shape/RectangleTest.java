package oop.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    private Shape rectangle = new Rectangle(10,20);
    private Shape rectangleOther = new Rectangle(20,5);

    @Test
    public void itShouldCalculatePerimeter() {
        assertEquals(60, rectangle.calculatePerimeter());
        assertEquals(50, rectangleOther.calculatePerimeter());
    }

    @Test
    public void itShouldCalculateArea() {
        assertEquals(200, rectangle.calculateArea());
        assertEquals(100, rectangleOther.calculateArea());
    }
}