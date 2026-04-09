// AbstractActivity.java
// Demonstrates Abstract Classes using Shape, Rectangle and Circle

package com.bootcampexcercise.module5;

// ============================================
// ABSTRACT CLASS - Shape
// Abstract class cannot be instantiated directly
// It acts as a TEMPLATE for Rectangle and Circle
// ============================================

abstract class Shape {

    // Attribute - stores color of the shape
    public String color;

    // Default Constructor
    public Shape() {
        // Attributes set via setters
    }

    // -----------------------------------------------
    // ABSTRACT METHODS
    // No body/implementation here - just declaration
    // Every child class MUST implement these methods
    // -----------------------------------------------

    public abstract double calculateArea();          // Child must define how to calculate area
    public abstract double calculatePerimeter();     // Child must define how to calculate perimeter

    // Setter - sets the color of the shape
    public void setColor(String c) {
        color = c;
    }

    // Getter - returns the color of the shape
    public String getColor() {
        return color;
    }
}

// ============================================
// CHILD CLASS - Rectangle
// Extends Shape and implements both abstract methods
// Formula:
//   Area      = length * width
//   Perimeter = 2 * (length + width)
// ============================================

class Rectangle extends Shape {

    // Attributes specific to Rectangle
    private double length;
    private double width;

    // Constructor - sets length and width
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Setters
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Implementing abstract method from Shape
    // Area of Rectangle = length * width
    @Override
    public double calculateArea() {
        return length * width;
    }

    // Implementing abstract method from Shape
    // Perimeter of Rectangle = 2 * (length + width)
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// ============================================
// CHILD CLASS - Circle
// Extends Shape and implements both abstract methods
// Formula:
//   Area      = π * radius * radius
//   Perimeter = 2 * π * radius (Circumference)
// ============================================

class Circle extends Shape {

    // Attribute specific to Circle
    private double radius;

    // Constructor - sets radius
    Circle(double radius) {
        this.radius = radius;
    }

    // Setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Implementing abstract method from Shape
    // Area of Circle = π * radius²
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementing abstract method from Shape
    // Perimeter (Circumference) of Circle = 2 * π * radius
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// ============================================
// MAIN CLASS - AbstractActivity
// This is 'public' and MUST match filename
// File must be saved as AbstractActivity.java
// ============================================

public class AbstractActivity {

    public static void main(String[] args) {

        // ----------------------------------------
        // RECTANGLE OBJECT
        // Length = 10, Width = 5
        // ----------------------------------------

        Rectangle rectangle = new Rectangle(10, 5);

        // Set and print color of rectangle
        rectangle.setColor("Blue");
        System.out.println("--- Rectangle Info ---");
        System.out.println("Color     : " + rectangle.getColor());

        // Print area of rectangle
        System.out.println("Area      : " + rectangle.calculateArea());

        // Print perimeter of rectangle
        System.out.println("Perimeter : " + rectangle.calculatePerimeter());

        System.out.println("-----------------------------");

        // ----------------------------------------
        // CIRCLE OBJECT
        // Radius = 7
        // ----------------------------------------

        Circle circle = new Circle(7);

        // Set and print color of circle
        circle.setColor("Red");
        System.out.println("--- Circle Info ---");
        System.out.println("Color     : " + circle.getColor());

        // Print area of circle
        System.out.printf("Area      : %.2f%n", circle.calculateArea());

        // Print perimeter (circumference) of circle
        System.out.printf("Perimeter : %.2f%n", circle.calculatePerimeter());

        System.out.println("-----------------------------");
    }
}