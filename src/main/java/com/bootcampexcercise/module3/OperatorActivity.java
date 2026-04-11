package com.bootcampexcercise.module3;

import java.util.Scanner;

public class OperatorActivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        // Arithmetic operators
        System.out.println("---- Arithmetic Operators ----");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (b != 0 ? (a / b) : "undefined"));
        System.out.println("a % b = " + (b != 0 ? (a % b) : "undefined"));

        // Relational operators
        System.out.println("---- Relational Operators ----");
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));

        // Logical operators
        System.out.println("---- Logical Operators ----");
        System.out.println("(a > 0 && b > 0): " + (a > 0 && b > 0));
        System.out.println("(a > 0 || b > 0): " + (a > 0 || b > 0));

        sc.close();
    }
}
