package org.hvieira.tutorial.adapters;

import org.hvieira.tutorial.entities.PayrollRecord;
import org.hvieira.tutorial.entities.PayrollRecordId;
import org.springframework.data.repository.CrudRepository;

public interface PayrollRecordRepository extends CrudRepository<PayrollRecord, PayrollRecordId>{

    /**
     * NOTE: the save method from the base class performs the following:
     * By default Spring Data JPA inspects the identifier property of the given entity. 
     * If the identifier property is null, then the entity will be assumed as new, otherwise as not new.
     * 
     * i.e. given the schema we need to provide the employee ID to the payroll record which means
     * JPA will query the payroll table to check if the record is new or needs update (as in the reason it queries the DB to decide)
     * This could be solved by a payroll_record having an ID which is not composite, but that feels like it's just adding a column for no good reason
     */

}
