package com.bootcampexcercise.module3;

import java.util.Date;

// ============================================
// MAIN CLASS - Entry point of the program
// Must be saved as Main.java because it is public
// ============================================
public class Main {

    public static void main(String[] args) {

        // ----------------------------------------
        // PART 1: DateActivity - Print today's date
        // ----------------------------------------
        Date d = new Date(); // Creates a Date object with current date & time
        System.out.println("Today's Date: " + d);
        System.out.println("-----------------------------------");

        // ----------------------------------------
        // PART 2: CarInstance - Print 1 (Only car name)
        // ----------------------------------------
        Car car = new Car("Toyota", "Red", 2021); // Creating a Car object
        System.out.println("Print 1 - Car Name: " + car.name); // Accessing name attribute
        System.out.println("-----------------------------------");

        // ----------------------------------------
        // PART 3: CarInstance - Print 2 (All 3 attributes)
        // ----------------------------------------
        System.out.println("Print 2 - Full Car Details:");
        car.printCarDetails(); // Calling the method to print all details
        System.out.println("-----------------------------------");

        // ----------------------------------------
        // PART 4: Inheritance - ElectricCar extends Car
        // ElectricCar gets all Car attributes + batteryRange
        // ----------------------------------------
        ElectricCar eCar = new ElectricCar("Tesla", "White", 2023, 500);
        System.out.println("Electric Car Details (Using Inheritance):");
        eCar.printCarDetails(); // Calls overridden method in ElectricCar
        System.out.println("-----------------------------------");
    }
}