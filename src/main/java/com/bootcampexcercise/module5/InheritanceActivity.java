package com.bootcampexcercise.module5;

// InheritanceActivity.java
// ============================================
// PARENT CLASS - Person_I
// No 'public' keyword since only one
// ============================================

class Person_I {

    // Attributes
    private String name;
    private int age;

    // Default Constructor
    Person_I() {
        // Attributes set via setters
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Print Person details
    public void printInfo() {
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
    }
}

// ============================================
// CHILD CLASS - Employee_I
// Inherits from Person_I using 'extends'
// Note: No 'public' keyword
// ============================================

class Employee_I extends Person_I {

    // Extra attributes specific to Employee
    private String title;
    private double salary;

    // Default Constructor
    Employee_I() {
        super(); // Calls Person_I constructor
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }

    // Overrides Person_I printInfo()
    // Prints name & age from parent + title & salary
    @Override
    public void printInfo() {
        super.printInfo();  // Calls Person_I's printInfo() first
        System.out.println("Title  : " + title);
        System.out.println("Salary : " + salary);
    }
}

// ============================================
// MAIN CLASS - InheritanceActivity
// This is 'public' and MUST match filename
// File must be saved as InheritanceActivity.java
// ============================================

public class InheritanceActivity {

    public static void main(String[] args) {

        // --- Person Object ---
        Person_I myPerson = new Person_I();
        myPerson.setName("Sarah Johnson");
        myPerson.setAge(21);

        System.out.println("--- Person Info ---");
        myPerson.printInfo();
        System.out.println("-----------------------------");

        // --- Employee Object ---
        Employee_I myEmployee = new Employee_I();
        myEmployee.setName("Shawn Cun");
        myEmployee.setAge(32);
        myEmployee.setTitle("Developer");
        myEmployee.setSalary(70000.00);

        System.out.println("--- Employee Info ---");
        myEmployee.printInfo();
        System.out.println("-----------------------------");
    }
}