package com.interview.employeeskills.exceptions;

public class InvalidEmployeeDataException extends RuntimeException {

    public InvalidEmployeeDataException(String errorMessage) {
        super(errorMessage);
    }

}
