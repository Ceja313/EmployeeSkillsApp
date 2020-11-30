package com.interview.employeeskills.exceptions;

/**
 * Custom invalid employee data exception.
 * @author Jeff Ceja
 */
public class InvalidEmployeeDataException extends RuntimeException {

    public InvalidEmployeeDataException(String errorMessage) {
        super(errorMessage);
    }

}
