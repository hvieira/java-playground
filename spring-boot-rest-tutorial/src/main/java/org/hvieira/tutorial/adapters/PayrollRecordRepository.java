package org.hvieira.tutorial.adapters;

import org.hvieira.tutorial.entities.PayrollRecord;
import org.hvieira.tutorial.entities.PayrollRecordId;
import org.springframework.data.repository.CrudRepository;

public interface PayrollRecordRepository extends CrudRepository<PayrollRecord, PayrollRecordId>{
    
    // TODO add date for filter
    // below is an example of a query
    // @Query("SELECT b FROM Book b WHERE b.publishDate > :date")
    // List<Book> findByPublishedDateAfter(@Param("date") LocalDate date);
    // long accruedSalaryIncomeForEmployee(UUID employeeId)

}
