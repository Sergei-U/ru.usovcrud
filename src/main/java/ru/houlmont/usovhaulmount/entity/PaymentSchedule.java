package ru.houlmont.usovhaulmount.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 */

@Data
public class PaymentSchedule {
    private LocalDate paymentDate;
    private BigDecimal paymentAmount;
    private BigDecimal paymentBodyCredit;
    private BigDecimal paymentPercentCredit;

    public PaymentSchedule() {
    }
}
