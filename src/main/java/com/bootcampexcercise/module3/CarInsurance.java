package com.bootcampexcercise.module3;

// ============================================
// PARENT CLASS (Base Class)
// ============================================
class Car {

    // Attributes of Car
    String name;
    String color;
    int modelNo;

    // Constructor - called when a Car object is created
    Car(String name, String color, int modelNo) {
        this.name = name;       // 'this' refers to current object
        this.color = color;
        this.modelNo = modelNo;
    }

    // Method to print car details
    void printCarDetails() {
        System.out.println("Car Name  : " + name);
        System.out.println("Color     : " + color);
        System.out.println("Model No  : " + modelNo);
    }
}

// ============================================
// CHILD CLASS (Inherits from Car using 'extends')
// ============================================
class ElectricCar extends Car {

    // Extra attribute specific to ElectricCar only
    int batteryRange;

    // Constructor of child class
    // We use super() to call the parent class (Car) constructor
    ElectricCar(String name, String color, int modelNo, int batteryRange) {
        super(name, color, modelNo); // Passes values up to Car's constructor
        this.batteryRange = batteryRange;
    }

    // @Override means we are redefining the parent's method here
    @Override
    void printCarDetails() {
        super.printCarDetails(); // First calls Car's printCarDetails()
        // Then adds the extra Electric Car info below
        System.out.println("Battery Range: " + batteryRange + " km");
    }
}

