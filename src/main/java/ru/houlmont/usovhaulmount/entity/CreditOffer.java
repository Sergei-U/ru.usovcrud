//package ru.houlmont.usovhaulmount.entity;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.UUID;
//
///**
// *
// */
//
//
//@Entity
//@Table(name = "CREDIT_OFFER")
//@Data
//public class CreditOffer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID id;
//
//    @JoinColumn(name = "CLIENT_ID")
//    private Client client;
//
//    @JoinColumn(name = "CREDIT_ID")
//    private Credit credit;
//
//    @Column(name = "AMOUNT)
//            private BigDecimal amount;
//
//            @Embedded
//            @Convert(converter = CreditOffer.JpaJsonConverter.class)
//            @Column(name = "PAYMENT_SCHEDULE")
//            private PaymentSchedule paymentSchedule;
//
//
//            public static class JpaJsonConverter implements AttributeConverter<PaymentSchedule, String>{
//            private static ObjectMapper objectMapper=new ObjectMapper();
//
//            @Override
//            public String convertToDatabaseColumn(PaymentSchedule paymentSchedule){
//            try{
//            return objectMapper.writeValueAsString(paymentS);
//            }catch(JsonProcessingException e) {
//        throw new RuntimeException(e);
//    }
//
//}
//
//    @Override
//    public PaymentSchedule convertToEntityAttribute(String s) {
//        try {
//            return objectMapper.readValue(s, PaymentSchedule.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//}
