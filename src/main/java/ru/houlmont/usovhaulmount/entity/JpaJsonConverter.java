package ru.houlmont.usovhaulmount.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 *
 */
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
