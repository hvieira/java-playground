package org.hvieira.tutorial.exceptions;

import java.util.UUID;

public class EmployeeDoesNotExistException extends RuntimeException {

    public final UUID employeeId;

    public EmployeeDoesNotExistException(UUID employeeId) {
        super(String.format("Employee %s does not exist", employeeId));
        this.employeeId = employeeId;
    }
}
