package org.hvieira.tutorial.features;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;

import org.hvieira.tutorial.adapters.EmployeeRepository;
import org.hvieira.tutorial.adapters.PayrollRecordRepository;
import org.hvieira.tutorial.entities.Employee;
import org.hvieira.tutorial.entities.PayrollRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class Payroll {

    private EmployeeRepository employeeRepository;
    private PayrollRecordRepository payrollRecordRepository;

    @Autowired
    public Payroll(EmployeeRepository employeeRepository, PayrollRecordRepository payrollRecordRepository) {
        this.employeeRepository = employeeRepository;
        this.payrollRecordRepository = payrollRecordRepository;
    }

    public PayrollRecord payEmployee(UUID employeeId) {
        return employeeRepository.findById(employeeId)
        .map(this::performSalaryPayment)
        // TODO this exception type should be used by the controller and not the "feature"
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            String.format("Employee %s does not exist", employeeId)));
    }

    private PayrollRecord performSalaryPayment(Employee employee) {
        // TODO check that the employee has not been paid this month

        PayrollRecord record = new PayrollRecord(employee.getId(), OffsetDateTime.now(ZoneOffset.UTC), employee.getMonthlySalary());
        return payrollRecordRepository.save(record);
    }

}
