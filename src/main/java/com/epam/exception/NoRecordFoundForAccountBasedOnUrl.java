package com.epam.exception;

public class NoRecordFoundForAccountBasedOnUrl extends Exception {
    public NoRecordFoundForAccountBasedOnUrl() {
        super("Oops! No Record Found For Input Url!!");
    }
}
