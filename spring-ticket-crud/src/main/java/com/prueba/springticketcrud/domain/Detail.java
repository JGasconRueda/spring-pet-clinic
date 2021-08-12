package com.prueba.springticketcrud.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "details")
public class Detail extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "ticked_id")
    private Ticket ticket;

    public Detail() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Detail;
    }

}
