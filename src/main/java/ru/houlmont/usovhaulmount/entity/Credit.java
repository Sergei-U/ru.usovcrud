package ru.houlmont.usovhaulmount.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", insertable = false, updatable = false)
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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Дата начала кредита")
    private Date creditStartDate;



}
