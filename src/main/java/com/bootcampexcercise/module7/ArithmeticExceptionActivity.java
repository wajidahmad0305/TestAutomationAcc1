package com.bootcampexcercise.module7;

public class ArithmeticExceptionActivity {

    public static void main(String[] args) {
        ArithmeticExceptionActivity obj = new ArithmeticExceptionActivity();

        System.out.println("---- First call: catchMe(10, 0) ----");
        obj.catchMe(10, 0);

        System.out.println("\n---- Second call: catchMe(10, 2) ----");
        obj.catchMe(10, 2);
    }

    void catchMe(int num1, int num2) {
        try {
            int result = num1 / num2;
            System.out.println("Result of " + num1 + " / " + num2 + " = " + result);
        } catch (ArithmeticException a) {
            System.out.println("ArithmeticException caught: " + a.getMessage());
            System.out.println("You cannot divide a number by zero.");
        } finally {
            System.out.println("Thank you for using this program.");
        }
    }
}

