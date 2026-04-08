package com.bootcampexcercise.module2;

/**
 * @author wajid
 * @Purpose to explain for loop
 */
public class ForLoopExample {

    /**
     * Main method - entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // we want perform sum of first 10 numbers starting from 1
        int sumResult = 0; // initialize sum variable
        for (int i = 1; i <= 10; i++) { // for loop repeats the action until the condition is true
            // initial, no of counts, increment/decrement
            sumResult = sumResult + i; // add current number to sum

            // conditional statements
        }
        System.out.println("Sum of first 10 numbers is " + sumResult); // print final sum
    }
}
