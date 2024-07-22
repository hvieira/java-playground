package org.hvieira.tutorial.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

public record PayrollRecordId(UUID employeeId, OffsetDateTime paymentDate) {
    
}
