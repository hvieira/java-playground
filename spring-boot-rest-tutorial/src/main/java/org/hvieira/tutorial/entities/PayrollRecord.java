package org.hvieira.tutorial.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PayrollRecordId.class)
public class PayrollRecord {

    @Id
    // the @Column annotation is needed because the composite key does not map to "id" which is used in the employee table
    // one way to solve this would be to change the column employee.id to employee.employee_id which would then match this column name in this table
    @Column(name = "employee_id")
    private UUID employeeId;
    @Id
    // TODO try to make the DB generate the value for this column, since relying on the DB timezone is likely the better solution
    // @Generated
    private OffsetDateTime paymentDate;
    private int amount;

    protected PayrollRecord() {
    }

    public PayrollRecord(UUID employeeId, OffsetDateTime paymentDate, int amount) {
        this.employeeId = employeeId;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public OffsetDateTime getPaymentDate() {
        return paymentDate;
    }

    public int getAmount() {
        return amount;
    }

}
