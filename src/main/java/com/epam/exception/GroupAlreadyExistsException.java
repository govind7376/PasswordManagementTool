package com.epam.exception;

public class GroupAlreadyExistsException extends Exception {
    public GroupAlreadyExistsException(){
        super("Oops! Group already exists!!");
    }
}
