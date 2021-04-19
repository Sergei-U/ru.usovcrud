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
@Table(name = "BANK")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Id bank")
    private UUID id;


    @OneToMany(mappedBy = "id")
    private List<Client> clientList;

    @OneToMany(mappedBy = "id")
    private List<Credit> creditList;
}
