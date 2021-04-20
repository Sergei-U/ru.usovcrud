package ru.houlmont.usovhaulmount.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 *
 */


@Entity
@Table(name = "CREDIT_OFFER")
@Data
public class CreditOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Client client;

    private Credit credit;
    private BigDecimal amount;
    @Embedded //Это аннотация говорит, что данное поле является вложженым в текущую сущность
    @Convert(converter = PaymentSchedule.JpaJsonConverter.class)
    //Этот конвертер нужно самому написать - смотри пример ниже
    private PaymentSchedule paymentSchedule;
}



class JpaJsonConverter implements AttributeConverter<Credit.PaymentSchedule, String> {
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
