package com.bootcampexcercise.module7;

public class TryCatchFinallyActivity {

    public static void main(String[] args) {
        // call catchMeIfYouCan
        TryCatchFinallyActivity obj = new TryCatchFinallyActivity();
        obj.catchMeIfYouCan();
    }

    void catchMeIfYouCan() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        try {
            // Intentionally going out of bounds (i <= 10 instead of i < 10)
            for (int i = 0; i <= 10; i++) {
                System.out.println("arr[" + i + "] = " + arr[i]);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! You tried to access an index that does not exist in the array.");
            System.out.println("Exception details: " + e.getMessage());
        } finally {
            System.out.println("Finally block: This always runs whether or not an error occurred.");
        }
    }
}
