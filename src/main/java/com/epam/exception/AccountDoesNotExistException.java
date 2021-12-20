package com.epam.exception;

public class AccountDoesNotExistException extends Exception {
    public AccountDoesNotExistException() {
        super("Oops! No Account Found!!");
    }
}
