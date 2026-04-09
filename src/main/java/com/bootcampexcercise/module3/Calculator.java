package com.bootcampexcercise.module3;

// Calculator.java
// Logic class that performs basic arithmetic operations
/**
 * @author wajid
 * Calculator class that handles basic arithmetic operations
 * This is the LOGIC class called by CalculatorClient
 */
public class Calculator {

    // ============================================
    // CONSTANTS
    // public static final = can be accessed without creating object
    // e.g. Calculator.CALC_TYPE_BASIC
    // ============================================

    public static final String CALC_TYPE_BASIC = "Basic";       // Basic calculator type
    public static final String CALC_TYPE_SCIENTIFIC = "Scientific"; // Scientific calculator type (for future use)

    // ============================================
    // ATTRIBUTE
    // Stores which type of calculator this is
    // ============================================

    private String calculatorType; // Stores the type of calculator (Basic/Scientific)

    // ============================================
    // CONSTRUCTOR
    // Called when Calculator object is created
    // e.g. new Calculator(Calculator.CALC_TYPE_BASIC)
    // ============================================

    public Calculator(String calculatorType) {
        this.calculatorType = calculatorType; // Set the calculator type
    }

    // ============================================
    // GETTER
    // Returns the calculator type
    // Used in: normalCalc.getCalculatorType()
    // ============================================

    public String getCalculatorType() {
        return calculatorType; // Returns "Basic" or "Scientific"
    }

    // ============================================
    // ADD METHOD
    // Takes two integers and returns their sum
    // e.g. normalCalc.add(4, 5) returns 9
    // ============================================

    public int add(int a, int b) {
        return a + b; // Simply adds two numbers
    }

    // ============================================
    // MULTIPLY METHOD
    // Takes an array of integers and multiplies them all
    // e.g. normalCalc.multiply({2,3,4}) returns 24
    // ============================================

    public int multiply(int[] numbers) {
        int result = 1; // Start with 1 (neutral for multiplication)

        // Loop through each number in the array and multiply
        for (int num : numbers) {
            result = result * num;
        }

        return result; // Returns final multiplied value
    }

    // ============================================
    // DIVIDE METHOD
    // Takes two integers and returns their division
    // e.g. normalCalc.divide(10, 2) returns 5
    // ============================================

    public int divide(int a, int b) {

        // Safety check: Cannot divide by zero
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }

        return a / b; // Returns division result
    }

    // ============================================
    // SUBTRACT METHOD
    // Takes two integers and returns their difference
    // e.g. normalCalc.subtract(10, 2) returns 8
    // ============================================

    public int subtract(int a, int b) {
        return a - b; // Subtracts b from a
    }

}