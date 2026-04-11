package com.bootcampexcercise.module2.activity;

public class ArrayExample {
    public static void main(String[] args) {
        // Declare and initialize array
        int[] numbers = {10, 20, 30, 40, 50};

        // Print using traditional for loop
        System.out.println("Array elements (for loop):");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " : " + numbers[i]);
        }

        // Print using enhanced for loop
        System.out.println("\nArray elements (for-each):");
        for (int num : numbers) {
            System.out.println(num);
        }

        // Calculate sum and average
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double avg = (double) sum / numbers.length;

        System.out.println("\nSum    : " + sum);
        System.out.println("Average: " + avg);
    }
}
