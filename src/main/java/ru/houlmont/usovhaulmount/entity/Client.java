package ru.houlmont.usovhaulmount.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Entity
@Data
@Table(name = "CLIENT")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID клиента")
    private UUID id;


    @Column(name = "FIRST_NAME")
    @ApiModelProperty(value = "Имя клиента")
    private String firstName;

    @Column(name = "LAST_NAME")
    @ApiModelProperty(value = "Фамиилия клиента")
    private String lastName;

    @Column(name = "THIRD_NAME")
    @ApiModelProperty(value = "Отчество клиента")
    private String thirdName;

    @Column(name = "TELEPHONE_NUMBER")
    @ApiModelProperty(value = "Номер телефона клиента")
    private int telephoneNumber;

    @Column(name = "EMAIL")
    @ApiModelProperty(value = "Имя электронной почты клиента")
    private String email;

    @Column(name = "SERIAL_PASSPORT")
    @ApiModelProperty(value = "Серия пасспорта клиента")
    private int serialPassport;

    @Column(name = "NUMBER_PASSPORT")
    @ApiModelProperty(value = "Номер пасспорта клиента")
    private int numberPassport;

    @OneToMany(mappedBy = "id")
    @ApiModelProperty(value = "Список кредитов клиента")
    private List<Credit> creditClientList;
}
