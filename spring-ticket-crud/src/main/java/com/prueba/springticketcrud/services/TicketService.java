package com.prueba.springticketcrud.services;

import com.prueba.springticketcrud.domain.Ticket;

import java.sql.Timestamp;

public interface TicketService extends CrudService<Ticket, Long> {
    Iterable<Ticket> findByRangeOfDate(Timestamp startDate, Timestamp endDate);
}
