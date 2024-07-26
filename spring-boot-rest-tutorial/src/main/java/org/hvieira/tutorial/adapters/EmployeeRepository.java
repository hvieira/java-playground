package org.hvieira.tutorial.adapters;

import java.util.UUID;

import org.hvieira.tutorial.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, UUID>{

}