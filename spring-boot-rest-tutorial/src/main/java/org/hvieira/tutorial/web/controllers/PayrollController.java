package org.hvieira.tutorial.web.controllers;

import java.util.UUID;

import org.hvieira.tutorial.entities.PayrollRecord;
import org.hvieira.tutorial.exceptions.EmployeeDoesNotExistException;
import org.hvieira.tutorial.features.Payroll;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PayrollController {
    
    private Payroll payroll;

    public PayrollController(Payroll payroll) {
        this.payroll = payroll;
    }

    @PostMapping("/employees/{employeeId}/pay")
    public PayrollRecord payEmployee(@PathVariable UUID employeeId) {
        try {
            return payroll.payEmployee(employeeId);
        } catch(EmployeeDoesNotExistException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, 
                String.format("Employee %s does not exist", e.employeeId)
            );
        }
    }

}
