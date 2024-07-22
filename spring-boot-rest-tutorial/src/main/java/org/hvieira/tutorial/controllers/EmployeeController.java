package org.hvieira.tutorial.controllers;

import java.util.LinkedList;
import java.util.List;

import org.hvieira.tutorial.adapters.EmployeeRepository;
import org.hvieira.tutorial.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        // return "Hello!";
        List<Employee> employees = new LinkedList<>();
        
        employeeRepository.findAll().forEach(employees::add);

        // force load the lazy records
        employees.forEach(Employee::getPayrollRecords);

        return employees;
    }



}
