package com.bootcampexcercise.module7;

// Custom exception class - extends Exception
public class CustomExceptionActivity extends Exception {

    @Override
    public String getMessage() {
        return "You are not allowed to use this program";
    }
}
