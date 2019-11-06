package com.example.Question1;

public class Square extends GeometricObject {
    double x, y, sideLength;

    public boolean contains(double x, double y) {
        double leftPointX = this.x - (sideLength / 2);
        double leftPointY = this.y - (sideLength / 2);
        double rightPointX = this.x + (sideLength / 2);
        double rightPointY = this.y + (sideLength / 2);
        if (x > leftPointX && x < rightPointX && y > leftPointY && y < rightPointY) {
            return true;
        }
        return false;
    }

    public boolean contains(Square inSquare){
        double leftPointX = this.x - (sideLength/2);
        double leftPointY = this.y - (sideLength/2);
        double rightPointX = this.x + (sideLength/2);
        double rightPointY = this.y + (sideLength/2);

        double inLeftPointX = inSquare.x - (inSquare.sideLength/2);
        double inLeftPointY = inSquare.y - (inSquare.sideLength/2);
        double inRightPointX = inSquare.x + (inSquare.sideLength/2);
        double inRightPointY = inSquare.y + (inSquare.sideLength/2);

        if (inLeftPointX > leftPointX && inLeftPointY > leftPointY && inRightPointX < rightPointX && inRightPointY < rightPointY){
            return true;
        }
        return false;
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return sideLength*4;
    }

    Square() {
        this.x = 0;
        this.y = 0;
        this.sideLength = 1;
    }

    Square(double x, double y, double sideLength) {
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
    }
}
