package com.bootcampexcercise.module6.activity;

import java.util.Scanner;

public class FindInArray {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 60, 70};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to search: ");
        int target = sc.nextInt();

        boolean found = false;
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                index = i;
                break;
            }
        }

        if (found) {
            System.out.println("Number " + target + " found at index " + index);
        } else {
            System.out.println("Number " + target + " not found in the array");
        }
        sc.close();
    }
}
