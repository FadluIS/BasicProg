package ch8;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.format("Drawing a Circle of radius %d!", radius);
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * Math.pow(radius, 2);
    }
}
