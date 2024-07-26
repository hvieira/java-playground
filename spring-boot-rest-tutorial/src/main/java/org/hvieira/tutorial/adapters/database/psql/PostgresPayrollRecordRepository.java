package org.hvieira.tutorial.adapters.database.psql;

import org.hvieira.tutorial.adapters.PayrollRecordRepository;
import org.hvieira.tutorial.entities.PayrollRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Component("postgresPayrollRecordRepository")
public class PostgresPayrollRecordRepository implements PayrollRecordRepository {

    private final EntityManager entityManager;

    @Autowired
    public PostgresPayrollRecordRepository(JpaContext context) {
        this.entityManager = context.getEntityManagerByManagedType(PayrollRecord.class);
    }

    @Override
    @Transactional
    public PayrollRecord addRecord(PayrollRecord record) {
        entityManager.persist(record);
        return record;
    }
    
}
