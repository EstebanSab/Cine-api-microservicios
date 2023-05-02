package com.ticket.movie.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.movie.cinema.model.MovieTicket;

public interface MovieTicketRepository extends JpaRepository<MovieTicket,Long> {

  @Transactional
  @Query(value = "select * from movie_ticket where movie_date_theater_id = ?1",
  nativeQuery = true)
  List<MovieTicket> findAllByIdOfMovieDateTheater(Long id);
  
}
