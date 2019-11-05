package com.example.TestCircle;
// starting code

public class Circle {
    private double x, y;
    private double radius;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle() {
        x = 0;
        y = 0;
        radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return (2.0 * Math.PI * radius);
    }

    public boolean contains(double px, double py) {
        double containsPoint = Math.pow(px - this.x, 2) + Math.pow(py - this.y, 2);
        return containsPoint <= radius;
    }

    public boolean contains(Circle c) {
        double Circle1_radius = this.radius;
        double Circle2_radius = c.radius;
        double distance = Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2);
        double total_distance = Circle2_radius + distance;
        return Circle1_radius > total_distance;
    }

    public boolean overlaps(Circle c) {
        double Circle1_radius = this.radius;
        double Circle2_radius = c.radius;
        double distance = Math.pow(c.x - this.x, 2) + Math.pow(c.y - this.y, 2);
        double total_distance = Circle2_radius + distance;
        return (Circle1_radius + Circle2_radius >= total_distance);
    }

}
