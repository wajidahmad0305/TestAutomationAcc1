package com.bootcampexcercise.module2.activity;

/**
 * Class: NumToWords
 * Activity 4 of Module 2 - Convert Numbers to Words using Switch
 * @author wajid
 */
public class NumToWords {

    /**
     * Main method - calls logic method with 3 numbers
     * @param args command line arguments
     */
    public static void main(String[] args) {
        logic(3);
        logic(7);
        logic(15);
    }

    /**
     * Converts a number to its word representation using switch
     * @param inputNumber number to convert (supports 1-10)
     */
    public static void logic(int inputNumber) {
        switch (inputNumber) {
            case 1: System.out.println("ONE"); break;
            case 2: System.out.println("TWO"); break;
            case 3: System.out.println("THREE"); break;
            case 4: System.out.println("FOUR"); break;
            case 5: System.out.println("FIVE"); break;
            case 6: System.out.println("SIX"); break;
            case 7: System.out.println("SEVEN"); break;
            case 8: System.out.println("EIGHT"); break;
            case 9: System.out.println("NINE"); break;
            case 10: System.out.println("TEN"); break;
            default: System.out.println("Please enter a number between 1-10");
                break;
        }
    }
}
