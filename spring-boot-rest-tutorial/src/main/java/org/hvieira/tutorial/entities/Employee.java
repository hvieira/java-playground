package org.hvieira.tutorial.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int monthlySalary;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id")
    // ignore this property so it is not serialized to JSON (which triggers the fetch from the DB)
    @JsonIgnore
    private List<PayrollRecord> payrollRecords;

    // JPA constructor
    protected Employee(){}

    public Employee(UUID id, String name, int monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public List<PayrollRecord> getPayrollRecords() {
        return payrollRecords;
    }
   
}
