package com.bootcampexcercise.module5;

import java.util.Scanner;

public class NumToWordsWithMethodCalling {

    public static String convertToWords(int num) {
        String[] words = {"Zero", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine"};
        if (num < 0 || num > 9) {
            return "Out of range (only 0-9 supported)";
        }
        return words[num];
    }

    public static String convertNumberToWords(int number) {
        if (number == 0) return "Zero";
        String result = "";
        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            result += convertToWords(digit) + " ";
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println("In words: " + convertNumberToWords(number));
        sc.close();
    }
}
