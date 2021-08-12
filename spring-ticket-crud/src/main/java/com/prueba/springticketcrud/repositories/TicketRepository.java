package com.prueba.springticketcrud.repositories;

import com.prueba.springticketcrud.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Iterable<Ticket> findByRangeOfDate(Timestamp startDate, Timestamp endDate);

}
