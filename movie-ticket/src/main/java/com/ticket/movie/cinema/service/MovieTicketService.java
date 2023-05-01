package com.ticket.movie.cinema.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.movie.cinema.dto.MovieDateTheaterDto;
import com.ticket.movie.cinema.dto.MovieTicketDto;
import com.ticket.movie.cinema.model.MovieTicket;
import com.ticket.movie.cinema.repository.MovieTicketRepository;



@Service
public class MovieTicketService {
  
  @Autowired
  private MovieTicketRepository movieTicketRepository;

  @Autowired
  private MovieDateTheaterRestService movieDateTheaterRestService;

  public MovieTicketDto getMovieTicketDtoResponse(MovieTicket movieTicket){
    MovieDateTheaterDto movieDateTheaterDto = this.movieDateTheaterRestService.getMovieDateTheaterById(movieTicket.getMovieDateTheaterId());
    return null;

  }

 

}
