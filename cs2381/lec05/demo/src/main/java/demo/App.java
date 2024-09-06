package demo;

import java.util.List;

public class App {

    public static void main1(String[] args) {
        double xx = 7.0;
        System.out.printf("the area of a square of width %.02f is %.02f\n", xx, new Square(xx).area());
        var myCircle = new Circle(xx);
        System.out.printf("the area of a circle of radius %.02f is %.02f\n", xx, myCircle.area());
    }

    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle(10.0),
            new Rectangle(4.7, 10.0), 
            new Square(10.0));
        for (Shape shape : shapes) {
            System.out.printf("area = %.02f\n", shape.area());
        }
    }

    /*
    // Calculate the area of a square.
    static double squareArea(double width) {
        return width * width;
    }

    // Calculate the area of a circle.
    static double circleArea(double radius) {
        return Math.PI * Math.pow(radius, 2.0);
    }
    */
}

interface Shape {
    double area();
}

//class Shape1 {
//    double area() {
//        throw new Error("not implemented");
//    }
//}

//class Square1 extends Shape1 {
//    ...
//}

// A class can extend one superclass.
// A class can implement many interfaces.

class Square implements Shape {
    double width;

    Square(double w0) {
        this.width = w0;
    }

    @Override
    public double area() {
        return width * width;
    }
}

class Circle implements Shape {
    double radius;

    Circle(double r0) {
        this.radius = r0;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2.0);
    }
}

record Rectangle(double width, double height) implements Shape {
    @Override
    public double area() {
        return width * height;
    }
}

/**
 * Represents a triangle.
 * 
 * @author Nat
 * @param  base   The base of the triangle
 * @param  height The height of the triangle 
 */
record Triangle(double base, double height) implements Shape {

    /**
     * Calculate area.
     * 
     * @return      The area in square units.
     */
    @Override
    public double area() {
        return 0.5 * base * height;
    }

    // TODO: tests
    // TODO: additional tests
}