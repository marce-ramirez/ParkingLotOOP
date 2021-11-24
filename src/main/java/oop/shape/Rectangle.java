package oop.shape;

public class Rectangle extends Shape {

    private int length;
    private int width;

    public Rectangle(final int length, final int width) {
        super(length);
        this.width = width;
    }

    @Override
    public int calculatePerimeter() {
        return 2 * (super.getSide() + width);
    }

    @Override
    public int calculateArea() {
        return super.getSide() * width;
    }
}
