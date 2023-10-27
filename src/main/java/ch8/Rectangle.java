package ch8;

public class Rectangle extends Figure {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.width = width;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.format("Drawing a Rectangle of width %d and length %d!", width, length);
    }

    @Override
    public double getArea() {
        return length * width;
    }
}
