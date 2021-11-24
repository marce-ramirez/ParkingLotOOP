package oop.shape;

public abstract class Shape {

    private int side;

    public Shape(final int side) {
        this.side = side;
    }

    public abstract int calculatePerimeter();
    public abstract int calculateArea();

    public int getSide() {
        return side;
    }
}
