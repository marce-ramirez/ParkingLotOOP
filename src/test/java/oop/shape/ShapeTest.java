package oop.shape;

import org.junit.Test;

public class ShapeTest {

    private Shape shape;
    private Shape shapeOther;

    @Test
    public void itShouldAllowPolymorphism() {
        this.shape = new Square(5);
        this.shapeOther = new Rectangle(10, 20);
    }
}