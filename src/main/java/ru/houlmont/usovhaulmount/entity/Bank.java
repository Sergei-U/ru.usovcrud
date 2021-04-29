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
@Table(name = "BANK")
public class Bank {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", insertable = false, updatable = false)
    @ApiModelProperty(value = "ID банка")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    public Bank() {
    }
}
