package org.hvieira.tutorial.adapters;

import java.util.UUID;

import org.hvieira.tutorial.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, UUID>{
    
    // TODO add date for filter
    // below is an example of a query
    // @Query("SELECT b FROM Book b WHERE b.publishDate > :date")
    // List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);
    // long accruedSalaryIncomeForEmployee(UUID employeeId)

}