package org.hvieira.tutorial.controllers;

import java.util.UUID;

import org.hvieira.tutorial.features.Payroll;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayrollController {
    
    private Payroll payroll;

    public PayrollController(Payroll payroll) {
        this.payroll = payroll;
    }

    @PostMapping("/employees/{employeeId}/pay")
    public String payEmployee(@PathVariable UUID employeeId) {
        return payroll.payEmployee(employeeId);
    }

}
