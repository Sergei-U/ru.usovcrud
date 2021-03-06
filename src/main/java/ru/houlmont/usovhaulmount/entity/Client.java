package ru.houlmont.usovhaulmount.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", insertable = false, updatable = false)
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
    private Long telephoneNumber;

    @Column(name = "EMAIL")
    @ApiModelProperty(value = "Имя электронной почты клиента")
    private String email;

    @Column(name = "SERIAL_PASSPORT")
    @ApiModelProperty(value = "Серия пасспорта клиента")
    private int serialPassport;

    @Column(name = "NUMBER_PASSPORT")
    @ApiModelProperty(value = "Номер пасспорта клиента")
    private Long numberPassport;

    @OneToMany(mappedBy = "id")
    @ApiModelProperty(value = "Список кредитов клиента")
    private List<Credit> creditClientList;


    public Client() {
    }


    public Client(String firstName, String lastName, String thirdName, Long telephoneNumber, String email, int serialPassport, Long numberPassport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.serialPassport = serialPassport;
        this.numberPassport = numberPassport;
    }
}
