package com.interview.employeeskills.exceptions;

/**
 * Custom Employee Not Found Exception.
 * @author Jeff Ceja
 */
public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
