package org.hvieira.tutorial.web.controllers;

import java.util.UUID;

import org.hvieira.tutorial.entities.PayrollRecord;
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
    public PayrollRecord payEmployee(@PathVariable UUID employeeId) {
        return payroll.payEmployee(employeeId);
    }

}
