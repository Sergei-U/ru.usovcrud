package ru.houlmont.usovhaulmount.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
@Entity
@Data
@Table(name = "CREDIT")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID кредита")
    private UUID id;

    @Column(name = "CREDIT_NAME")
    @ApiModelProperty(value = "Имя кредита")
    private String creditName;

    @Column(name = "CREDIT_LIMIT")
    @ApiModelProperty(value = "Лимит по кредиту")
    private double creditLimit;

    @Column(name = "CREDIT_VALIDITY")
    @ApiModelProperty(value = "Количество месяцев на которое выдан кредит")
    private int creditValidity;

    @Column(name = "CREDIT_RATE")
    @ApiModelProperty(value = "Процентная ставка")
    private double creditRate;

    @Column(name = "CREDIT_START_DATE")
    @ApiModelProperty(value = "Дата начала кредита")
    private Date creditStartDate;


    public class PaymentSchedule {
        private LocalDate paymentDate;
        private BigDecimal paymentAmount;
        private BigDecimal paymentBodyCredit;
        private BigDecimal paymentPercentCredit;
    }

    public class CreditOffer {
        private UUID id;
        private Client client;
        private Credit credit;
        private BigDecimal amount;
        @Embedded //Это аннотация говорит, что данное поле является вложженым в текущую сущность
        @Convert(converter = PaymentSchedule.JpaJsonConverter.class)
        //Этот конвертер нужно самому написать - смотри пример ниже
        private PaymentSchedule paymentSchedule;
    }
    public class JpaJsonConverter implements AttributeConverter<Credit.PaymentSchedule, String> {
        private static ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public String convertToDatabaseColumn(Credit.PaymentSchedule paymentSchedule) {
            try {
                return objectMapper.writeValueAsString(credit);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Credit.PaymentSchedule convertToEntityAttribute(String s) {
            try {
                return objectMapper.readValue(s, Credit.PaymentSchedule.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


}
