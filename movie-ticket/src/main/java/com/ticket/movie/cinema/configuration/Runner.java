package com.ticket.movie.cinema.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ticket.movie.cinema.model.MovieTicket;
import com.ticket.movie.cinema.service.MovieTicketService;

@Component
public class Runner implements CommandLineRunner{
  
  @Autowired
  private MovieTicketService movieTicketService;

  @Override
  public void run(String... args) throws Exception {
    MovieTicket movieTicket = new MovieTicket();
    movieTicket.setMovieDateTheaterId((long) 1);
    movieTicket.setSeatColumn(2);
    movieTicket.setSeatRow(3);

    this.movieTicketService.saveTickets(movieTicket);

    movieTicket.setSeatColumn(4);
    movieTicket.setSeatRow(5);

    this.movieTicketService.saveTickets(movieTicket);

    movieTicket.setSeatColumn(6);
    movieTicket.setSeatRow(7);
    this.movieTicketService.saveTickets(movieTicket);
  }
  
}
