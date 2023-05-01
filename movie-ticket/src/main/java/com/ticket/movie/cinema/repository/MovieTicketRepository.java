package com.ticket.movie.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticket.movie.cinema.model.MovieTicket;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Long> {
  
}
