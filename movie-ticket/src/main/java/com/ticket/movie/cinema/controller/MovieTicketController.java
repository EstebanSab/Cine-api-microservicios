package com.ticket.movie.cinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticket.movie.cinema.dto.MovieTicketDto;
import com.ticket.movie.cinema.service.MovieTicketService;

@RestController
@RequestMapping(path = "/v1/movie/ticket")
public class MovieTicketController {
  
  @Autowired
  private MovieTicketService movieTicketService;




  @GetMapping("/{ticketId}")
  public MovieTicketDto getMovieById(@PathVariable("ticketId") Long ticketId){
    return null;
  }



  @PostMapping
  public MovieTicketDto createNewTicket(@PathVariable("movieDateTheaterId") Long movieDateTheaterId){
    return null;
  }

 

  }


