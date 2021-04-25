package ru.houlmont.usovhaulmount.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity
@Data
@Table(name = "BANK")
public class Bank {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    @ApiModelProperty(value = "ID банка")
    private String id;



    @OneToMany(mappedBy = "id")
    private List<Client> clientList;

    @OneToMany(mappedBy = "id")
    private List<Credit> creditList;
}
