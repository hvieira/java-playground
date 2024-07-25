package org.hvieira.tutorial.web.controllers;

import java.util.LinkedList;
import java.util.List;

import org.hvieira.tutorial.adapters.EmployeeRepository;
import org.hvieira.tutorial.entities.Employee;
import org.hvieira.tutorial.entities.requests.CreateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        List<Employee> employees = new LinkedList<>();
        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody CreateEmployeeRequest request) {
        Employee result = employeeRepository.save(new Employee(null, request.name(), request.monthlySalary()));
        return result;
    }


}
