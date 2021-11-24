package oop.shape;

public class Square extends Shape {

    private static final int NUMBER_OF_SIDES = 4;
    private int side;

    public Square(final int side) {
        super(side);
    }

    @Override
    public int calculatePerimeter() {
        return NUMBER_OF_SIDES * super.getSide();
    }

    @Override
    public int calculateArea() {
        return super.getSide() * super.getSide();
    }
}
