package com.prueba.springticketcrud.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Column(name = "totalAmount")
    private Double totalAmount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="ticket")
    private Set<Detail> details = new HashSet<>();

}
