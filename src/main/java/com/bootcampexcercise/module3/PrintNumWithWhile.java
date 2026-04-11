package com.bootcampexcercise.module3;

import java.util.Scanner;

public class PrintNumWithWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int n = sc.nextInt();

        System.out.println("Numbers from 1 to " + n + ":");
        int i = 1;
        while (i <= n) {
            System.out.println(i);
            i++;
        }
        sc.close();
    }
}
