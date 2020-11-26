package com.interview.employeeskills.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
