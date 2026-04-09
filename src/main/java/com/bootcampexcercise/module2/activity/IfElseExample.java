package com.bootcampexcercise.module2.activity;

/**
 * Class: IfElseExample
 * Activity 4 of Module 2 - Find Largest Number using If-Else
 * @author wajid
 */
public class IfElseExample {

    /**
     * Main method - entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int firstNumber = 10;
        int secondNumber = 88;
        int thirdNumber = 2;

        if (firstNumber >= secondNumber && firstNumber >= thirdNumber) {
            System.out.println("Largest number is: " + firstNumber);
        } else if (secondNumber >= firstNumber && secondNumber >= thirdNumber) {
            System.out.println("Largest number is: " + secondNumber);
        } else {
            System.out.println("Largest number is: " + thirdNumber);
        }
    }
}
